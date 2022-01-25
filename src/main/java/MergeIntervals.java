import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Sort intervals by start value
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        LinkedList<List<Integer>> mergedIntervals = new LinkedList<>();
        for(int[] interval : intervals) {
            if (mergedIntervals.size() > 0 && mergedIntervals.getLast().get(1) >= interval[0]) {
                mergedIntervals.getLast().set(1, Math.max(mergedIntervals.getLast().get(1), interval[1]));
            } else {
                List<Integer> newInterval = new ArrayList<>();
                newInterval.add(interval[0]);
                newInterval.add(interval[1]);
                mergedIntervals.add(newInterval);
            }
        }

        int[][] result = new int[mergedIntervals.size()][];
        int i = 0;
        for(List<Integer> mergedInterval : mergedIntervals) {
            result[i++] = new int[] {mergedInterval.get(0), mergedInterval.get(1)};
        }
        return result;
    }
}
