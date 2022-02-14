public class DistributeCoinsInBinaryTree {
    int movements = 0;

    private int visitNode(TreeNode node) {
        if (node.left != null) {
            node.val += visitNode(node.left);
        }
        if (node.right != null) {
            node.val += visitNode(node.right);
        }
        movements += Math.abs(node.val - 1);
        return node.val - 1;
    }

    public int distributeCoins(TreeNode root) {
        movements = 0;
        visitNode(root);
        return movements;
    }
}
