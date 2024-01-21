package customer;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/doUpdate_cus")
public class DoUpdate extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String Name = req.getParameter("name");
        String Pincode = req.getParameter("password");
        try {
            PreparedStatement ps = login.conn
                    .prepareStatement("update account set name = ?, pincode = ? where account_number = ?");
            ps.setString(1, Name);
            ps.setString(2, Pincode);
            ps.setLong(3, login.acc);
            if (ps.executeUpdate() == 1) {
                req.setAttribute("acc", login.acc);
                req.getRequestDispatcher("/updated.jsp").forward(req, res);
            } else {
                res.getWriter().println("<script type=\"text/javascript\">"
                        + "alert('No Account found');"
                        + "</script>");
                req.getRequestDispatcher("/cus_login").include(req, res);
            }
        } catch (Exception e) {
            res.getWriter().println("<script type=\"text/javascript\">"
                    + "alert(\"" + e.getMessage() + "\");"
                    + "</script>");
        }
    }

}
