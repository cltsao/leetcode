import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    class Point {
        int[] coordinate;
        double distance;
        Point(int[] coordinate) {
            this.coordinate = coordinate;
            distance = Math.sqrt((double) coordinate[0] * coordinate[0] + coordinate[1] * coordinate[1]);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pointHeap = new PriorityQueue<>(points.length, (p1, p2) -> {
            if (p1.distance == p2.distance) return 0;
            return p1.distance < p2.distance ? -1 : 1;
        });
        for(int[] point : points) {
            pointHeap.offer(new Point(point));
        }

        int[][] results = new int[k][];
        for(int i = 0; i < k; ++i) {
            results[i] = pointHeap.poll().coordinate;
        }
        return results;
    }
}
