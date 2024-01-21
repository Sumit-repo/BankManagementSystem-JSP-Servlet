package Employee;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/viewAll")
public class ViewAll extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            ResultSet rs = LoginVerification.conn.prepareStatement("select * from account;").executeQuery();
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                data.add(new Object[] {
                        rs.getString(1),
                        rs.getLong(2),
                        rs.getDouble(4),
                        rs.getBoolean(5) == true ? "Active" : "Blocked"
                });
            }
            req.setAttribute("data", data);
            req.getRequestDispatcher("/viewAll.jsp").forward(req, res);
        } catch (SQLException e) {
            res.getWriter().println("<script type=\"text/javascript\">"
                    + "alert(\"" + e.getMessage() + "\");"
                    + "</script>");
        }
    }

}
