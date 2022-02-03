import java.util.Stack;

class Node {
    char val;
    Node left;
    Node right;

    Node() {
        this.val = ' ';
    }

    Node(char val) {
        this.val = val;
    }

    Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BuildBinaryExpressionTreeFromInfixExpression {
    int getPrecedenceOrder(char op) {
        switch(op) {
            case ')':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            case '(':
            default:
                return 0;
        }
    }

    int comparePrecedence(char op1, char op2) {
        return getPrecedenceOrder(op1) - getPrecedenceOrder(op2);
    }

    Stack<Node> operands;
    Stack<Node> numbers;

    void processOperand() {
        Node operand = operands.pop();
        operand.right = numbers.pop();
        operand.left = numbers.pop();
        numbers.push(operand);
    }

    public Node expTree(String s) {
        operands = new Stack<>();
        numbers = new Stack<>();
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch(c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (operands.size() > 0 && comparePrecedence(operands.peek().val, c) >= 0) {
                        processOperand();
                    }
                    operands.add(new Node(c));
                    break;
                case '(':
                    operands.add(new Node(c));
                    break;
                case ')':
                    while (operands.size() > 0 && operands.peek().val != '(') {
                        processOperand();
                    }
                    operands.pop();
                    break;
                default:
                    numbers.add(new Node(c));
                    break;
            }
        }

        while(!operands.isEmpty()) {
            processOperand();
        }

        return numbers.pop();
    }
}
