import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfIslandsTest {
    NumberOfIslands noi = new NumberOfIslands();

    @Test
    public void testExample1() {
        assertEquals(1, noi.numIslands(new char[][]{
                new char[]{'1','1','1','1','0'},
                new char[]{'1','1','0','1','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'0','0','0','0','0'}
        }));
    }

    @Test
    public void testExample2() {
        assertEquals(3, noi.numIslands(new char[][]{
                new char[]{'1','1','0','0','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'0','0','1','0','0'},
                new char[]{'0','0','0','1','1'}
        }));
    }
}
