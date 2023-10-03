import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="HelloWorld", urlPatterns = {"/hello", "/world"})
public class HelloWorld extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Olá Mundo</h1>");
        out.close();
    }

}
