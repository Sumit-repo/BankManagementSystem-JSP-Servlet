package customer;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cus_login")
public class Cus_new extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setAttribute("name", login.name);
        req.setAttribute("message", login.salute);
        req.setAttribute("acc", login.acc);
        req.getRequestDispatcher("customer_homepage.jsp").include(req, res);
    }
}
