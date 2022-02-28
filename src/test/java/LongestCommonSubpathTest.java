import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonSubpathTest {
    LongestCommonSubpath solution = new LongestCommonSubpath();

    @Test
    public void testExample1() {
        assertEquals(2, solution.longestCommonSubpath(5, new int[][] {new int[]{0,1,2,3,4},new int[]{2,3,4},new int[]{4,0,1,2,3}}));
    }

    @Test
    public void testExample2() {
        assertEquals(0, solution.longestCommonSubpath(5, new int[][] {new int[]{0},new int[]{1},new int[]{2}}));
    }

    @Test
    public void testExample3() {
        assertEquals(1, solution.longestCommonSubpath(5, new int[][] {new int[]{0,1,2,3,4},new int[]{4,3,2,1,0}}));
    }

    @Test
    public void testExample4() {
        assertEquals(33, solution.longestCommonSubpath(472, new int[][] {new int[]{281,299,414,66,265,398,287,105,218,28,246,445,186,291,283,102,258,211,248,416,182,212,177,0,275,276,319,402,313,169,234,307,14,411,117,92,440,46,408,282},new int[]{16,430,344,36,414,66,265,398,287,105,218,28,246,445,186,291,283,102,258,211,248,416,182,212,177,0,275,276,319,402,313,169,234,307,14,411,117,42,444,8}}));
    }

    @Test
    public void testExample5() {
        assertEquals(10, solution.longestCommonSubpath(405, new int[][] {new int[]{340,88,187,280,359,397,300,255,258,201,301,17,245,124,380,206,345,377,191},new int[]{224,300,255,258,201,301,17,245,124,380,206,339,260,55,398,83,266,201,189},new int[]{375,15,240,22,157,360,314,300,255,258,201,301,17,245,124,380,206,303,296},new int[]{331,87,86,257,116,6,300,255,258,201,301,17,245,124,380,206,394,102,276},new int[]{118,207,263,176,295,180,235,137,300,255,258,201,301,17,245,124,380,206,337}}));
    }
}
