import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
public class Servlet extends HttpServlet {
    int num1 = 0;
    int num2 = 0;
    int result = 0;
    char symbol = '+';

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            num1 = Integer.parseInt(req.getParameter("num1"));
            num2 = Integer.parseInt(req.getParameter("num2"));
            symbol = req.getParameter("symb").charAt(0);

            switch (symbol) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
                    break;
            }

        } catch (NumberFormatException e) {
            resp.getWriter().println("Numbers not entered!");
        }

        req.setAttribute("result", result);
        RequestDispatcher rd = req.getRequestDispatcher("Result.jsp");
        rd.forward(req, resp);
    }
}
