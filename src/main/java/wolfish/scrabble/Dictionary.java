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
    The constructor opens a file containing valid words and creates a map of the words and their definitions.
     */
    public Dictionary(String filename) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File(filename));

        while (inputFile.hasNext()) {
            wordsToDefinition.put(inputFile.next(), inputFile.nextLine().trim());
        }

    }

    /*
    This method takes a String and determines if it is a word.
     */
    public boolean determineIfWordIsValid(String word) {
        return wordsToDefinition.containsKey(word.toUpperCase());
    }


    /*
    This method takes a String and returns its definition if it is a valid word.
    If it is not valid, it returns an empty String.
     */
    public String getDefinition(String word)
    {
        String definition = wordsToDefinition.get(word.toUpperCase());
        return definition == null? "" : definition;
    }



}
