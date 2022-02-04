import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindLeavesOfBinaryTreeTest {
    FindLeavesOfBinaryTree flobt = new FindLeavesOfBinaryTree();

    @Test
    public void testExample1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> results = flobt.findLeaves(root);
        assertThat(results.get(0)).hasSameElementsAs(List.of(4, 5, 3));
        assertThat(results.get(1)).hasSameElementsAs(List.of(2));
        assertThat(results.get(2)).hasSameElementsAs(List.of(1));
    }

    @Test
    public void testExample2() {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> results = flobt.findLeaves(root);
        assertThat(results.get(0)).hasSameElementsAs(List.of(1));
    }
}
