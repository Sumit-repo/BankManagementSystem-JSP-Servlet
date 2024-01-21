package Employee;
import java.io.IOException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/delete")
public class Delete extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Long AccountNumber = Long.parseLong(req.getParameter("acc"));
        try {
            PreparedStatement ps = LoginVerification.conn.prepareStatement("delete from account where account_number = ?");
            ps.setLong(1, AccountNumber);
            if (ps.executeUpdate() == 1) {
                req.setAttribute("acc", AccountNumber);
                req.getRequestDispatcher("/delete.jsp").forward(req, res);
            } else {
                res.getWriter().println("<script type=\"text/javascript\">"
                        + "alert('No Account found');"
                        + "</script>");
                req.getRequestDispatcher("/new").include(req, res);
            }
        } catch (Exception e) {
            res.getWriter().println("<script type=\"text/javascript\">"
                    + "alert(\"" + e.getMessage() + "\");"
                    + "</script>");
        }
    }
}
