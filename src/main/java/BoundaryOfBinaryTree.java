import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BoundaryOfBinaryTree {
    List<Integer> boundary;

    private void visitLeaves(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null)
            boundary.add(node.val);
        else {
            visitLeaves(node.left);
            visitLeaves(node.right);
        }
    }

    private void rightBoundary(TreeNode node) {
        if(node.right != null) {
            rightBoundary(node.right);
        } else if (node.left != null){
            rightBoundary(node.left);
        }
        if (node.left != null || node.right != null) boundary.add(node.val);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        boundary = new ArrayList<>();
        boundary.add(root.val);
        if (root.left != null) {
            TreeNode node = root.left;
            while (node != null) {
                if (node.left != null || node.right != null) boundary.add(node.val);
                node = node.left != null ? node.left : node.right;
            }
        }

        visitLeaves(root.left);
        visitLeaves(root.right);

        if (root.right != null) rightBoundary(root.right);

        return boundary;
    }
}
