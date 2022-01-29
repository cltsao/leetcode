import java.util.*;

public class SumOfSubarrayMinimums {
    // Stack: O(N)
    public int sumSubarrayMins(int[] arr) {
        int[] leftRange = new int[arr.length];
        int[] rightRange = new int[arr.length];
        Deque<Integer> minNumberIndex = new LinkedList<>();
        for(int i = 0; i < arr.length; ++i) {
            while(!minNumberIndex.isEmpty() && arr[minNumberIndex.peek()] > arr[i]) {
                minNumberIndex.pop();
            }
            if (minNumberIndex.isEmpty()) leftRange[i] = 0;
            else leftRange[i] = minNumberIndex.peek() + 1;
            minNumberIndex.addFirst(i);
        }

        minNumberIndex.clear();
        for(int i = arr.length - 1; i >= 0; --i) {
            while(!minNumberIndex.isEmpty() && arr[minNumberIndex.peek()] >= arr[i]) {
                minNumberIndex.pop();
            }
            if (minNumberIndex.isEmpty()) rightRange[i] = arr.length - 1;
            else rightRange[i] = minNumberIndex.peek() - 1;
            minNumberIndex.addFirst(i);
        }

        long sum = 0;
        for(int i = 0; i < arr.length; ++i) {
            sum += (long)arr[i] * (i - leftRange[i] + 1) * (rightRange[i] - i + 1);
            sum = sum % 1000000007;
        }
        return (int)sum;
    }

    // Stack: O(N)
    public int sumSubarrayMinsStack(int[] arr) {
        int[] leftRange = new int[arr.length];
        int[] rightRange = new int[arr.length];
        Stack<Integer> minNumberIndex = new Stack<>();
        for(int i = 0; i < arr.length; ++i) {
            while(!minNumberIndex.empty() && arr[minNumberIndex.peek()] > arr[i]) {
                minNumberIndex.pop();
            }
            if (minNumberIndex.empty()) leftRange[i] = 0;
            else leftRange[i] = minNumberIndex.peek() + 1;
            minNumberIndex.push(i);
        }

        minNumberIndex.clear();
        for(int i = arr.length - 1; i >= 0; --i) {
            while(!minNumberIndex.empty() && arr[minNumberIndex.peek()] >= arr[i]) {
                minNumberIndex.pop();
            }
            if (minNumberIndex.empty()) rightRange[i] = arr.length - 1;
            else rightRange[i] = minNumberIndex.peek() - 1;
            minNumberIndex.push(i);
        }

        long sum = 0;
        for(int i = 0; i < arr.length; ++i) {
            sum += (long)arr[i] * (i - leftRange[i] + 1) * (rightRange[i] - i + 1);
            sum = sum % 1000000007;
        }
        return (int)sum;
    }

    // Simple iteration: O(N^2)
    public int sumSubarrayMinsIterate(int[] arr) {
        int[] leftRange = new int[arr.length];
        Arrays.fill(leftRange, 0);
        int[] rightRange = new int[arr.length];
        Arrays.fill(rightRange, arr.length - 1);

        for(int i = 0; i < arr.length; ++i) {
            for(int j = i - 1; j >= 0; --j) {
                if (arr[j] <= arr [i]) {
                    leftRange[i] = j + 1;
                    break;
                }
            }
        }

        for(int i = arr.length - 1; i >= 0; --i) {
            for(int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < arr[i]) {
                    rightRange [i] = j - 1;
                    break;
                }
            }
        }

        long sum = 0;
        for(int i = 0; i < arr.length; ++i) {
            sum += (long)arr[i] * (i - leftRange[i] + 1) * (rightRange[i] - i + 1);
            sum = sum % 1000000007;
        }
        return (int)sum;
    }
}
