import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>(sticks.length);
        for(int stick : sticks) {
            numbers.offer(stick);
        }

        int cost = 0;
        while(numbers.size() > 1) {
            int sum = numbers.poll() + numbers.poll();
            cost += sum;
            numbers.offer(sum);
        }
        return cost;
    }
}
