import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class ServletExt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String firstParam= req.getParameter("fN");
        String nextParam= req.getParameter("lN");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer=resp.getWriter();
        writer.write("<p<span style='color: blue; '>Hello"+firstParam+" "+nextParam+"!</span></p>");
    }
}
