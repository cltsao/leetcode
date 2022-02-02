import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumAdjacentSwapsforKConsecutiveOnesTest {
    MinimumAdjacentSwapsforKConsecutiveOnes mawkco = new MinimumAdjacentSwapsforKConsecutiveOnes();

    @Test
    public void testExample1() {
        assertEquals(1, mawkco.minMoves(new int[]{1,0,0,1,0,1}, 2));
    }

    @Test
    public void testExample2() {
        assertEquals(5, mawkco.minMoves(new int[]{1,0,0,0,0,0,1,1}, 3));
    }

    @Test
    public void testExample3() {
        assertEquals(0, mawkco.minMoves(new int[]{1,1,0,1}, 2));
    }

    @Test
    public void testExample4() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("minimum-adjacent-swaps-for-k-consecutive-ones-4.txt")));
        int[] nums = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(",")).mapToInt((i) -> Integer.parseInt(i)).toArray();
        mawkco.minMoves(nums, 14504);
    }
}
