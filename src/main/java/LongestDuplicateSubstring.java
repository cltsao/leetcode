import java.util.HashMap;
import java.util.Map;

public class LongestDuplicateSubstring {
    static final int hashExponent = 31;

    private boolean checkDupSubstring(String s, int length, int pos1, int pos2) {
        for(int i = 0; i < length; ++i) {
            if (s.charAt(pos1 + i) != s.charAt(pos2 + i)) return false;
        }
        return true;
    }

    private int findDupSubstring(String s, int length) {
        if (length >= s.length()) return -1;

        Map<Integer, Integer> hashToIndex = new HashMap<>();
        int topExponent = 1;
        int hashCode = 0;
        for(int i = 0; i < length; ++i) {
            hashCode = hashCode * hashExponent + s.charAt(i);
            topExponent *= hashExponent;
        }
        hashToIndex.put(hashCode, 0);
        for(int i = 1; i <= s.length() - length; ++i) {
            hashCode = hashCode * hashExponent - s.charAt(i - 1) * topExponent + s.charAt(i + length - 1);
            if (hashToIndex.containsKey(hashCode)) {
                if (checkDupSubstring(s, length, hashToIndex.get(hashCode), i)) {
                    return i;
                } else {
                    System.err.println("Found conflicting hashCode of length " + length + " at " + hashToIndex.get(hashCode) + " and " + i);
                }
            } else {
                hashToIndex.put(hashCode, i);
            }
        }
        return -1;
    }

    public String longestDupSubstring(String s) {
        int min = 0;  // Last length that dupSubstrings are found
        int max = 1;
        int pos = 0;
        int res;
        while((res = findDupSubstring(s, max)) >= 0) {
            min = max;
            max *= 2;
            pos = res;
        }
        while(max > min + 1) {
            int mid = (max + min) / 2;
            res = findDupSubstring(s, mid);
            if (res >= 0) {
                min = mid;
                pos = res;
            } else {
                max = mid;
            }
        }
        return s.substring(pos, pos + min);
    }
}
