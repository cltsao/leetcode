import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreqStackTest {
    @Test
    public void testExample1() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        assertEquals(5, freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        assertEquals(7, freqStack.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        assertEquals(5, freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        assertEquals(4, freqStack.pop());   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }

    @Test
    public void testExample2() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(4);
        freqStack.push(0);
        freqStack.push(9);
        freqStack.push(3);
        freqStack.push(4);
        freqStack.push(2);
        assertEquals(4, freqStack.pop());
        freqStack.push(6);
        assertEquals(6, freqStack.pop());
        freqStack.push(1);
        assertEquals(1, freqStack.pop());
        freqStack.push(1);
        assertEquals(1, freqStack.pop());
        freqStack.push(4);
        assertEquals(4, freqStack.pop());
        assertEquals(2, freqStack.pop());
        assertEquals(3, freqStack.pop());
        assertEquals(9, freqStack.pop());
        assertEquals(0, freqStack.pop());
        assertEquals(4, freqStack.pop());
    }
}
