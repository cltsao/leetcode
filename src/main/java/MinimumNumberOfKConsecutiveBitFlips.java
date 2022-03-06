import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberOfKConsecutiveBitFlips {
    // Time complexity: N
    public int minKBitFlips(int[] nums, int k) {
        int numFlips = 0;
        boolean flipped = false;
        Queue<Integer> posToFlip = new LinkedList<>();
        for(int i = 0; i < nums.length; ++i) {
            if(!posToFlip.isEmpty() && i == posToFlip.peek()) {
                posToFlip.poll();
                flipped = !flipped;
            }
            if(nums[i] == (flipped ? 1 : 0)) {
                ++numFlips;
                flipped = !flipped;
                posToFlip.add(i + k);
            }
        }
        if(posToFlip.stream().anyMatch(pos -> pos > nums.length)) return -1;
        return numFlips;
    }

    // Greedy algorithm: flip first 0 from left
    // Time complexity: O(N * K)
    public int minKBitFlipsGreedy(int[] nums, int k) {
        int numFlips = 0;
        for(int i = 0; i <= nums.length - k; ++i) {
            if (nums[i] == 0) {
                ++numFlips;
                for(int j = i; j < i + k; ++j) {
                    nums[j] = 1 - nums[j];
                }
            }
        }
        for(int i = nums.length - k + 1; i < nums.length; ++i) {
            if (nums[i] == 0) return -1;
        }
        return numFlips;
    }
}
