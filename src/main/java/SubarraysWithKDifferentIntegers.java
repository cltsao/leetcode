import java.util.*;

public class SubarraysWithKDifferentIntegers {
    // Time complexity: N
    public int subarraysWithKDistinct(int[] nums, int k) {
        int N = nums.length;
        int prefix = 0;
        int start = 0;  // Index such that nums[start] appears once in [start, end]
        int end = 0;
        int numSubarrays = 0;
        Map<Integer, Integer> numberCount = new HashMap<>();
        while(end < N) {
            numberCount.put(nums[end], numberCount.getOrDefault(nums[end], 0) + 1);
            while(numberCount.get(nums[start]) > 1) {
                numberCount.put(nums[start], numberCount.get(nums[start]) - 1);
                ++start;
                ++prefix;
            }

            if (numberCount.size() == k) {
                // Found a subarray in [start, end] with prefix that also contain k distinct integers
                numSubarrays += prefix + 1;
            } else if (numberCount.size() > k) {
                numberCount.remove(nums[start]);
                ++start;
                prefix = 0;
                numberCount.remove(nums[end]);
                --end;
            }
            ++end;
        }
        return numSubarrays;
    }

    // Time complexity: N * K
    public int subarraysWithKDistinctNK(int[] nums, int k) {
        int N = nums.length;
        int numSubarrays = 0;
        int start = 0, end = 0;

        // Find first subarray with k distinct numbers
        Map<Integer, Deque<Integer>> numberPositions = new HashMap<>();
        while(end < N) {
            while (end < N && numberPositions.size() < k) {
                int num = nums[end];
                numberPositions.putIfAbsent(num, new LinkedList<>());
                numberPositions.get(num).add(end);
                ++end;
            }
            if (numberPositions.size() == k)
                ++numSubarrays;
            else break;

            // Keep moving end until hitting k+1's number
            while (end < N && numberPositions.containsKey(nums[end])) {
                numberPositions.get(nums[end]).add(end);
                ++numSubarrays;
                ++end;
            }

            while (numberPositions.get(nums[start]).size() > 1) {
                numberPositions.get(nums[start]).removeFirst();
                int firstEndWithKDistinct = numberPositions.values().stream().mapToInt(deque -> deque.peekFirst()).max().getAsInt() + 1;
                numSubarrays += end - firstEndWithKDistinct + 1;
                ++start;
            }

            numberPositions.remove(nums[start]);
            ++start;
        }

        return numSubarrays;
    }

    // Time complexity: N^2
    public int subarraysWithKDistinctN2(int[] nums, int k) {
        int N = nums.length;
        int numSubarrays = 0;
        for(int start = 0; start < N; ++start) {
            Set<Integer> set = new HashSet<>();
            for(int end = start; end < N; ++end) {
                set.add(nums[end]);
                if (set.size() == k) ++numSubarrays;
                if (set.size() > k) break;
            }
        }
        return numSubarrays;
    }
}
