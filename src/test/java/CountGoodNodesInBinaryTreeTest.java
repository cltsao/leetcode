import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountGoodNodesInBinaryTreeTest {
    CountGoodNodesInBinaryTree solution = new CountGoodNodesInBinaryTree();

    @Test
    public void testExample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        assertEquals(4, solution.goodNodes(root));
    }

    @Test
    public void testExample2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        assertEquals(3, solution.goodNodes(root));
    }

    @Test
    public void testExample3() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, solution.goodNodes(root));
    }
}
