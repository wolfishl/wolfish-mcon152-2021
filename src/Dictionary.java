import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/*
This is a tool to determine if a word tried in scrabble is a valid word
 */
public class Dictionary {

    private ArrayList<String> words = new ArrayList<>();

    /*
    The constructor opens a file containing valid words and creates an ArrayList of the words
     */
    public Dictionary(String filename)
    {
        try (Scanner inputFile = new Scanner(new File(filename)))
        {
            while(inputFile.hasNext())
            {
                String text = inputFile.nextLine();
                int endOfWord = text.indexOf(" ");
                if (endOfWord != -1)
                {
                    words.add(text.substring(0, endOfWord));
                }
                else
                {
                    words.add(text);
                }
            }
        }
        catch(IOException error){
            System.out.println("Last word was " + words.get(words.size() - 1));
            System.out.println("The filename provided was not valid");
        }
    }

    /*
    This method takes a String and determines if it is a word
     */
    public boolean determineIfWordIsValid(String word)
    {
        boolean isValid = false;
        for (String validWord : words)
        {
            if (word.equalsIgnoreCase(validWord))
            {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

}
