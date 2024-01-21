package customer;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/statement")
public class Statement extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            PreparedStatement ps = login.conn.prepareStatement("select * from statement where account_number = ?;");
            ps.setLong(1, login.acc);
            ResultSet rs = ps.executeQuery();
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                data.add(new Object[] {
                        rs.getObject(1),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                });
            }
            req.setAttribute("data", data);
            req.getRequestDispatcher("/statement.jsp").forward(req, res);
        } catch (SQLException e) {
            res.getWriter().println("<script type=\"text/javascript\">"
                    + "alert(\"" + e.getMessage() + "\");"
                    + "</script>");
        }
    }

}
