import java.util.Deque;
import java.util.LinkedList;

public class StepByStepDirectionsFromBinaryTreeNodeToAnother {
    int numUps;
    Deque<Character> downDirections;

    // Returns whether startValue and destValue are found
    boolean[] visitNode(TreeNode node, int startValue, int destValue) {
        boolean[] leftResult = node.left != null ? visitNode(node.left, startValue, destValue) : new boolean[2];
        if (leftResult[0] && leftResult[1]) return leftResult; // No need to traverse right
        boolean[] rightResult = node.right != null ? visitNode(node.right, startValue, destValue) : new boolean[2];

        if ((leftResult[0] && !leftResult[1]) || (rightResult[0] && !rightResult[1])) ++numUps;
        if ((leftResult[1] && !leftResult[0])) downDirections.addFirst('L');
        if ((rightResult[1] && !rightResult[0])) downDirections.addFirst('R');

        return new boolean[] {leftResult[0] || rightResult[0] || node.val == startValue, leftResult[1] || rightResult[1] || node.val == destValue};
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        numUps = 0;
        downDirections = new LinkedList<>();
        visitNode(root, startValue, destValue);
        StringBuilder sb = new StringBuilder();
        while(--numUps >= 0) sb.append('U');
        for(Character c : downDirections) sb.append(c);
        return sb.toString();
    }
}
