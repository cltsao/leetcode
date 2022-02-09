import java.util.HashMap;
import java.util.Map;

public class DetectSquares {
    Map<Integer, Map<Integer, Integer>> pointMap;

    public DetectSquares() {
        pointMap = new HashMap<>();
    }

    public void add(int[] point) {
        if (!pointMap.containsKey(point[0]))
            pointMap.put(point[0], new HashMap<>());
        int count = pointMap.get(point[0]).getOrDefault(point[1], 0);
        pointMap.get(point[0]).put(point[1], count + 1);
    }

    public int count(int[] point) {
        if (!pointMap.containsKey(point[0])) return 0;
        int count = 0;
        Map<Integer, Integer> pointsOnSameRow = pointMap.get(point[0]);
        for(Map.Entry<Integer, Integer> pointOnSameRow : pointsOnSameRow.entrySet()) {
            int length = Math.abs(pointOnSameRow.getKey() - point[1]);
            if (length == 0) continue;
            Map<Integer, Integer> row = pointMap.get(point[0] - length);
            if (row != null) {
                int diff = row.getOrDefault(point[1], 0) * row.getOrDefault(pointOnSameRow.getKey(), 0) * pointOnSameRow.getValue();
                count += diff;
            }
            row = pointMap.get(point[0] + length);
            if (row != null) {
                int diff = row.getOrDefault(point[1], 0) * row.getOrDefault(pointOnSameRow.getKey(), 0) * pointOnSameRow.getValue();
                count += diff;
            }
        }
        return count;
    }
}
