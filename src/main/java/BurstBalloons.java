public class BurstBalloons {
    public int maxCoins(int[] nums) {
        final int N = nums.length;
        int[][] dp = new int[N][N];

        for(int i = 0; i < N; ++i) {
            dp[i][i] = (i > 0 ? nums[i-1] : 1) * nums[i] * (i < N-1 ? nums[i+1] : 1);
        }

        for(int size = 2; size <= N; ++size) {
            for(int i = 0; i <= N-size; ++i) {
                dp[i][i+size-1] = (i > 0 ? nums[i-1] : 1) * nums[i] * (i+size < N ? nums[i+size] : 1) + dp[i+1][i+size-1];
                for(int j = i + 1; j < i + size - 1; ++j) {
                    dp[i][i+size-1] = Math.max(dp[i][i+size-1], dp[i][j-1] + (i > 0 ? nums[i-1] : 1) * nums[j] * (i+size < N ? nums[i+size] : 1) + dp[j+1][i+size-1]);
                }
                dp[i][i+size-1] = Math.max(dp[i][i+size-1], dp[i][i+size-2] + (i > 0 ? nums[i-1] : 1) * nums[i+size-1] * (i+size < N ? nums[i+size] : 1));
            }
        }
        return dp[0][N-1];
    }
}
