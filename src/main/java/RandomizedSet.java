import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    private ArrayList<Integer> numbers;
    private HashMap<Integer, Integer> numberIndex;

    public RandomizedSet() {
        numbers = new ArrayList<>();
        numberIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        if(numberIndex.containsKey(val)) return false;

        numbers.add(val);
        numberIndex.put(val, numbers.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!numberIndex.containsKey(val)) return false;

        int index = numberIndex.get(val);
        int lastNumber = numbers.get(numbers.size() - 1);
        if (val != lastNumber) {
            numbers.set(index, lastNumber);
            numberIndex.put(lastNumber, index);
        }
        numbers.remove(numbers.size() - 1);
        numberIndex.remove(val);

        return true;
    }

    Random random = new Random();

    public int getRandom() {
        return numbers.get(random.nextInt(numbers.size()));
    }
}
