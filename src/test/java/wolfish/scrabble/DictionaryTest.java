package wolfish.scrabble;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class DictionaryTest {

    @Test
    public void realWord() throws FileNotFoundException {
        //given
        Dictionary dict = new Dictionary("dictionary.txt");

        //then
        Assert.assertTrue(dict.determineIfWordIsValid("aa"));
    }

    @Test
    public void fakeWord() throws FileNotFoundException {
        //given
        Dictionary dict = new Dictionary("dictionary.txt");

        //then
        Assert.assertFalse(dict.determineIfWordIsValid("jkljk"));
    }
}
