import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectSquaresTest {
    @Test
    public void testExample1() {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});
        assertEquals(1, detectSquares.count(new int[] {11, 10})); // return 1. You can choose:
        //   - The first, second, and third points
        assertEquals(0, detectSquares.count(new int[] {14, 8}));  // return 0. The query point cannot form a square with any points in the data structure.
        detectSquares.add(new int[] {11, 2});    // Adding duplicate points is allowed.
        assertEquals(2, detectSquares.count(new int[] {11, 10})); // return 2. You can choose:
        //   - The first, second, and third points
        //   - The first, third, and fourth points
    }

    @Test
    public void testExample2() {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] {5,10});
        detectSquares.add(new int[] {10,5});
        detectSquares.add(new int[] {10,10});
        assertEquals(1, detectSquares.count(new int[] {5,5}));
        detectSquares.add(new int[] {3,0});
        detectSquares.add(new int[] {8,0});
        detectSquares.add(new int[] {8,5});
        assertEquals(1, detectSquares.count(new int[] {3,5}));
        detectSquares.add(new int[] {9,0});
        detectSquares.add(new int[] {9,8});
        detectSquares.add(new int[] {1,8});
        assertEquals(1, detectSquares.count(new int[] {1,0}));
        detectSquares.add(new int[] {0,0});
        detectSquares.add(new int[] {8,0});
        detectSquares.add(new int[] {8,8});
        assertEquals(2, detectSquares.count(new int[] {0,8}));
        detectSquares.add(new int[] {1,9});
        detectSquares.add(new int[] {2,9});
        detectSquares.add(new int[] {2,10});
        assertEquals(1, detectSquares.count(new int[] {1,10}));
        detectSquares.add(new int[] {7,8});
        detectSquares.add(new int[] {2,3});
        detectSquares.add(new int[] {2,8});
        assertEquals(1, detectSquares.count(new int[] {7,3}));
        detectSquares.add(new int[] {9,10});
        detectSquares.add(new int[] {9,5});
        detectSquares.add(new int[] {4,5});
        assertEquals(1, detectSquares.count(new int[] {4,10}));
        detectSquares.add(new int[] {0,9});
        detectSquares.add(new int[] {4,5});
        detectSquares.add(new int[] {4,9});
        assertEquals(2, detectSquares.count(new int[] {0,5}));
        detectSquares.add(new int[] {1,10});
        detectSquares.add(new int[] {10,1});
        detectSquares.add(new int[] {10,10});
        assertEquals(2, detectSquares.count(new int[] {1,1}));
        detectSquares.add(new int[] {10,0});
        detectSquares.add(new int[] {2,0});
        detectSquares.add(new int[] {2,8});
        assertEquals(2, detectSquares.count(new int[] {10,8}));
        detectSquares.add(new int[] {7,6});
        detectSquares.add(new int[] {4,6});
        detectSquares.add(new int[] {4,9});
        assertEquals(2, detectSquares.count(new int[] {7,9}));
        detectSquares.add(new int[] {10,9});
        detectSquares.add(new int[] {10,0});
        detectSquares.add(new int[] {1,0});
        assertEquals(5, detectSquares.count(new int[] {1,9}));
    }
}
