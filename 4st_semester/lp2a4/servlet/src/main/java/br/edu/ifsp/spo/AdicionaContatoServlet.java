package br.edu.ifsp.spo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.util.Date;

public class AdicionaContatoServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;

        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            out.println("Erro de conversão da data");
            return;
        }

        out.println("<html>");
        out.println("<body>");
        out.println("Contato: " + nome + " adicionado com sucesso");
        out.println("Contato=" + nome + " Endereco=" + endereco + " Email=" + email + " DataDeNascimento=" + dataEmTexto);
        out.println("</body>");
        out.println("</html>");

    }
}
