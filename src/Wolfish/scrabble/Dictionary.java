package Wolfish.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/*
This is a tool to determine if a word tried in scrabble is a valid word
 */
public class Dictionary {

    private final ArrayList<String> words = new ArrayList<>();

    /*
    The constructor opens a file containing valid words and creates an ArrayList of the words
     */
    public Dictionary(String filename) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File(filename));

        while (inputFile.hasNext()) {
            String text = inputFile.nextLine();
            int endOfWord = text.indexOf(" ");
            if (endOfWord != -1) {
                words.add(text.substring(0, endOfWord).toUpperCase());
            } else {
                words.add(text.toUpperCase());
            }

        }

    }

    /*
    This method takes a String and determines if it is a word
     */
    public boolean determineIfWordIsValid(String word) {
        String[] wordsArray = words.toArray(new String[0]);
        Arrays.sort(wordsArray);
        return Arrays.binarySearch(wordsArray, word.toUpperCase()) >= 0;
    }



}
