import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
public class Servlet extends HttpServlet {
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char symbol = '+';

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            num1 = Double.parseDouble(req.getParameter("num1"));
            num2 = Double.parseDouble(req.getParameter("num2"));
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

        req.setAttribute("a", num1);
        req.setAttribute("symb", symbol);
        req.setAttribute("b", num2);
        req.setAttribute("result", result);
        RequestDispatcher rd = req.getRequestDispatcher("Result.jsp");
        rd.forward(req, resp);
    }
}
