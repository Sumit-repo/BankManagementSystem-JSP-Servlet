package Employee;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/view")
public class View extends GenericServlet {

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
                Double Balance = rs.getDouble(4);
                String Status = rs.getBoolean(5) == true ? "Active" : "Blocked";
                String color = rs.getBoolean(5) == false ? "rgb(245, 27, 27);" : "rgb(8, 117, 8);";
                req.setAttribute("acc", AccountNumber);
                req.setAttribute("name", Name);
                req.setAttribute("pin", Pincode);
                req.setAttribute("bal", Balance);
                req.setAttribute("status", Status);
                req.setAttribute("color", color);
                req.getRequestDispatcher("/view.jsp").forward(req, res);
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
