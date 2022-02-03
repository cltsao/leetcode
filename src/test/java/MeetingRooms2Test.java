import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeetingRooms2Test {
    MeetingRooms2 mr2 = new MeetingRooms2();

    @Test
    public void testExample1() {
        assertEquals(2, mr2.minMeetingRooms(new int[][]{new int[]{0,30},new int[]{5,10},new int[]{15,20}}));
    }

    @Test
    public void testExample2() {
        assertEquals(1, mr2.minMeetingRooms(new int[][]{new int[]{7,10},new int[]{2,4}}));
    }

    @Test
    public void testExample3() {
        assertEquals(2, mr2.minMeetingRooms(new int[][]{new int[]{2,11},new int[]{6,16},new int[]{11,16}}));
    }

    @Test
    public void testExample4() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("meeting-rooms-ii-4.txt")));

        int[][] intervals = Stream.of(bufferedReader.readLine().split("],\\[")).map(str -> Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        assertEquals(1, mr2.minMeetingRooms(intervals));
    }
}
