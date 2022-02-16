import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InorderSuccessorInBSTTest {
    InorderSuccessorInBST solution = new InorderSuccessorInBST();

    @Test
    public void testExample1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        assertEquals(2, solution.inorderSuccessor(root, new TreeNode(1)).val);
    }

    @Test
    public void testExample2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        assertEquals(null, solution.inorderSuccessor(root, new TreeNode(6)));
    }
}
