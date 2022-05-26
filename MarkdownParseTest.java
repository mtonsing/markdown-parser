import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
public class MarkdownParseTest extends MarkdownParse {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void subtraction() {
       assertEquals(3,5-2);
    }
    @Test 
    public void testFile5() throws IOException{
        List<String> testFileLinks = List.of( "google.com",
        "`google.com","ucsd.edu");
        Path testFile = Path.of("test-file1.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks,MarkdownParse.getLinks(testFileContent));    
    }
    @Test 
    public void testFile6() throws IOException{
        List<String> testFileLinks = List.of("a.com",
        "a.com(())","example.com");
        Path testFile = Path.of("test-file2.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks,MarkdownParse.getLinks(testFileContent));    
    }
    @Test 
    public void testFile7() throws IOException{
        List<String> testFileLinks = List.of( 
        "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        Path testFile = Path.of("test-file3.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks,MarkdownParse.getLinks(testFileContent));    
    }
} 
