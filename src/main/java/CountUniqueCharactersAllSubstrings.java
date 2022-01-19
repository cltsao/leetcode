import java.util.Arrays;

public class CountUniqueCharactersAllSubstrings {
    public int uniqueLetterString(String s) {
        int uniqueCharCount = 0;
        // Dynamic programming: find the range of start and end position of a substring that a character only appear once; in other words, same character doesn't appear
        int[] startRange = new int[s.length()];
        int[] endRange = new int[s.length()];

        // Start range is either 0 or next to previous occurrence of the same character
        int[] prevCharPos = new int[26];
        Arrays.fill(prevCharPos, -1);
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            startRange[i] = prevCharPos[c - 'A'] + 1;
            prevCharPos[c - 'A'] = i;
        }

        // End range is either s.length - 1 or ahead of next occurrence of the same character
        int[] nextCharPos = new int[26];
        Arrays.fill(nextCharPos, s.length());
        for(int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            endRange[i] = nextCharPos[c - 'A'] - 1;
            nextCharPos[c - 'A'] = i;
        }

        // Each character is unique in any substring starting at [start range, index] and end at [index, end range]
        for(int i = 0; i < s.length(); ++i) {
            uniqueCharCount += (i - startRange[i] + 1) * (endRange[i] - i + 1);
        }

        return uniqueCharCount;
    }
}
