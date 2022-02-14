import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistributeCoinsInBinaryTreeTest {
    DistributeCoinsInBinaryTree solution = new DistributeCoinsInBinaryTree();

    @Test
    public void testExample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        assertEquals(2, solution.distributeCoins(root));
    }

    @Test
    public void testExample2() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(3);
        root.right = new TreeNode(0);
        assertEquals(3, solution.distributeCoins(root));
    }
}
