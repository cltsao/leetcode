public class LongestHappyPrefix {
    public String longestPrefix(String s) {
        int i = 1, j = 0;
        int[] kmp = new int[s.length()];
        kmp[0] = 0;
        while(i < s.length()) {
            if(s.charAt(i) == s.charAt(j)) {
                kmp[i] = kmp[i-1] + 1;
                ++i;
                ++j;
            } else {
                while(j > 0) {
                    j = kmp[j - 1];
                    if (s.charAt(j) == s.charAt(i)) {
                        kmp[i] = j + 1;
                        ++j;
                        break;
                    }
                }
                if (j == 0 && s.charAt(0) == s.charAt(i)) {
                    kmp[i] = 1;
                    ++j;
                }
                ++i;
            }
        }
        return s.substring(s.length() - kmp[s.length() - 1]);
    }
}
