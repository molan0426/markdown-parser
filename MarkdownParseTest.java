import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test_test_file() throws IOException{
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("https://something.com");
        arr.add("some-thing.html");


        Path filePath = Path.of("./test-file.md");

        String content = Files.readString(filePath);

        assertEquals(arr, MarkdownParse.getLinks(content));
    }

}
