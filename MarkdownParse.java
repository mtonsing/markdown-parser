//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        //start at index 0
        int currentIndex = 0;
        //makesure index doesn't go out of bound
        //if markdown doesn't contain any brackets 
        //will conduct a while loop to find just parenthesis.
        while(currentIndex < markdown.length()) {
            //get the index of first openBracket
            int openBracket = markdown.indexOf("[", currentIndex);
            //get the index of last openbracket and start 
            //to find another openbracket
            int closeBracket = markdown.indexOf("]", openBracket);
            //look for the index of an open parenthesis and then start
            //looking for a closebracket
            int openParen = markdown.indexOf("(", closeBracket);
            //look for closeparen and start looking for openParen
            int closeParen = markdown.indexOf(")", openParen);
            //add markdown string starting from openParen to closeParen
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            //change currentIndex to start at closeParen
            currentIndex = closeParen + 1;
            
            
            
            
            
        }
        //return what is inside in the parenthesis
        return toReturn;
        
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
