package wolfish.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/*
This is a tool to determine if a word tried in scrabble is a valid word
 */
public class Dictionary {

    private final Map<String, String> wordsToDefinition = new HashMap<>();

    /*
    The constructor opens a file containing valid words and creates an ArrayList of the words
     */
    public Dictionary(String filename) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File(filename));

        while (inputFile.hasNext()) {
            wordsToDefinition.put(inputFile.next(), inputFile.nextLine().trim());

        }

    }

    /*
    This method takes a String and determines if it is a word
     */
    public boolean determineIfWordIsValid(String word) {
        return wordsToDefinition.containsKey(word.toUpperCase());
    }

    public String getDefinition(String word)
    {
        String definition = wordsToDefinition.get(word.toUpperCase());
        return definition == null? "" : definition;
    }



}
