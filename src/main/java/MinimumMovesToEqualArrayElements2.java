import java.util.Arrays;

public class MinimumMovesToEqualArrayElements2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int minMoves = 0;
        for(int num : nums) minMoves += Math.abs(num - median);
        return minMoves;
    }
}
