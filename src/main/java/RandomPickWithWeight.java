import java.util.Random;

// Binary search in cumulative weights
// Time complexity: O(log N)
// Space complexity: O(N)
public class RandomPickWithWeight {
    private int[] cumulativeWeights;

    public RandomPickWithWeight(int[] w) {
        cumulativeWeights = new int[w.length];
        cumulativeWeights[0] = w[0];
        for(int i = 1; i < w.length; ++i) {
            cumulativeWeights[i] = cumulativeWeights[i-1] + w[i];
        }

        random = new Random();
    }

    private Random random;

    public int pickIndex() {
        int num = random.nextInt(cumulativeWeights[cumulativeWeights.length - 1]) + 1;
        int min = 0, max = cumulativeWeights.length - 1;
        while(max > min) {
            int mid = (max + min) / 2;
            if (cumulativeWeights[mid] >= num) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
