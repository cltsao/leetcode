import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
    // Number of boomerangs = number of equal-length lines. Iterative calculation by point.
    // Time complexity: O(N^2)
    // Space complexity: O(N)
    public int numberOfBoomerangs(int[][] points) {
        int totalCount = 0;
        for(int i = 0; i < points.length; ++i) {
            int[] p1 = points[i];
            // Calculate length of every point pair and count liens by length. No need to do square root to save time.
            Map<Integer, Integer> lengthCount = new HashMap<>();
            for(int j = 0; j < points.length; ++j) {
                if (j == i) continue;;
                int[] p2 = points[j];
                int length = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                lengthCount.put(length, lengthCount.getOrDefault(length, 0) + 1);
            }

            for (int count : lengthCount.values()) {
                totalCount += count * (count - 1);
            }
        }

        return totalCount;
    }

    // Number of boomerangs = number of equal-length lines
    // Time complexity: O(N^2)
    // Space complexity: O(N^2)
    public int numberOfBoomerangsN2(int[][] points) {
        // Calculate length of every point pair and count liens by length. Group them by point since boomerang lines must share one point.
        Map<String, Map<Double, Integer>> pointLengthCount = new HashMap<>();
        for(int[] p : points) {
            pointLengthCount.put(p[0] + " " + p[1], new HashMap<>());
        }

        for(int i = 0; i < points.length - 1; ++i) {
            int[] p1 = points[i];
            for(int j = i + 1; j < points.length; ++j) {
                int[] p2 = points[j];
                double length = Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
                pointLengthCount.get(p1[0] + " " + p1[1]).put(length, pointLengthCount.get(p1[0] + " " + p1[1]).getOrDefault(length, 0) + 1);
                pointLengthCount.get(p2[0] + " " + p2[1]).put(length, pointLengthCount.get(p2[0] + " " + p2[1]).getOrDefault(length, 0) + 1);
            }
        }

        // Every pair of equal length lines form a boomerang. For x lines of equal length, P(x, 2) boomerangs are formed. Note that order of points matter, so it's P(x, 2) instead of C(x, 2).
        int totalCount = 0;
        for(Map<Double, Integer> lengthCount : pointLengthCount.values()) {
            for (int count : lengthCount.values()) {
                totalCount += count * (count - 1);
            }
        }
        return totalCount;
    }
}
