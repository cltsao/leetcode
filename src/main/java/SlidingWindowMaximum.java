import java.util.PriorityQueue;
import java.util.TreeMap;

public class SlidingWindowMaximum {
    // Map. Time = O(N log W)
    public int[] maxSlidingWindow(int[] nums, int k) {
        long startTime = System.currentTimeMillis();
        TreeMap<Integer, Integer> window = new TreeMap<>();
        int pos = 0;
        for(; pos < k; ++pos) {
            window.putIfAbsent(nums[pos], 0);
            window.put(nums[pos], window.get(nums[pos]) + 1);
        }
        int[] maxWindow = new int[nums.length - k + 1];
        maxWindow[0] = window.lastKey();
        for(; pos < nums.length; ++pos) {
            window.putIfAbsent(nums[pos], 0);
            window.put(nums[pos], window.get(nums[pos]) + 1);
            int decrementedCount = window.get(nums[pos - k]) - 1;
            if (decrementedCount > 0)
                window.put(nums[pos - k], decrementedCount);
            else
                window.remove(nums[pos - k]);

            maxWindow[pos - k + 1] = window.lastKey();
        }

        System.out.println("Execution time: " + (System.currentTimeMillis() - startTime) + " ms");
        return maxWindow;
    }

//    // Heap. Time = O(N log k)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        long startTime = System.currentTimeMillis();
//        PriorityQueue<Integer> window = new PriorityQueue<>(k, (n1, n2) -> (n2 - n1));
//        int pos = 0;
//        for(; pos < k; ++pos) {
//            window.offer(nums[pos]);
//        }
//        int[] maxWindow = new int[nums.length - k + 1];
//        maxWindow[0] = window.peek();
//        for(; pos < nums.length; ++pos) {
//            window.offer(nums[pos]);
//            window.remove(nums[pos - k]);
//            maxWindow[pos - k + 1] = window.peek();
//        }
//
//        System.out.println("Execution time: " + (System.currentTimeMillis() - startTime) + " ms");
//        return maxWindow;
//    }
}
