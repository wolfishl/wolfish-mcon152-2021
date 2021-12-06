package wolfish.scrabble;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.stream.Collectors;

public class DictionaryService {

    public Dictionary dictionary() throws IOException {


        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        Dictionary dict = new Dictionary(reader);

        return  dict;
    }





}
