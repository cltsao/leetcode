import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnapshotArrayTest {
    @Test
    public void testExample1() {
        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0,5);  // Set array[0] = 5
        snapshotArr.snap();  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0,6);
        assertEquals(5, snapshotArr.get(0,0));  // Get the value of array[0] with snap_id = 0, return 5
    }
}
