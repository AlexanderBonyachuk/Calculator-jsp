import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class Servlet extends HttpServlet {
    int num1 = 0;
    int num2 = 0;
    int result = 0;

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            num1 = Integer.parseInt(req.getParameter("num1"));
            num2 = Integer.parseInt(req.getParameter("num2"));

        result = num1 + num2;
        } catch (NumberFormatException e) {
            resp.getWriter().println("Numbers not entered!");
        }

        PrintWriter out = resp.getWriter();
        out.println("Result is : " + result);
    }
}
