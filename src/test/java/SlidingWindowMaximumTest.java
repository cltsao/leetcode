import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SlidingWindowMaximumTest {
    SlidingWindowMaximum swm = new SlidingWindowMaximum();

    @Test
    public void testExample1() {
       int[] results = swm.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
       assertArrayEquals(new int[] {3,3,5,5,6,7}, results);
    }

    @Test
    public void testExample2() {
        int[] results = swm.maxSlidingWindow(new int[]{1}, 1);
        assertArrayEquals(new int[] {1}, results);
    }

    @Test
    public void testExample3() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("sliding-window-maximum-3.txt")));

        int[] nums = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(",")).mapToInt((i) -> Integer.parseInt(i)).toArray();
        int[] results = swm.maxSlidingWindow(nums, 50000);
        //assertArrayEquals(new int[] {1}, results);
    }
}
