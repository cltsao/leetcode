import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> multipliers = new Stack<>();
        Stack<StringBuilder> textBuilders = new Stack<>();

        int start = 0;
        StringBuilder currentTextBuilder = new StringBuilder();
        for(int end = 0; end < s.length(); ++end) {
            switch(s.charAt(end)) {
                case '[':
                    multipliers.push(Integer.parseInt(s.substring(start, end)));
                    textBuilders.push(currentTextBuilder);
                    currentTextBuilder = new StringBuilder();
                    start = end + 1;
                    break;
                case ']':
                    int multiplier = multipliers.pop();
                    String textValue = currentTextBuilder.toString();
                    currentTextBuilder = textBuilders.pop();
                    while(--multiplier >= 0) currentTextBuilder.append(textValue);
                    start = end + 1;
                    break;
                default:
                    if (s.charAt(end) >= 'A') {
                        currentTextBuilder.append(s.charAt(end));
                        start = end + 1;
                    }
            }
        }
        return currentTextBuilder.toString();
    }
}
