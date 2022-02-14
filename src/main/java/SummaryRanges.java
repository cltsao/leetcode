import java.util.Map;
import java.util.TreeMap;

public class SummaryRanges {
    // From start to end
    TreeMap<Integer, Integer> ranges;

    public SummaryRanges() {
        ranges = new TreeMap<>();
    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> entry = ranges.floorEntry(val);
        if (entry != null && entry.getValue() >= val - 1) {
            if (entry.getValue() == val - 1)
            ranges.put(entry.getKey(), val);
        } else {
            ranges.put(val, val);
            entry = ranges.floorEntry(val);
        }

        if (ranges.containsKey(val + 1)) {
            ranges.put(entry.getKey(), ranges.get(val + 1));
            ranges.remove(val + 1);
        }
    }

    public int[][] getIntervals() {
        int[][] intervals = new int[ranges.size()][2];
        int i = -1;
        for(Map.Entry<Integer, Integer> range : ranges.entrySet()) {
            intervals[++i] = new int[] {range.getKey(), range.getValue()};
        }
        return intervals;
    }
}
