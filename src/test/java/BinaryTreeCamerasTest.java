import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeCamerasTest {
    BinaryTreeCameras solution = new BinaryTreeCameras();

    @Test
    public void testExample1() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        assertEquals(1, solution.minCameraCover(root));
    }

    @Test
    public void testExample2() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(0);
        root.left.left.left.right = new TreeNode(0);
        assertEquals(2, solution.minCameraCover(root));
    }
}
