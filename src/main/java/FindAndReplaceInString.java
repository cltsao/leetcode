import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FindAndReplaceInString {
    // Match and then sort: O(M log M), M = matches
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        TreeMap<Integer, Integer> matches = new TreeMap<>();
        for(int i = 0; i < indices.length; ++i) {
            if (matchSubstring(s, indices[i], sources[i])) {
                matches.put(indices[i], i);
            }
        }

        StringBuilder output = new StringBuilder();
        int pos = 0;
        for(Map.Entry<Integer, Integer> match : matches.entrySet()) {
            int index = match.getKey();
            int indexId = match.getValue();
            output.append(s, pos, match.getKey());
            output.append(targets[indexId]);
            pos = index + sources[indexId].length();
        }
        output.append(s, pos, s.length());
        return output.toString();
    }

    boolean matchSubstring(String s, int index, String source) {
        for(int i = 0; i < source.length(); ++i) {
            if (s.charAt(index + i) != source.charAt(i)) return false;
        }
        return true;
    }

    // Sort and then replace: O(N log N)
    public String findReplaceStringSort(String s, int[] indices, String[] sources, String[] targets) {
        Integer[] indexOrder = new Integer[indices.length];
        for (int i = 0; i < indices.length; ++i)
            indexOrder[i] = i;
        Arrays.sort(indexOrder, Comparator.comparingInt(o -> indices[o]));
        StringBuilder output = new StringBuilder();
        int pos = 0;
        for(int indexId : indexOrder) {
            if (matchSubstring(s, indices[indexId], sources[indexId])) {
                output.append(s, pos, indices[indexId]);
                output.append(targets[indexId]);
                pos = indices[indexId] + sources[indexId].length();
            }
        }
        output.append(s, pos, s.length());
        return output.toString();
    }
}
