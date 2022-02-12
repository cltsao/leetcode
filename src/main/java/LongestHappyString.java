import java.util.Arrays;

public class LongestHappyString {
    class CharCount implements Comparable<CharCount> {
        char ch;
        int count;
        CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(CharCount o) {
            return o.count - count;
        }

        @Override
        public String toString() {
            return ch + ":" + count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        CharCount[] characters = new CharCount[3];
        characters[0] = new CharCount('a', a);
        characters[1] = new CharCount('b', b);
        characters[2] = new CharCount('c', c);
        Arrays.sort(characters);
        if (characters[0].count == 0) return "";

        StringBuilder sb = new StringBuilder();
        char lastChar = ' ';
        while(characters[1].count > 0) {
            if (characters[0].ch != lastChar) {
                if (characters[0].count > 1) {
                    sb.append(characters[0].ch).append(characters[0].ch);
                    characters[0].count -= 2;
                } else {
                    sb.append(characters[0].ch);
                    --characters[0].count;
                }
                lastChar = characters[0].ch;
            } else {
                sb.append(characters[1].ch);
                --characters[1].count;
                lastChar = characters[1].ch;
            }
            Arrays.sort(characters);
        }
        if (characters[0].ch != lastChar) {
            if (characters[0].count > 1) {
                sb.append(characters[0].ch).append(characters[0].ch);
            } else {
                sb.append(characters[0].ch);
            }
        }
        return sb.toString();
    }
}
