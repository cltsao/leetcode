import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAllPeopleWithSecretTest {
    FindAllPeopleWithSecret solution = new FindAllPeopleWithSecret();

    @Test
    public void testExample1() {
        assertThat(List.of(0,1,2,3,5)).hasSameElementsAs(solution.findAllPeople(6, new int[][]{new int[]{1,2,5},new int[]{2,3,8},new int[]{1,5,10}}, 1));
    }

    @Test
    public void testExample2() {
        assertThat(List.of(0,1,3)).hasSameElementsAs(solution.findAllPeople(4, new int[][]{new int[]{3,1,3},new int[]{1,2,2},new int[]{0,3,3}}, 3));
    }

    @Test
    public void testExample3() {
        assertThat(List.of(0,1,2,3,4)).hasSameElementsAs(solution.findAllPeople(5, new int[][]{new int[]{3,4,2},new int[]{1,2,1},new int[]{2,3,1}}, 1));
    }

    @Test
    public void testExample4() {
        assertThat(List.of(0,1,3,4)).hasSameElementsAs(solution.findAllPeople(5, new int[][]{new int[]{1,4,3},new int[]{0,4,3}}, 3));
    }

    @Test
    public void testExample5() {
        assertThat(List.of(0,1,4,5)).hasSameElementsAs(solution.findAllPeople(11, new int[][]{new int[]{5,1,4},new int[]{0,4,18}}, 1));
    }
}
