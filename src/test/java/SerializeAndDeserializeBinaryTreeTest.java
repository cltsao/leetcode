import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializeAndDeserializeBinaryTreeTest {
    SerializeAndDeserializeBinaryTree solution = new SerializeAndDeserializeBinaryTree();

    @Test
    public void testExample1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialized = solution.serialize(root);
        TreeNode deserialized = solution.deserialize(serialized);
        assertEquals(1, deserialized.val);
        assertEquals(2, deserialized.left.val);
        assertEquals(null, deserialized.left.left);
        assertEquals(null, deserialized.left.right);
        assertEquals(3, deserialized.right.val);
        assertEquals(4, deserialized.right.left.val);
        assertEquals(null, deserialized.right.left.left);
        assertEquals(null, deserialized.right.left.right);
        assertEquals(5, deserialized.right.right.val);
        assertEquals(null, deserialized.right.right.left);
        assertEquals(null, deserialized.right.right.right);
    }

    @Test
    public void testExample2() {
        TreeNode root = null;
        String serialized = solution.serialize(root);
        TreeNode deserialized = solution.deserialize(serialized);
        assertEquals(null, root);
    }

    @Test
    public void testExample3() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(-7);
        root.right = new TreeNode(-3);
        String serialized = solution.serialize(root);
        TreeNode deserialized = solution.deserialize(serialized);
        assertEquals(4, deserialized.val);
        assertEquals(-7, deserialized.left.val);
        assertEquals(-3, deserialized.right.val);
    }
}
