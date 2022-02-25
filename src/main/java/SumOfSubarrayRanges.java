import java.util.Stack;

public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        int N = nums.length;
        // Count numbers on the left/right that are smaller/greater than a number
        long[] countMaxLeft = new long[N];
        int[] countMaxRight = new int[N];
        long[] countMinLeft = new long[N];
        int[] countMinRight = new int[N];

        Stack<int[]> max = new Stack<>();
        Stack<int[]> min = new Stack<>();
        for(int i = 0; i < N; ++i) {
            while(!max.isEmpty() && max.peek()[0] < nums[i]) max.pop();
            if (max.isEmpty()) countMaxLeft[i] = i + 1;
            else countMaxLeft[i] = i - max.peek()[1];
            max.push(new int[] {nums[i], i});

            while(!min.isEmpty() && min.peek()[0] > nums[i]) min.pop();
            if (min.isEmpty()) countMinLeft[i] = i + 1;
            else countMinLeft[i] = i - min.peek()[1];
            min.push(new int[] {nums[i], i});
        }
        max.clear();
        min.clear();
        for(int i = N - 1; i >= 0; --i) {
            while(!max.isEmpty() && max.peek()[0] <= nums[i]) max.pop();  // If two numbers are equal, count max and min at the number on the left
            if (max.isEmpty()) countMaxRight[i] = N - i;
            else countMaxRight[i] = max.peek()[1] - i;
            max.push(new int[] {nums[i], i});

            while(!min.isEmpty() && min.peek()[0] >= nums[i]) min.pop();
            if (min.isEmpty()) countMinRight[i] = N - i;
            else countMinRight[i] = min.peek()[1] - i;
            min.push(new int[] {nums[i], i});
        }

        long sumRanges = 0;
        for(int i = 0; i < N; ++i) {
            sumRanges += nums[i] * countMaxLeft[i] * countMaxRight[i];
            sumRanges -= nums[i] * countMinLeft[i] * countMinRight[i];
        }
        return sumRanges;
    }


    // Time complexity: N^2
    public long subArrayRangesN2(int[] nums) {
        long sumRanges = 0;
        for(int i = 0; i < nums.length; ++i) {
            int min = nums[i];
            int max = nums[i];
            for(int j = i + 1; j < nums.length; ++j) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sumRanges += max - min;
            }
        }
        return sumRanges;
    }
}
