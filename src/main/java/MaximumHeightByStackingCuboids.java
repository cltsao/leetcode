import java.util.Arrays;

public class MaximumHeightByStackingCuboids {
    public int maxHeight(int[][] cuboids) {
        // Longest side is always used as height, first orientate each cuboid by edge length. Let's call it length, width, height
        for(int i = 0; i < cuboids.length; ++i) {
            Arrays.sort(cuboids[i]);
        }

        // Sort cuboids for DP stacking from top to bottom. Shorter height must be higher since it can't be used later.
        Arrays.sort(cuboids, (cuboid1, cuboid2) -> {
            if (cuboid1[2] != cuboid2[2]) return cuboid1[2] - cuboid2[2];
            if (cuboid1[1] != cuboid2[1]) return cuboid1[1] - cuboid2[1];
            return cuboid1[0] - cuboid2[0];
        });

        // Max height achieved with cuboid i as base
        int[] dp = new int[cuboids.length];
        int maxHeight = 0;
        for(int i = 0; i < cuboids.length; ++i) {
            int[] cuboid = cuboids[i];
            int height = 0;
            for(int j = 0; j < i; ++j) {
                if (cuboids[j][0] <= cuboid[0] && cuboids[j][1] <= cuboid[1]) {
                    height = Math.max(height, dp[j]);
                }
            }
            height += cuboid[2];
            maxHeight = Math.max(maxHeight, height);
            dp[i] = height;
        }
        return maxHeight;
    }

    public int maxHeightDPByArea(int[][] cuboids) {
        // Longest side is always used as height, first orientate each cuboid by edge length. Let's call it length, width, height
        for(int i = 0; i < cuboids.length; ++i) {
            Arrays.sort(cuboids[i]);
        }

        // Sort cuboids for DP stacking from top to bottom. Shorter height must be higher since it can't be used later.
        Arrays.sort(cuboids, (cuboid1, cuboid2) -> {
            if (cuboid1[2] != cuboid2[2]) return cuboid1[2] - cuboid2[2];
            if (cuboid1[1] != cuboid2[1]) return cuboid1[1] - cuboid2[1];
            return cuboid1[0] - cuboid2[0];
        });

        int maxLength = 0;
        int maxWidth = 0;
        for(int[] cuboid : cuboids) {
            maxLength = Math.max(maxLength, cuboid[0]);
            maxWidth = Math.max(maxWidth, cuboid[1]);
        }

        // Max height achieved by length and width
        int[][] dp = new int[maxLength + 1][maxWidth + 1];
        int maxHeight = 0;
        for(int[] cuboid : cuboids) {
            int height = 0;
            for(int length = 1; length <= cuboid[0]; ++length) {
                for(int width = 1; width <= cuboid[1]; ++width) {
                    height = Math.max(height, dp[length][width]);
                }
            }
            height += cuboid[2];
            maxHeight = Math.max(maxHeight, height);
            dp[cuboid[0]][cuboid[1]] = height;
        }
        return maxHeight;
    }
}
