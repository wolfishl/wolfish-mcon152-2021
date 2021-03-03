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

    @Test
    public void definitionRealWord() throws FileNotFoundException{
        //given
        Dictionary dict = new Dictionary("dictionary.txt");

        //when
        String definition = dict.getDefinition("happy");

        //then
        Assert.assertEquals("marked by joy [adj -PIER, -PIEST] : HAPPILY [adv]", definition);

    }

    @Test
    public void definitionFakeWord() throws FileNotFoundException{
        //given
        Dictionary dict = new Dictionary("dictionary.txt");

        //when
        String definition = dict.getDefinition("kljdsf");

        //then
        Assert.assertEquals("", definition);

    }
}
