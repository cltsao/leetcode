import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoundaryOfBinaryTreeTest {
    BoundaryOfBinaryTree solution = new BoundaryOfBinaryTree();

    @Test
    public void testExample1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        List<Integer> result = solution.boundaryOfBinaryTree(root);
        assertThat(result).containsExactlyElementsOf(List.of(1,3,4,2));
    }

    @Test
    public void testExample2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        List<Integer> result = solution.boundaryOfBinaryTree(root);
        assertThat(result).containsExactlyElementsOf(List.of(1,2,4,7,8,9,10,6,3));
    }

    @Test
    public void testExample3() {
        TreeNode root = new TreeNode(1);
        List<Integer> result = solution.boundaryOfBinaryTree(root);
        assertThat(result).containsExactlyElementsOf(List.of(1));
    }
}
