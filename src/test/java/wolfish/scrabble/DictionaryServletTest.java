package wolfish.scrabble;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class DictionaryServletTest{

    @Test
    public void doGetRealWord() throws IOException {

        // given
        DictionaryServlet servlet = new DictionaryServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        doReturn(out).when(response).getWriter();
        doReturn("great").when(request).getParameter("word");

        // when
        servlet.doGet(request, response);

        // then
        verify(out).println("{large=adj} [adj GREATER, GREATEST] / a distinguished or outstanding person [n -S]");
    }

    @Test
    public void doGetFakeWord() throws IOException {

        // given
        DictionaryServlet servlet = new DictionaryServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        doReturn(out).when(response).getWriter();
        doReturn("kasldfjlak").when(request).getParameter("word");

        // when
        servlet.doGet(request, response);

        // then
        verify(out).println("Word not found");
    }

}