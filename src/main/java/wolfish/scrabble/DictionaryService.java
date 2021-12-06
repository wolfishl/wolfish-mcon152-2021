package wolfish.scrabble;

import java.io.*;

public class DictionaryService {

    public Dictionary dictionary() throws IOException {


        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        Dictionary dict = new Dictionary(reader);

        return  dict;
    }





}
