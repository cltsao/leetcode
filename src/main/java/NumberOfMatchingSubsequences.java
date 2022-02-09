import java.util.*;

public class NumberOfMatchingSubsequences {
    class Substring {
        String str;
        int pos;
        Substring(String str) {
            this.str = str;
            pos = 0;
        }

        @Override
        public String toString() {
            return str + "/" + pos + "=" + str.substring(pos);
        }
    }

    // Traverse S only once: O(S * W/26)
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<Substring>> wordMap = new HashMap<>();
        for(char c = 'a'; c <= 'z'; ++c) wordMap.put(c, new LinkedList<>());
        for(String word : words) {
            wordMap.get(word.charAt(0)).addLast(new Substring(word));
        }

        int count = 0;
        for(char c : s.toCharArray()) {
            Deque<Substring> matchedWords = wordMap.get(c);
            int size = matchedWords.size();
            for(int i = 0; i < size; ++i) {
                Substring substring = matchedWords.removeFirst();
                ++substring.pos;
                if (substring.pos == substring.str.length())
                    ++count;
                else
                    wordMap.get(substring.str.charAt(substring.pos)).addLast(substring);
            }
        }
        return count;
    }

    boolean isSubseq(String s, String word) {
        int pos = -1;
        for(int i = 0; i < word.length(); ++i) {
            pos = s.indexOf(word.charAt(i), pos + 1);
            if (pos < 0) return false;
        }
        return true;
    }

    // Simple comparison: O(W * S)
    public int numMatchingSubseqSimple(String s, String[] words) {
        int count = 0;
        for(String word : words) {
            if (isSubseq(s, word)) ++count;
        }
        return count;
    }
}
