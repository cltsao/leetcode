// Maintaining a tree structure. If tree is not balanced, operation complexity = O(N)
public class StockPriceTree {
    class TreeNode {
        int timestamp;
        int price;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        TreeNode min;
        TreeNode max;

        TreeNode(TreeNode parent, int timestamp, int price) {
            this.parent = parent;
            this.timestamp = timestamp;
            this.price = price;
            max = min = this;
        }
    }

    TreeNode root;

    public StockPriceTree() {
    }

    public void update(int timestamp, int price) {
        if (root == null) root = new TreeNode(null, timestamp, price);
        else {
            TreeNode node = root;
            TreeNode updatedNode = null;
            while(node != null) {
                if (node.timestamp == timestamp) {
                    node.price = price;
                    updatedNode = node;
                    break;
                } else if (node.timestamp > timestamp) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        updatedNode = node.left = new TreeNode(node, timestamp, price);
                        break;
                    }
                } else {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        updatedNode = node.right = new TreeNode(node, timestamp, price);
                        break;
                    }
                }
            }

            node = updatedNode;
            while(node != null) {
                node.min = node;
                node.max = node;
                if (node.left != null) {
                    if (node.left.min.price < node.min.price)
                        node.min = node.left.min;
                    if (node.left.max.price > node.max.price)
                        node.max = node.left.max;
                }
                if (node.right != null) {
                    if (node.right.min.price < node.min.price)
                        node.min = node.right.min;
                    if (node.right.max.price > node.max.price)
                        node.max = node.right.max;
                }
                node = node.parent;
            }
        }
    }

    public int current() {
        TreeNode node = root;
        while(node.right != null) node = node.right;
        return node.price;
    }

    public int maximum() {
        return root.max.price;
    }

    public int minimum() {
        return root.min.price;
    }
}
