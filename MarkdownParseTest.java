// javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
// java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

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

    @Test
    public void test_test_file9() throws IOException{
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("https://abc.com");
        Path filePath = Path.of("./test-file9.md");

        String content = Files.readString(filePath);

        assertEquals(arr, MarkdownParse.getLinks(content));

    }
    

}
