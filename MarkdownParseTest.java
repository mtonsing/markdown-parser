import static org.junit.Assert.*;
import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void getLinks() {\
        //first entry will be what we want them to print
        //second entry call the getLinks()
        assertEquals(List.of("https://something.com","some-thing.html"),getLinks((test-file.md).readtostring));
    }
}
