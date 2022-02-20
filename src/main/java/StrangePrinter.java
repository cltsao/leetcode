import java.util.*;

public class StrangePrinter {
    public int strangePrinter(String s) {
        // Remove duplicate characters
        StringBuilder deDupString = new StringBuilder();
        char lastChar = ' ';
        for(char c : s.toCharArray())
            if(c != lastChar) {
                lastChar = c;
                deDupString.append(c);
            }
        s = deDupString.toString();

        // fromIndex, toIndex
        int strLen = s.length();
        int[][] dp = new int[strLen][strLen];
        for(int pos = 0; pos < strLen; ++pos)
            Arrays.fill(dp[pos], strLen); // worst case is to print each character separately

        for(int pos = 0; pos < strLen; ++pos) {
            dp[pos][pos] = 1;
        }

        for(int length = 2; length <= strLen; ++length) {
            // Combine two subStrings dp[from][to] = dp[from][mid] + dp[mid+1][to]; if s[mid]==s[to] then save one print
            for(int from = 0; from <= strLen - length; ++from) {
                int to = from + length - 1;
                for(int mid = from; mid < to; ++mid) {
                    if (s.charAt(mid) == s.charAt(to)) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][mid] + dp[mid+1][to] - 1);
                    } else {
                        dp[from][to] = Math.min(dp[from][to], dp[from][mid] + dp[mid+1][to]);
                    }
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
