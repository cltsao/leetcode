import java.util.Stack;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

public class DesignAnExpressionTreeWithEvaluateFunction {
    abstract class Node {
        public abstract int evaluate();
        Integer value;
        String operator;
        Node left;
        Node right;
    }

    class ExpressionNode extends Node {
        ExpressionNode(String str) {
            switch(str) {
                case "+":
                case "-":
                case "*":
                case "/":
                    operator = str;
                    break;
                default:
                    value = Integer.parseInt(str);
            }
        }

        @Override
        public int evaluate() {
            if (operator != null)
                switch(operator) {
                    case "+":
                        return left.evaluate() + right.evaluate();
                    case "-":
                        return left.evaluate() - right.evaluate();
                    case "*":
                        return left.evaluate() * right.evaluate();
                    case "/":
                        return left.evaluate() / right.evaluate();
                    default:
                        System.err.println("Unsupported operator " + operator);
                        return 0;
                }
            else
                return value;
        }
    }

    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        for(String str : postfix) {
            Node node = new ExpressionNode(str);
            if (node.operator != null) {
                node.right = stack.pop();
                node.left = stack.pop();
            }
            stack.add(node);
        }
        return stack.pop();
    }
}
