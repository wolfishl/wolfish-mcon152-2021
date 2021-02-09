package Wolfish.scrabble;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {

    @Test
    public void realWord()
    {
        //given
        Dictionary dict = new Dictionary("dictionary.txt");

        //then
        Assert.assertTrue(dict.determineIfWordIsValid("aa"));
    }

    @Test
    public void fakeWord()
    {
        //given
        Dictionary dict = new Dictionary("dictionary.txt");

        //then
        Assert.assertFalse(dict.determineIfWordIsValid("jkljk"));
    }
}
