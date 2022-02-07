import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepByStepDirectionsFromBinaryTreeNodeToAnotherTest {
    StepByStepDirectionsFromBinaryTreeNodeToAnother solution = new StepByStepDirectionsFromBinaryTreeNodeToAnother();

    @Test
    public void testExample1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        assertEquals("UURL", solution.getDirections(root, 3, 6));
    }

    @Test
    public void testExample2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        assertEquals("L", solution.getDirections(root, 2, 1));
    }
}
