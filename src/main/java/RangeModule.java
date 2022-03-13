import java.util.Map;
import java.util.TreeMap;

// Using a tree to maintain ranges
// Time complexity: O(log N) where N is the number of ranges
// Space complexity: O(N)
public class RangeModule {
    TreeMap<Integer, Integer> ranges;

    public RangeModule() {
        ranges = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        // Merge with an existing range that overlaps with the left boundary
        Map.Entry<Integer, Integer> entry = ranges.floorEntry(left);
        if (entry != null && entry.getValue() >= left) {
            if (right > entry.getValue()) {
                ranges.put(entry.getKey(), right);
                entry = ranges.floorEntry(left);
            }
        } else {
            ranges.put(left, right);
            entry = ranges.ceilingEntry(left);
        }

        // Merge all existing ranges that overlaps with the right boundary
        Map.Entry<Integer, Integer> subsequentEntry;
        while((subsequentEntry = ranges.floorEntry(entry.getValue())) != null && subsequentEntry.getKey() > left) {
            if(subsequentEntry.getValue() > entry.getValue()) {
                ranges.put(entry.getKey(), subsequentEntry.getValue());
            }
            ranges.remove(subsequentEntry.getKey());
        }
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = ranges.floorEntry(left);
        return entry != null && entry.getValue() >= right;
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = ranges.floorEntry(left);
        // Update a range that overlaps with the left boundary
        if (entry != null && entry.getValue() > left) {
            if (left > entry.getKey()) {
                ranges.put(entry.getKey(), left);
            } else {
                ranges.remove(entry.getKey());
            }

            if (right < entry.getValue()) {
                ranges.put(right, entry.getValue());
            }
        }

        // Update any range that overlaps with the right boundary
        while((entry = ranges.floorEntry(right - 1)) != null && entry.getKey() > left) {
            ranges.remove(entry.getKey());
            if (entry.getValue() > right) {
                ranges.put(right, entry.getValue());
            }
        }
    }
}
