import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    List<List<Integer>> output = new ArrayList<>();

    int traverseNode(TreeNode node) {
        int leftDistance = -1, rightDistance = -1;
        if (node.left != null) leftDistance = traverseNode(node.left);
        if (node.right != null) rightDistance = traverseNode(node.right);
        int distance = Math.max(leftDistance, rightDistance) + 1;
        while (output.size() <= distance) output.add(new ArrayList<>());
        output.get(distance).add(node.val);
        return distance;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        output = new ArrayList<>();
        traverseNode(root);
        return output;
    }
}
