import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAllPossibleRecipesFromGivenSuppliesTest {
    FindAllPossibleRecipesFromGivenSupplies solution = new FindAllPossibleRecipesFromGivenSupplies();

    @Test
    public void testExample1() {
        List<String> results = solution.findAllRecipes(new String[] {"bread"}, List.of(List.of("yeast","flour")), new String[] {"yeast","flour","corn"});
        assertThat(results).hasSameElementsAs(List.of("bread"));
    }

    @Test
    public void testExample2() {
        List<String> results = solution.findAllRecipes(new String[] {"bread","sandwich"}, List.of(List.of("yeast","flour"), List.of("bread","meat")), new String[] {"yeast","flour","meat"});
        assertThat(results).hasSameElementsAs(List.of("bread","sandwich"));
    }

    @Test
    public void testExample3() {
        List<String> results = solution.findAllRecipes(new String[] {"bread","sandwich","burger"}, List.of(List.of("yeast","flour"), List.of("bread","meat"), List.of("sandwich","meat","bread")), new String[] {"yeast","flour","meat"});
        assertThat(results).hasSameElementsAs(List.of("bread","sandwich","burger"));
    }

    @Test
    public void testExample4() {
        List<String> results = solution.findAllRecipes(new String[] {"ju","fzjnm","x","e","zpmcz","h","q"}, List.of(List.of("d"),List.of("hveml","f","cpivl"),List.of("cpivl","zpmcz","h","e","fzjnm","ju"),List.of("cpivl","hveml","zpmcz","ju","h"),List.of("h","fzjnm","e","q","x"),List.of("d","hveml","cpivl","q","zpmcz","ju","e","x"),List.of("f","hveml","cpivl")), new String[] {"f","hveml","cpivl","d"});
        assertThat(results).hasSameElementsAs(List.of("ju","fzjnm","q"));
    }

    @Test
    public void testExample5() {
        List<String> results = solution.findAllRecipes(new String[] {"qxyj","vawos","nkov","bec","qiabz"}, List.of(List.of("mxf"),List.of("iy","qxyj","nkov","qiabz","bec"),List.of("nw","xutnl","e"),List.of("eep","km","nw","xutnl","e","iy","vawos","qxyj","qiabz"),List.of("nyhyc")), new String[] {"nw","eep","iy","e","xutnl","km"});
        //assertThat(results).hasSameElementsAs(List.of("ju","fzjnm","q"));
    }
}
