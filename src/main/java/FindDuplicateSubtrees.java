import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    List<TreeNode> duplicateSubtrees;

    Map<String, Integer> subtreeCount;

    final static char NULL = (char) -201;

    String visitNode(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node.left == null) sb.append(NULL);
        else sb.append(visitNode(node.left));
        if (node.right == null) sb.append(NULL);
        else sb.append(visitNode(node.right));
        sb.append((char)node.val);
        String subtreeSignature = sb.toString();
        subtreeCount.put(subtreeSignature, subtreeCount.getOrDefault(subtreeSignature, 0) + 1);
        if (subtreeCount.get(subtreeSignature) == 2) duplicateSubtrees.add(node);
        return subtreeSignature;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        duplicateSubtrees = new ArrayList<>();
        subtreeCount = new HashMap<>();

        // Root cannot duplicate with any subtree, so start with its children
        if (root.left != null) visitNode(root.left);
        if (root.right != null) visitNode(root.right);
        return duplicateSubtrees;
    }
}
