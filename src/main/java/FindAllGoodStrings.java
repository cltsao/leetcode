public class FindAllGoodStrings {
    int[] kmp(String pattern) {
        int N = pattern.length();
        int[] A = new int[N];
        int i = 1, j = 0;
        for(; i < N; ++i) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
               A[i] = j + 1;
               ++j;
            } else {
                while(j > 0) {
                    j = A[j-1];
                    if (pattern.charAt(j) == pattern.charAt(i)) {
                        A[i] = j + 1;
                        ++j;
                        break;
                    }
                }
                if (j == 0 && pattern.charAt(0) == pattern.charAt(i)) {
                    A[i] = 1;
                    ++j;
                }
            }
        }
        return A;
    }

    // Map from prefix length + char to new prefix length
    int[][] evilTransition(String evil) {
        int[][] E = new int[evil.length()][26];
        int[] kmp = kmp(evil);
        E[0][evil.charAt(0) - 'a'] = 1;
        for(int i = 1; i < evil.length(); ++i) {
            E[i][evil.charAt(0) - 'a'] = 1;
            if (kmp[i-1] > 0)
                E[i][evil.charAt(kmp[i-1]) - 'a'] = kmp[i-1]+1;
            E[i][evil.charAt(i) - 'a'] = i + 1;
        }
        return E;
    }

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        // DP index
        // 0: position from 0 to n-1
        // 1: 1 if current string is a prefix of s1
        // 2: 1 if current string is a prefix of s2
        // 3: max length of a suffix that is a prefix of evil
        long[][][][] dp = new long[n + 1][2][2][evil.length() + 1];

        int[][] E = evilTransition(evil);

        // Initial state
        if (s1.charAt(0) == s2.charAt(0)) {
            if (s1.charAt(0) == evil.charAt(0)) {
                dp[0][1][1][1] = 1;
            } else {
                dp[0][1][1][0] = 1;
            }
        } else {
            if (s1.charAt(0) == evil.charAt(0)) {
                dp[0][1][0][1] = 1;
            } else {
                dp[0][1][0][0] = 1;
            }

            if (s2.charAt(0) == evil.charAt(0)) {
                dp[0][0][1][1] = 1;
            } else {
                dp[0][0][1][0] = 1;
            }

            if (s1.charAt(0) < evil.charAt(0) && evil.charAt(0) < s2.charAt(0)) {
                dp[0][0][0][1] = 1;
                dp[0][0][0][0] = s2.charAt(0) - s1.charAt(0) - 2;
            } else {
                dp[0][0][0][0] = s2.charAt(0) - s1.charAt(0) - 1;
            }
        }

        // State transition
        // dp[i-1][T][T] -> dp[i][T][T], dp[i][T][F], dp[i][F][T], or dp[i][F][F] based on s.charAt(i)
        // dp[i-1][T][F] -> dp[i][T][F] or dp[i][F][F] based on s.charAt(i)
        // dp[i-1][F][T] -> dp[i][F][T] or dp[i][F][F] based on s.charAt(i)
        // dp[i-1][F][T] -> dp[i][F][F]
        // dp[i-1][*][*][k] -> dp[i][*][*][k'] based on evil transition
        final int mod = 1000000007;
        for(int i = 1; i < n; ++i) {
            for(int k = 0; k < evil.length(); ++k) {
                for(char c = 'a'; c <= 'z'; ++c) {
                    // Some characters match prefix while most transit to prefix length 0
                    dp[i][0][0][E[k][c-'a']] = (dp[i][0][0][E[k][c-'a']] + dp[i-1][0][0][k]) % mod;

                    // For prefix of s1, only character that is equal or greater contribute to state transition
                    if (c == s1.charAt(i)) {
                        dp[i][1][0][E[k][c-'a']] = (dp[i][1][0][E[k][c-'a']] + dp[i-1][1][0][k]) % mod;
                    } else if (c > s1.charAt(i)) {
                        dp[i][0][0][E[k][c-'a']] = (dp[i][0][0][E[k][c-'a']] + dp[i-1][1][0][k]) % mod;
                    }

                    // For prefix of s2, only character that is equal or less contribute to state transition
                    if (c == s2.charAt(i)) {
                        dp[i][0][1][E[k][c-'a']] = (dp[i][0][1][E[k][c-'a']] + dp[i-1][0][1][k]) % mod;
                    } else if (c < s2.charAt(i)) {
                        dp[i][0][0][E[k][c-'a']] = (dp[i][0][0][E[k][c-'a']] + dp[i-1][0][1][k]) % mod;
                    }

                    // For prefix of both s1 and s2, only character that is between them contribute to state transition
                    if (s1.charAt(i) == s2.charAt(i)) {
                        if (c == s1.charAt(i)) {
                            dp[i][1][1][E[k][c-'a']] = (dp[i][1][1][E[k][c-'a']] + dp[i-1][1][1][k]) % mod;
                        }
                    } else {
                        if (c > s1.charAt(i) && c < s2.charAt(i)) {
                            dp[i][0][0][E[k][c-'a']] = (dp[i][0][0][E[k][c-'a']] + dp[i-1][1][1][k]) % mod;
                        } else if (c == s1.charAt(i)) {
                            dp[i][1][0][E[k][c-'a']] = (dp[i][1][0][E[k][c-'a']] + dp[i-1][1][1][k]) % mod;
                        } else if (c == s2.charAt(i)) {
                            dp[i][0][1][E[k][c-'a']] = (dp[i][0][1][E[k][c-'a']] + dp[i-1][1][1][k]) % mod;
                        }
                    }
                }
            }
        }

        long total = 0;
        for(int k = 0; k < evil.length(); ++k) {
            total = (total + dp[n-1][0][0][k] + dp[n-1][0][1][k] + dp[n-1][1][0][k] + dp[n-1][1][1][k]) % mod;
        }
        return (int)total;
    }
}
