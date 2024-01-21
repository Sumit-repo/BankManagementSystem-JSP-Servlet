package Employee;
import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/unblock")
public class Unblock extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Long AccountNumber = Long.parseLong(req.getParameter("acc"));
        try {
            PreparedStatement ps = LoginVerification.conn.prepareStatement("update account set status = 1 where account_number = ?");
            ps.setLong(1, AccountNumber);
            if (ps.executeUpdate() == 1) {
                req.setAttribute("acc", AccountNumber);
                req.setAttribute("status", "Active");
                req.getRequestDispatcher("/status.jsp").forward(req, res);;
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