import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SpiralMatrixTest {
    SpiralMatrix solution = new SpiralMatrix();

    @Test
    public void testExample1() {
        assertThat(solution.spiralOrder(new int[][] {new int[]{1,2,3},new int[]{4,5,6},new int[]{7,8,9}})).containsExactlyElementsOf(List.of(1,2,3,6,9,8,7,4,5));
    }

    @Test
    public void testExample2() {
        assertThat(solution.spiralOrder(new int[][] {new int[]{1,2,3,4},new int[]{5,6,7,8},new int[]{9,10,11,12}})).containsExactlyElementsOf(List.of(1,2,3,4,8,12,11,10,9,5,6,7));
    }
}
