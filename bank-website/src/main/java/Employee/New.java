package Employee;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/new")
public class New extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setAttribute("message", LoginVerification.salute);
        req.setAttribute("name", LoginVerification.name);
        req.getRequestDispatcher("/home.jsp").include(req, res);
    }
}
