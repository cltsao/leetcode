public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        int water = 0;
        while(left <= right) {
            if (leftMax < rightMax) {
                water += leftMax - height[left];
                ++left;
                if (left < height.length)
                    leftMax = Math.max(leftMax, height[left]);
            } else {
                water += rightMax - height[right];
                --right;
                if (right >= 0)
                    rightMax = Math.max(rightMax, height[right]);
            }
        }
        return water;
    }

    // O(N) time, O(N) space
//    public int trap(int[] height) {
//        int[] rightMax = new int[height.length];
//        int leftMax = 0;
//        rightMax[height.length - 1] = height[height.length - 1];
//        for (int i = height.length - 2; i >= 0; --i) {
//            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
//        }
//        int water = 0;
//        for (int i = 0; i < height.length; ++i) {
//            leftMax = Math.max(leftMax, height[i]);
//            water += Math.min(leftMax, rightMax[i]) - height[i];
//        }
//        return water;
//    }
}
