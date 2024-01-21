package customer;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/check")
public class CheckBalance extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            PreparedStatement ps = login.conn.prepareStatement("select balance from account where account_number = ?");
            ps.setLong(1, login.acc);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int amount = rs.getInt(1);
            res.getWriter().println("<script type=\"text/javascript\">"
                    + "alert(\" Your Balance is : " + amount + "\");"
                    + "</script>");
            req.getRequestDispatcher("cus_login").include(req, res);
        } catch (SQLException e) {
            res.getWriter().println("<script type=\"text/javascript\">"
                    + "alert(\"" + e.getMessage() + "\");"
                    + "</script>");
        }
    }

}
