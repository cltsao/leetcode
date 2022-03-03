import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamCheckerTest {
    @Test
    public void testExample1() {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        assertFalse(streamChecker.query('a')); // return False
        assertFalse(streamChecker.query('b')); // return False
        assertFalse(streamChecker.query('c')); // return False
        assertTrue(streamChecker.query('d')); // return True, because 'cd' is in the wordlist
        assertFalse(streamChecker.query('e')); // return False
        assertTrue(streamChecker.query('f')); // return True, because 'f' is in the wordlist
        assertFalse(streamChecker.query('g')); // return False
        assertFalse(streamChecker.query('h')); // return False
        assertFalse(streamChecker.query('i')); // return False
        assertFalse(streamChecker.query('j')); // return False
        assertFalse(streamChecker.query('k')); // return False
        assertTrue(streamChecker.query('l')); // return True, because 'kl' is in the wordlist
    }

    @Test
    public void testExample2() {
        StreamChecker streamChecker = new StreamChecker(new String[]{"aaaaaaaaaaaaaaab", "aaaaaaab", "ab"});
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
        assertTrue(streamChecker.query('b'));
        assertFalse(streamChecker.query('a'));
        assertTrue(streamChecker.query('b'));
    }
}
