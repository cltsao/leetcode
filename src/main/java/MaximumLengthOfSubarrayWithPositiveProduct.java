public class MaximumLengthOfSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int firstNegPos = -1;
        int lastNegPos = -1;
        boolean positive = true;
        int maxLength = 0;
        int start = 0;
        for(int i = 0; i <= nums.length; ++i) {
            if (i == nums.length || nums[i] == 0) {
                // End of a subarray
                if (positive) {
                    // Entire subarray is positive
                    maxLength = Math.max(maxLength, i - start);
                } else {
                   // Exclude first or last negative
                    int length = Math.max(i - firstNegPos - 1, lastNegPos - start);
                    maxLength = Math.max(maxLength, length);
                }
                start = i + 1;
                firstNegPos = -1;
                positive = true;
            } else {
                if (nums[i] < 0) {
                    if (firstNegPos < 0) firstNegPos = i;
                    lastNegPos = i;
                    positive = !positive;
                }
            }
        }
        return maxLength;
    }
}
