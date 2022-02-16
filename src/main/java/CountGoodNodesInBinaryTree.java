public class CountGoodNodesInBinaryTree {
    private int count;

    private void visitNode(TreeNode node, int max) {
        if (node.val >= max) {
            ++count;
            max = node.val;
        }
        if (node.left != null) visitNode(node.left, max);
        if (node.right != null) visitNode(node.right, max);
    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        visitNode(root, Integer.MIN_VALUE);
        return count;
    }
}
