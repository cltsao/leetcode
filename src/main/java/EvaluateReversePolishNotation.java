import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            switch(token) {
                case "+":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.add(num2 + num1);
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.add(num2 - num1);
                    break;
                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.add(num2 * num1);
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.add(num2 / num1);
                    break;
                default:
                    stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
