package wolfish.scrabble;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DictionaryTest {

    @Test
    public void realWord() throws IOException {
        //given
        DictionaryService service = new DictionaryService();
        Dictionary dict = service.dictionary();

        //then
        Assert.assertTrue(dict.determineIfWordIsValid("aa"));
    }

    @Test
    public void fakeWord() throws IOException {
        //given
        DictionaryService service = new DictionaryService();
        Dictionary dict = service.dictionary();

        //then
        Assert.assertFalse(dict.determineIfWordIsValid("jkljk"));
    }

    @Test
    public void definitionRealWord() throws IOException {
        //given
        DictionaryService service = new DictionaryService();
        Dictionary dict = service.dictionary();

        //when
        String definition = dict.getDefinition("happy");

        //then
        Assert.assertEquals("marked by joy [adj -PIER, -PIEST] : HAPPILY [adv]", definition);

    }

    @Test
    public void definitionFakeWord() throws IOException {
        //given
        DictionaryService service = new DictionaryService();
        Dictionary dict = service.dictionary();

        //when
        String definition = dict.getDefinition("kljdsf");

        //then
        Assert.assertEquals("", definition);

    }
}
