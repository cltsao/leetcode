public class MinimumWindowSubsequence {
    public String minWindow(String s1, String s2) {
        if (s1.length() < s2.length()) return "";

        // Max start such that [start, i] contains [0, j] of s
        short[][] dp = new short[s1.length()][s2.length()];

        for(int j = 0; j < s2.length(); ++j) {
            for(int i = 0; i < j; ++i) {
                dp[i][j] = -1;
            }
            for(int i = j; i < s1.length(); ++i) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (j == 0) {
                        dp[i][j] = (short)i;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (i == 0) {
                        dp[i][j] = -1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        String minWindow = "";
        int minWindowSize = Integer.MAX_VALUE;
        for(int i = 0; i < s1.length(); ++i) {
            if (dp[i][s2.length() - 1] >= 0) {
                int windowSize = i - dp[i][s2.length() - 1] + 1;
                if (windowSize < minWindowSize) {
                    minWindowSize = windowSize;
                    minWindow = s1.substring(dp[i][s2.length() - 1], i + 1);
                }
            }
        }
        return minWindow;
    }
}
