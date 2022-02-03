import java.util.Arrays;

public class MinimumSwapsToGroupAllOnesTogether {
    public int minSwaps(int[] data) {
        int onesCount = (int) Arrays.stream(data).filter(number -> number == 1).count();
        int sum = 0;
        for(int i = 0; i < onesCount; ++i) {
            sum += data[i];
        }
        int maxSum = sum;
        for (int i = onesCount; i < data.length; ++i) {
            sum += data[i];
            sum -= data[i - onesCount];
            maxSum = Math.max(maxSum, sum);
        }
        return onesCount - maxSum;
    }
}
