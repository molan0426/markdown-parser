//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
// https://www.geeksforgeeks.org/arraylist-contains-java/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {

        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int i = 0;
        if(markdown.contains("[") && markdown.contains("(")){
            while (currentIndex < markdown.length()) {
                // -1 because sometimes openBracket is 0
                int excalmatory = markdown.indexOf("!", currentIndex) - 1;
                    int openBracket = markdown.indexOf("[", currentIndex);
                    int closeBracket = markdown.indexOf("]", openBracket);
                    int openParen = markdown.indexOf("(", closeBracket);
                    int closeParen = markdown.indexOf(")", openParen);
                    // String contentBetweenBracket = markdown.substring(openBracket + 1, closeBracket);
                    if(!toReturn.contains(markdown.substring(openParen + 1, closeParen)) && (excalmatory +1 != openBracket)  ){
                        // System.out.println("closeBracket " + closeBracket + "; openParen " + openParen + ". website:" + markdown.substring(openParen + 1, closeParen));
                        toReturn.add(markdown.substring(openParen + 1, closeParen));
                        //&& (closeBracket +1 ==openParen) 
                        //(closeBracket +1 ==openParen) && !contentBetweenBracket.contains("\n")
		    }

                    currentIndex = closeParen + 1;
                i ++;
                if(i == markdown.length()-1) break;
            }

	}

        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println("");
        System.out.println(links);
    }
    
}
