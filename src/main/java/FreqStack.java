import java.util.*;

public class FreqStack {
    Map<Integer, Integer> valFreqMap;
    Map<Integer, Stack<Integer>> freqValMap;

    public FreqStack() {
        valFreqMap = new HashMap<>();
        freqValMap = new HashMap<>();
    }

    public void push(int val) {
        int freq = valFreqMap.getOrDefault(val, 0) + 1;
        valFreqMap.put(val, freq);
        if (freqValMap.size() < freq) freqValMap.put(freq, new Stack<>());
        freqValMap.get(freq).push(val);
    }

    public int pop() {
        Stack<Integer> stack = freqValMap.get(freqValMap.size());
        if(stack.size() == 1) freqValMap.remove(freqValMap.size());
        int val = stack.pop();
        valFreqMap.put(val, valFreqMap.get(val) - 1);
        return val;
    }
}
