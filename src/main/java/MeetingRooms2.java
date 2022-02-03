import java.util.*;

public class MeetingRooms2 {
    // Heap: O(N)
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Map.Entry<Integer, Integer>> changes = new PriorityQueue<>(intervals.length * 2, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                if (e1.getKey() - e2.getKey() != 0) return e1.getKey() - e2.getKey();
                else return e1.getValue() - e2.getValue(); // if an interval ends when another interval begins, decrement before increment number of rooms
            }
        });
        for(int[] interval : intervals) {
            changes.offer(new AbstractMap.SimpleEntry<>(interval[0], 1));
            changes.offer(new AbstractMap.SimpleEntry<>(interval[1], -1));
        }

        int maxNumRooms = Integer.MIN_VALUE;
        int numRooms = 0;
        while(!changes.isEmpty()) {
            Map.Entry<Integer, Integer> change = changes.poll();
            numRooms += change.getValue();
            maxNumRooms = Math.max(maxNumRooms, numRooms);
        }
        return maxNumRooms;
    }
}
