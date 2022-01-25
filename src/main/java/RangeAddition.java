import java.util.Arrays;

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] numbers = new int[length];
        Arrays.fill(numbers, 0);
        for(int[] update : updates) {
            numbers[update[0]] += update[2];
            if (update[1] < length - 1) numbers[update[1] + 1] -= update[2];
        }
        for(int i = 1; i < numbers.length; ++i) {
            numbers[i] += numbers[i - 1];
        }
        return numbers;
    }
}
