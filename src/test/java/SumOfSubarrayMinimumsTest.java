import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfSubarrayMinimumsTest {
    SumOfSubarrayMinimums sosm = new SumOfSubarrayMinimums();

    @Test
    public void testExample1() {
        assertEquals(17, sosm.sumSubarrayMins(new int[]{3,1,2,4}));
    }

    @Test
    public void testExample2() {
        assertEquals(444, sosm.sumSubarrayMins(new int[]{11,81,94,43,3}));
    }

    @Test
    public void testExample3() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("sum-of-subarray-minimums-3.txt")));
        int[] nums = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(",")).mapToInt((i) -> Integer.parseInt(i)).toArray();
        assertEquals(667452382, sosm.sumSubarrayMins(nums));
    }

    @Test
    public void testExample4() {
        assertEquals(963, sosm.sumSubarrayMins(new int[]{11,81,94,43,3,11,81,94,43,3}));
    }
}
