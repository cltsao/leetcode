public class InorderSuccessorInBST {
    private TreeNode getSuccessor(TreeNode node, TreeNode p) {
        if (node.val > p.val) {
            if (node.left != null) {
                TreeNode successor = getSuccessor(node.left, p);
                if (successor != null) return successor;
            }
            return node;
        }

        if (node.right != null)
            return getSuccessor(node.right, p);
        else
            return null;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return getSuccessor(root, p);
    }
}
