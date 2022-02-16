import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSystemTest {
    @Test
    public void testExample1() {
        FileSystem fileSystem = new FileSystem();
        assertThat(fileSystem.ls("/")).containsExactly();                         // return []
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        assertThat(fileSystem.ls("/")).containsExactly("a");                         // return ["a"]
        assertEquals("hello", fileSystem.readContentFromFile("/a/b/c/d")); // return "hello"
    }
}
