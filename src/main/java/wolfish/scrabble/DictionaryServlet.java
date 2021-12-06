package wolfish.scrabble;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DictionaryServlet extends HttpServlet {


    private final Dictionary dict;
    private final DictionaryService service;

    public DictionaryServlet() throws IOException {

        service = new DictionaryService();
        dict = service.dictionary();
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        PrintWriter out = response.getWriter();

        String word = request.getParameter("word");

        String definition = dict.determineIfWordIsValid(word) ? dict.getDefinition(word) : "Word not found";

        out.println(definition);

    }

}
