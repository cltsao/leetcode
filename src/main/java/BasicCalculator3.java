import java.util.Stack;

public class BasicCalculator3 {
    public int calculate(String s) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        valueStack.add(0);  // To add the first number onto
        for(char c : s.toCharArray()) {
            switch(c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (hasPrecedentOperator(operatorStack, c)) {
                        int v2 = valueStack.pop();
                        int v1 = valueStack.pop();
                        valueStack.push(eval(operatorStack.pop(), v1, v2));
                    }
                    operatorStack.push(c);
                    valueStack.push(0);  // Placeholder for the next number
                    break;
                case '(':
                    operatorStack.push(c);
                    break;
                case ')':
                    while(operatorStack.peek() != '(') {
                        int v2 = valueStack.pop();
                        int v1 = valueStack.pop();
                        valueStack.push(eval(operatorStack.pop(), v1, v2));
                    }
                    operatorStack.pop(); // pop (
                    break;
                default:
                    // Number
                    valueStack.push(valueStack.pop() * 10 + (c - '0'));
                    break;
            }
        }
        while(!operatorStack.isEmpty()) {
            int v2 = valueStack.pop();
            int v1 = valueStack.pop();
            valueStack.push(eval(operatorStack.pop(), v1, v2));
        }
        return valueStack.pop();
    }

    int eval(char op, int v1, int v2) {
        switch(op) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                return v1 / v2;
            default:
                System.err.println("Unexpected operator " + op);
                return 0;
        }
    }

    // Including same precedence
    boolean hasPrecedentOperator(Stack<Character> stack, char op) {
        if (stack.isEmpty()) return false;
        return (getPrecedence(stack.peek()) >= getPrecedence(op));
    }

    int getPrecedence(char op) {
        switch(op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
                return 0;  // Process last when seeing )
            default:
                System.err.println("Unexpected operator " + op);
                return 0;
        }
    }
}
