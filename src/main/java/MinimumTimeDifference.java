import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size() * 2];
        int pos = 0;
        for(String timePoint : timePoints) {
            String[] tokens = timePoint.split(":");
            int hour = Integer.parseInt(tokens[0]);
            int minute = Integer.parseInt(tokens[1]);
            int minuteValue = hour * 60 + minute;
            minutes[pos++] = minuteValue;
            minutes[pos++] = minuteValue + 24 * 60;
        }
        Arrays.sort(minutes);
        int minDiff = Integer.MAX_VALUE;
        int lastMin = minutes[0];
        for(int i = 1; i < minutes.length; ++i) {
            int diff = minutes[i] - lastMin;
            minDiff = Math.min(minDiff, diff);
            lastMin = minutes[i];
        }
        return minDiff;
    }
}
