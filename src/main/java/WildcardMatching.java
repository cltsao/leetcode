public class WildcardMatching {
    private boolean match(String s, int sPos, String p, int pPos) {
        System.out.println("match(sPos=" + sPos + ", pPos=" + pPos + ")");
        while(sPos < s.length() || pPos < p.length()) {
            if (pPos == p.length()) return false;  // pattern ends before str
            switch (p.charAt(pPos)) {
                case '?':
                    if (sPos >= s.length()) return false;  // str ends before pattern
                    ++pPos;
                    ++sPos;
                    break;
                case '*':
                    if (pPos == p.length() - 1) return true;  // Match rest of string
                    // DFS by next char
                    while(++pPos < p.length()) {
                        switch(p.charAt(pPos)) {
                            case '?':
                                ++sPos;  // *? matches with 1+ characters
                                continue;
                            case '*':
                                continue;  // ** is the same as *
                            default:
                                while((sPos = s.indexOf(p.charAt(pPos), sPos)) >= 0) {
                                    if(match(s, sPos + 1, p, pPos + 1))
                                        return true;
                                    else
                                        ++sPos;
                                }
                                return false;
                        }
                    }
                    return sPos <= s.length();  // ex. *? matches with 1+ characters
                default:
                    if (sPos >= s.length() || s.charAt(sPos) != p.charAt(pPos)) return false;  // str ends before pattern or characters mismatch
                    ++pPos;
                    ++sPos;
                    break;
            }
        }
        return true;  // reaching the end of both strings
    }

    public boolean isMatchDFS(String s, String p) {
        return match(s, 0, p, 0);
    }

    // Backtrack only to last star
    public boolean isMatchBacktrack(String s, String p) {
        int sPos = 0;
        int pPos = 0;
        int starIndex = -1;
        int lastSPos = 0;
        while(pPos < p.length() || sPos < s.length()) {
            if (sPos < s.length() && pPos < p.length() && (p.charAt(pPos) == '?' || p.charAt(pPos) == s.charAt(sPos))) {
                ++pPos;
                ++sPos;
            } else if (pPos < p.length() && p.charAt(pPos) == '*') {
                if (pPos == p.length() - 1) return true;  // Match rest of string
                starIndex = pPos;
                lastSPos = sPos;
                ++pPos;
            } else if (starIndex != -1 && lastSPos < s.length()) {
                // Backtrack to the last star and try next sPos from the last one
                sPos = ++lastSPos;
                pPos = starIndex + 1;
            } else {
                return false;
            }
        }
        return true;  // reaching end of both str and pattern
    }

    // DP
    public boolean isMatch(String s, String p) {
        // True if pattern[0,i] matches with str[0,j]
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for(int j = 1; j <= s.length(); ++j)
            dp[0][j] = false;
        for(int i = 1; i <= p.length(); ++i) {
            switch(p.charAt(i - 1)) {
                case '?':
                    dp[i][0] = false;
                    for(int j = 1; j <= s.length(); ++j) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    break;
                case '*':
                    dp[i][0] = dp[i-1][0];
                    for(int j = 1; j <= s.length(); ++j) {
                        dp[i][j] = dp[i][j-1] || dp[i-1][j];  // Use * to match j's character in str; don't use * to match j's character in str
                    }
                    break;
                default:
                    dp[i][0] = false;
                    for(int j = 1; j <= s.length(); ++j) {
                        if (p.charAt(i - 1) == s.charAt(j - 1))
                            dp[i][j] = dp[i-1][j-1];
                        else
                            dp[i][j] = false;
                    }
            }
        }
        return dp[p.length()][s.length()];
    }
}
