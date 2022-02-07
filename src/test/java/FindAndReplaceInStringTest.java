import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindAndReplaceInStringTest {
    FindAndReplaceInString farist = new FindAndReplaceInString();

    @Test
    public void testExample1() {
        Assertions.assertEquals("eeebffff", farist.findReplaceString("abcd", new int[] {0, 2}, new String[] {"a", "cd"}, new String[] {"eee", "ffff"}));
    }

    @Test
    public void testExample2() {
        Assertions.assertEquals("eeecd", farist.findReplaceString("abcd", new int[] {0, 2}, new String[] {"ab","ec"}, new String[] {"eee", "ffff"}));
    }
}
