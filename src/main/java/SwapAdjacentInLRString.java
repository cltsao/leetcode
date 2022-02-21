import java.util.LinkedList;
import java.util.Queue;

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;

        Queue<Integer> indexes = new LinkedList<>();
        for(int i = 1; i <= start.length(); ++i) {
            switch(start.charAt(i - 1)) {
                case 'L':
                    indexes.add(i);
                    break;
                case 'R':
                    indexes.add(-i);
                    break;
            }
        }

        for(int i = 1; i <= end.length(); ++i) {
            switch(end.charAt(i - 1)) {
                case 'L':
                    Integer index = indexes.poll();
                    if(index == null || index < i) return false;  // include R index which would be negative
                    break;
                case 'R':
                    index = indexes.poll();
                    if(index == null || index < -i) return false;  // include L index which would be positive
                    break;
            }
        }

        return indexes.isEmpty();
    }
}
