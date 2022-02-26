import java.util.Stack;

public class MinimumCostToChangeTheFinalValueOfExpression {
    class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }

        boolean isOperator() {
            return value == '&' || value == '|';
        }

        private boolean eval;
        boolean evaluate() {
            switch(value) {
                case '0':
                    eval = false;
                    break;
                case '1':
                    eval = true;
                    break;
                case '&':
                    eval = left.evaluate() & right.evaluate();  // Use bitwise operator to ensure that the right child is evaluated.
                    break;
                case '|':
                    eval = left.evaluate() | right.evaluate();
                    break;
                default:
                    System.err.println("Unable to evaluate " + value);
            }
            return eval;
        }

        int costToFlip(boolean desirableEval) {
            if (eval == desirableEval) return 0;

            // Need to flip in all below cases
            switch(value) {
                case '&':
                    if (eval == true) {
                        return Math.min(left.costToFlip(false), right.costToFlip(false));
                    } else {
                        int costLeft = left.costToFlip(true);
                        int costRight = right.costToFlip(true);
                        return Math.min(costLeft + costRight, Math.min(costLeft, costRight) + 1);
                    }
                case '|':
                    if (eval == false) {
                        return Math.min(left.costToFlip(true), right.costToFlip(true));
                    } else {
                        int costLeft = left.costToFlip(false);
                        int costRight = right.costToFlip(false);
                        return Math.min(costLeft + costRight, Math.min(costLeft, costRight) + 1);
                    }
                default:
                    return 1;
            }
        }
    }

    public int minOperationsToFlip(String expression) {
        Stack<Node> stack = new Stack<>();
        for(char c : expression.toCharArray()) {
            switch(c) {
                case '0':
                case '1':
                    Node leaf = new Node(c);
                    if (stack.isEmpty() || stack.peek().value == '(') {
                        stack.add(leaf);
                    } else {
                        Node operator = stack.pop();
                        operator.right = leaf;
                        stack.add(operator);
                    }
                    break;
                case '&':
                case '|':
                    Node operator = new Node(c);
                    leaf = stack.pop();
                    operator.left = leaf;
                    stack.add(operator);
                    break;
                case '(':
                    Node parenthesis = new Node(c);
                    stack.add(parenthesis);
                    break;
                case ')':
                    Node value = stack.pop();
                    stack.pop();  // should be (
                    if (stack.size() > 0 && stack.peek().isOperator()) {
                        operator = stack.pop();
                        operator.right = value;
                        stack.add(operator);
                    } else {
                        stack.add(value);
                    }
                    break;
            }
        }

        Node root = stack.pop();
        boolean evaluation = root.evaluate();
        return root.costToFlip(!evaluation);
    }
}
