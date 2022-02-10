import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        // Word length -> Map from word to chain length
        SortedMap<Integer, Map<String, Integer>> wordMap = new TreeMap<>();
        for(String word :  words) {
            if (!wordMap.containsKey(word.length())) wordMap.put(word.length(), new HashMap<>());
            wordMap.get(word.length()).put(word, 0);
        }
        int maxChainLength = 1;
        Map<String, Integer> predecessors = null;
        for(int length = wordMap.firstKey(); length <= wordMap.lastKey(); ++length) {
            Map<String, Integer> wordsOfLength = wordMap.get(length);
            for(Map.Entry<String, Integer> word : wordsOfLength.entrySet()) {
                int chainLength = 1;
                if (predecessors != null)
                    for(Map.Entry<String, Integer> predecessor : predecessors.entrySet()) {
                        if (matchPredecessor(predecessor.getKey(), word.getKey()))
                            chainLength = Math.max(chainLength, predecessor.getValue() + 1);
                    }
                maxChainLength = Math.max(maxChainLength, chainLength);
                word.setValue(chainLength);
            }
            predecessors = wordsOfLength;
        }

        return maxChainLength;
    }

    boolean matchPredecessor(String predecessor, String word) {
        int mismatch = 0;
        int posPredecessor = 0;
        for(int pos = 0; pos < word.length(); ++pos) {
            if (posPredecessor >= predecessor.length()) return true;
            if (predecessor.charAt(posPredecessor) != word.charAt(pos)) {
                if (++mismatch > 1) return false;
            } else {
                ++posPredecessor;
            }
        }
        return true;
    }
}
