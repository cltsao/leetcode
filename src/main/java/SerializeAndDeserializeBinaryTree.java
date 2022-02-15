public class SerializeAndDeserializeBinaryTree {
    static final char NULL = (char)1001;

    private StringBuilder sb;

    private void doSerialize(TreeNode node) {
        char encodedValue = (char)node.val;
        sb.append(encodedValue);
        if (node.left == null) sb.append(NULL);
        else doSerialize(node.left);

        if (node.right == null) sb.append(NULL);
        else doSerialize(node.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        if (root != null) doSerialize(root);
        return sb.toString();
    }

    private char[] encodedValues;

    private int pos;

    private TreeNode deserialize() {
        if (++pos >= encodedValues.length) return null;
        if (encodedValues[pos] != NULL) {
            TreeNode node = new TreeNode((short)encodedValues[pos]);
            node.left = deserialize();
            node.right = deserialize();
            return node;
        } else {
            return null;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        encodedValues = data.toCharArray();
        pos = -1;
        return deserialize();
    }
}
