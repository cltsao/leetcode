import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    int[] nums;
    int[] originalNums;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        originalNums = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        for(int i = 0; i < nums.length; ++i)
            nums[i] = originalNums[i];
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for(int i = 1; i < nums.length; ++i) {
            int j = random.nextInt(i + 1);
            if (j != i) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
