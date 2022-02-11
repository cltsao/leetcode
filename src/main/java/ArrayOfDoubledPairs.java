import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ArrayOfDoubledPairs {
    boolean containsDoubledPairs(List<Integer> numbers) {
        if (numbers.size() == 0) return true;
        if (numbers.size() % 2 == 1) return false;
        Deque<Integer> numbersToPair = new LinkedList<>();
        numbersToPair.addLast(numbers.get(0));
        for(int i = 1; i < numbers.size(); ++i) {
            if (!numbersToPair.isEmpty() && numbers.get(i) == numbersToPair.peekFirst() * 2) {
                numbersToPair.removeFirst();
            } else {
                numbersToPair.addLast(numbers.get(i));
            }
        }
        return numbersToPair.isEmpty();
    }

    public boolean canReorderDoubled(int[] arr) {
        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();
        int countZeros = 0;
        for(int num : arr) {
            if (num > 0) positiveNumbers.add(num);
            else if (num < 0) negativeNumbers.add(num);
            else ++countZeros;
        }

        if (countZeros % 2 == 1) return false;
        Collections.sort(positiveNumbers);
        Collections.sort(negativeNumbers, (i1, i2) -> (i2 - i1));
        return containsDoubledPairs(positiveNumbers) && containsDoubledPairs(negativeNumbers);
    }
}
