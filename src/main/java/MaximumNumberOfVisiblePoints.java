import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumNumberOfVisiblePoints {
    class Change implements Comparable<Change> {
        double angle;
        int value;
        Change(double angle, int value) {
            this.angle = angle;
            this.value = value;
        }

        @Override
        public int compareTo(Change o) {
            if (angle != o.angle) return angle - o.angle < 0 ? -1 : 1;
            return o.value - value; // If a point appear at left edge when another disappear at right edge, count the point as beeing seen
        }

        @Override
        public String toString() {
            return angle + "->" + value;
        }
    }

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        double dAngle = angle * Math.PI / 180;
        List<Double> pointAngles = new ArrayList<>();
        int pointsInView = 0;
        for(List<Integer> point : points) {
            int x = point.get(0) - location.get(0);
            int y = point.get(1) - location.get(1);
            if (x == 0) {
                if (y == 0) {
                    ++pointsInView;  // point on location is always in view
                } else {
                    if (y > 0) pointAngles.add(Math.PI / 2);
                    else pointAngles.add(Math.PI * 3 / 2);
                }
            } else {
                double pointAngle = Math.atan(y * 1.0 / x);
                if (x < 0) pointAngle += Math.PI;
                if (pointAngle < 0) pointAngle += Math.PI * 2;
                pointAngles.add(pointAngle);
            }
        }
        Collections.sort(pointAngles);

        List<Change> changes = new ArrayList<>();
        for(double pointAngle : pointAngles) {
            changes.add(new Change(pointAngle, 1));
            changes.add(new Change(pointAngle + dAngle, -1));
            if (pointAngle <= dAngle) {
                changes.add(new Change(pointAngle + Math.PI * 2, 1));
                changes.add(new Change(pointAngle + dAngle + Math.PI * 2, -1));
            }
        }
        Collections.sort(changes);

        int maxPointsInView = pointsInView;
        for(Change change : changes) {
            pointsInView += change.value;
            maxPointsInView = Math.max(maxPointsInView, pointsInView);
        }

        return maxPointsInView;
    }
}
