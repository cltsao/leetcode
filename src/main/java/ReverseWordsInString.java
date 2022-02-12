public class ReverseWordsInString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(int i = words.length - 1; i >= 0; --i)
            if (words[i].length() > 0)
                sb.append(words[i]).append(' ');
        return sb.toString().trim();
    }
}
