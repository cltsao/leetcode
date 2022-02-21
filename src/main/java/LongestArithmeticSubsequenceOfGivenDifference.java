import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int maxLength = 0;
        Map<Integer, Integer> nextNumberMap = new HashMap<>();
        for(int num : arr) {
            int subsequenceLength = nextNumberMap.getOrDefault(num, 1);
            if (subsequenceLength > maxLength) maxLength = subsequenceLength;
            nextNumberMap.put(num + difference, subsequenceLength + 1);
        }
        return maxLength;
    }
}
