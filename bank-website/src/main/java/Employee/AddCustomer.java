package Employee;
import java.io.IOException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addCus")
public class AddCustomer extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            add(req);
            res.getWriter().println("<script type=\"text/javascript\">"
                    + "alert('New Customer added');"
                    + "</script>");
        } catch (Exception e) {
            res.getWriter().println("<script type=\"text/javascript\">"
                    + "alert(\"" + e.getMessage() + "\");"
                    + "</script>");
        } finally {
            req.getRequestDispatcher("/new").include(req, res);
        }
    }

    public boolean add(ServletRequest req) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
        PreparedStatement ps = conn.prepareStatement("Insert into account values(?,?,?,?,?)");
        ps.setString(1, req.getParameter("name"));
        ps.setLong(2, Long.parseLong(req.getParameter("acNum")));
        ps.setString(3, req.getParameter("pin"));
        ps.setDouble(4, Double.parseDouble(req.getParameter("balance")));
        ps.setBoolean(5, Boolean.parseBoolean(req.getParameter("status")));
        if (ps.executeUpdate() != 0) {
            return true;
        } else {
            return false;
        }
    }
}