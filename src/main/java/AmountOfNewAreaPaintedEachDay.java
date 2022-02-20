import java.util.Map;
import java.util.TreeMap;

public class AmountOfNewAreaPaintedEachDay {
    public int[] amountPainted(int[][] paint) {
        int[] newPaint = new int[paint.length];
        TreeMap<Integer, Integer> paintedAreas = new TreeMap<>();
        for(int day = 0; day < paint.length; ++day) {
            int[] toPaint = paint[day];
            int paintedAreaKey;
            Map.Entry<Integer, Integer> left = paintedAreas.floorEntry(toPaint[0]);
            if(left != null && left.getValue() >= toPaint[0]) {
                // new area overlaps with the area on its left
                paintedAreaKey = left.getKey();
            }
            else {
                // new area does not overlap with the area on its left
                paintedAreas.put(toPaint[0], toPaint[0]);
                paintedAreaKey = toPaint[0];
            }

            while(paintedAreas.get(paintedAreaKey) < toPaint[1]) {
                Map.Entry<Integer, Integer> nextPaintedArea = paintedAreas.ceilingEntry(paintedAreas.get(paintedAreaKey) + 1);
                if (nextPaintedArea == null || nextPaintedArea.getKey() > toPaint[1]) {
                    // paint all the way to the right edge of new area
                    newPaint[day] += toPaint[1] - paintedAreas.get(paintedAreaKey);
                    paintedAreas.put(paintedAreaKey, toPaint[1]);
                } else {
                    // paint till reaching next painted area, and merge it to current area
                    newPaint[day] += nextPaintedArea.getKey() - paintedAreas.get(paintedAreaKey);
                    paintedAreas.put(paintedAreaKey, nextPaintedArea.getValue());
                    paintedAreas.remove(nextPaintedArea.getKey());
                }
            }
        }

        return newPaint;
    }
}
