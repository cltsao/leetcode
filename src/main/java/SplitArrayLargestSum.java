import java.util.Arrays;

public class SplitArrayLargestSum {
    // Binary search, min <= answer <= max until min == max
    // Min = max of nums since it must be in one subarray
    // Max = sum of nums
    // In each step, make binary guess and maintain min <= answer < max
    // Greedy algorithm by assigning each subarray to be <= guess
    // Time complexity: log2 (N * K) * N, where K is average of numbers; with given input, log2 (N * K) = log2 (10^9) = 30 < M = 50
    // Space complexity: O(1)
    public int splitArray(int[] nums, int m) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for(int num : nums) {
            min = Math.max(min, num);
            max += num;
        }

        while(max > min) {
            int mid = (min + max) / 2;
            if(splitByLimit(nums, mid, m)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    // True if nums can be split into m or fewer subarrays with subarray sum no more than limit
    private boolean splitByLimit(int[] nums, int limit, int m) {
        int sum = 0;
        int numSubarrays = 1;
        for(int num : nums) {
            if (sum + num > limit) {
                ++numSubarrays;
                if (numSubarrays > m) return false;
                sum = num;
            } else {
                sum += num;
            }
        }
        return true;
    }

    // Time complexity: N * M
    // Space complexity: N * M
    public int splitArrayDP(int[] nums, int m) {
        // Special case m = 1, just return sum
        if (m == 1) {
            int sum = 0;
            for(int num : nums) sum += num;
            return sum;
        }

        final int N = nums.length;
        // Min-largest-sum of first i numbers in j subarrays
        int[][] dp = new int[N][m];

        // j = 1: just simple sum of first i numbers
        for(int i = 1; i <= N-1; ++i) {
            dp[i][1] = dp[i-1][1] + nums[i-1];
        }

        // j = 2~m-1 with DP state transition: dp(i,j) = min_k max[dp(i-k, j-1), sum of numbers from i-k+1 to i)]
        for(int j = 2; j < m; ++j) {
            // Need j subarrays in the first i numbers, so i >= j
            for(int i = j; i < N; ++i) {
                dp[i][j] = Integer.MAX_VALUE;
                int lastSubarraySum = 0;
                // Need j-1 subarrays in the first i-k numbers, so i-k >= j-1. k <= i-j+1
                for(int k = 1; k <= i-j+1; ++k) {
                    lastSubarraySum += nums[i-k];
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-k][j-1], lastSubarraySum));
                }
            }
        }

        // j = m: Same as above but just calculate dp[N][m]
        int lastSubarraySum = 0;
        // Need m-1 subarrays in the first N-k numbers, so N-k >= m-1. k <= N-m+1
        int result = Integer.MAX_VALUE;
        for(int k = 1; k <= N-m+1; ++k) {
            lastSubarraySum += nums[N-k];
            result = Math.min(result, Math.max(dp[N-k][m-1], lastSubarraySum));
        }
        return result;
    }
}
