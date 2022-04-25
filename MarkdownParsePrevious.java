import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParsePrevious {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int i = 0;
            while (currentIndex < markdown.length()) {
                int excalmatory = markdown.indexOf("!", currentIndex);
                    int openBracket = markdown.indexOf("[", currentIndex);
                    int closeBracket = markdown.indexOf("]", openBracket);
                    int openParen = markdown.indexOf("(", closeBracket);
                    int closeParen = markdown.indexOf(")", openParen);
                    if(!toReturn.contains(markdown.substring(openParen + 1, closeParen)) && (excalmatory +1 != openBracket)){
                        // System.out.println("start: " + (openParen) + "end: " + (closeParen+1) + ". substring is " + markdown.substring(openParen + 1, closeParen));
                        // System.out.println("start: " + markdown.substring(openParen, openParen + 1) + "end: " + markdown.substring(closeParen, closeParen+1) + ". substring is " + markdown.substring(openParen + 1, closeParen));

                        toReturn.add(markdown.substring(openParen + 1, closeParen));
                    }


                    currentIndex = closeParen + 1;
                i ++;
                if(i == markdown.length()-1) break;
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
