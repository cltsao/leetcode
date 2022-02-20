import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcelTest {
    @Test
    public void testExample1() {
        Excel excel = new Excel(3, 'C');
        // construct a 3*3 2D array with all zero.
        //   A B C
        // 1 0 0 0
        // 2 0 0 0
        // 3 0 0 0
        excel.set(1, 'A', 2);
        // set mat[1]["A"] to be 2.
        //   A B C
        // 1 2 0 0
        // 2 0 0 0
        // 3 0 0 0
        assertEquals(4, excel.sum(3, 'C', new String[]{"A1", "A1:B2"})); // return 4
        // set mat[3]["C"] to be the sum of value at mat[1]["A"] and the values sum of the rectangle range whose top-left cell is mat[1]["A"] and bottom-right cell is mat[2]["B"].
        //   A B C
        // 1 2 0 0
        // 2 0 0 0
        // 3 0 0 4
        excel.set(2, 'B', 2);
        // set mat[2]["B"] to be 2. Note mat[3]["C"] should also be changed.
        //   A B C
        // 1 2 0 0
        // 2 0 2 0
        // 3 0 0 6
        assertEquals(6, excel.get(3, 'C')); // return 6
    }

    @Test
    public void testExample2() {
        Excel excel = new Excel(3, 'C');
        assertEquals(0, excel.sum(1, 'A', new String[]{"A2"}));
        excel.set(2, 'A', 1);
        assertEquals(1, excel.get(1, 'A')); // return 6
    }
}
