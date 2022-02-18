import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> smallNumbers;
    PriorityQueue<Integer> largeNumbers;

    public MedianFinder() {
        smallNumbers = new PriorityQueue<>(10000, (o1, o2) -> o2 - o1); // Need to get the largest one of the small numbers
        largeNumbers = new PriorityQueue<>(10000);
    }

    public void addNum(int num) {
        if (smallNumbers.size() == largeNumbers.size()) {
            int smallestLargeNumber = largeNumbers.size() > 0 ? largeNumbers.peek() : Integer.MAX_VALUE;
            if (num > smallestLargeNumber) {
                largeNumbers.poll();
                smallNumbers.offer(smallestLargeNumber);
                largeNumbers.offer(num);
            } else {
                smallNumbers.offer(num);
            }
        } else {
            // Number count is odd, keep one more number in small numbers
            int largestSmallNumber = smallNumbers.peek();
            if (num < largestSmallNumber) {
                smallNumbers.poll();
                smallNumbers.offer(num);
                largeNumbers.offer(largestSmallNumber);
            } else {
                largeNumbers.offer(num);
            }
        }
    }

    public double findMedian() {
        if (smallNumbers.size() == largeNumbers.size()) {
            return (smallNumbers.peek() + largeNumbers.peek()) / 2.0;
        } else {
            return smallNumbers.peek();
        }
    }
}
