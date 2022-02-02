import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerToEnglishWordsTest {
    IntegerToEnglishWords itew = new IntegerToEnglishWords();

    @Test
    public void testExample1() {
        assertEquals("One Hundred Twenty Three", itew.numberToWords(123));
    }

    @Test
    public void testExample2() {
        assertEquals("Twelve Thousand Three Hundred Forty Five", itew.numberToWords(12345));
    }

    @Test
    public void testExample3() {
        assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", itew.numberToWords(1234567));
    }
}
