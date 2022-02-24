import java.util.Arrays;

public class SumOfSubsequenceWidths {
    // Sum width between num[i] and num[j]: (num[j] - num[i]) * 2^(j - i - 1)
    // Time complexity: N^2
    public int sumSubseqWidthsN2(int[] nums) {
        Arrays.sort(nums);
        long sumWidths = 0;
        long mod = 1000000007;
        for(int i = 0; i < nums.length - 1; ++i) {
            long multiplier = 1;
            for(int j = i + 1; j < nums.length; ++j) {
                int width = nums[j] - nums[i];
                sumWidths += (width * multiplier) % mod;
                multiplier = (multiplier * 2) % mod;
            }
        }
        return (int) (sumWidths % mod);
    }

    // num[i]'s contribution: 2^(i) - 2^(n-1-i)
    // Time complexity: N
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        long sumWidths = 0;
        long mod = 1000000007;
        long multiplier = 1;
        for(int i = 0; i < nums.length; ++i) {
            sumWidths += (nums[i] * multiplier) % mod;
            sumWidths -= (nums[N-1-i] * multiplier) % mod;
            multiplier = (multiplier * 2) % mod;
        }
        while(sumWidths < 0) sumWidths += mod;
        return (int) (sumWidths % mod);
    }
}
