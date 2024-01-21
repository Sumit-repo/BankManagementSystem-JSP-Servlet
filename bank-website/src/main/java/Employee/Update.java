package Employee;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/update")
public class Update extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Long AccountNumber = Long.parseLong(req.getParameter("acc"));
        try {
            PreparedStatement ps = LoginVerification.conn.prepareStatement("select * from account where account_number = ?");
            ps.setLong(1, AccountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String Name = rs.getString(1);
                String Pincode = rs.getString(3);
                req.setAttribute("acc", AccountNumber);
                req.setAttribute("name", Name);
                req.setAttribute("pincode", Pincode);
                req.getRequestDispatcher("update.jsp").forward(req, res);
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
