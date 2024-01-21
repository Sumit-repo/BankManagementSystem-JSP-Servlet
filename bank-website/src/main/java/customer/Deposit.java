package customer;

import java.io.IOException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/deposit")
public class Deposit extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        double amount = Double.parseDouble(req.getParameter("amount"));
        String pin = req.getParameter("pin");
        try {
            PreparedStatement verify = login.conn.prepareStatement("select * from account where account_number = ?;");
            verify.setLong(1, login.acc);
            ResultSet rs = verify.executeQuery();
            if (rs.next())
                if (rs.getBoolean(5) == true)
                    if (pin.equals(rs.getString(3))) {
                        PreparedStatement ps = login.conn
                                .prepareStatement("update account set balance = balance + ? where account_number = ?;");
                        ps.setDouble(1, amount);
                        ps.setLong(2, login.acc);
                        ps.executeUpdate();
                        PreparedStatement statement = login.conn
                                .prepareStatement("insert into statement values (?,?,?,?,?,?);");
                        statement.setObject(1, new java.sql.Timestamp(System.currentTimeMillis()));
                        statement.setLong(2, login.acc);
                        statement.setString(3, amount + " deposited");
                        statement.setString(4, null);
                        statement.setDouble(5, amount);
                        statement.setDouble(6, rs.getDouble(4) + amount);
                        statement.executeUpdate();
                        res.getWriter().println("<script type=\"text/javascript\">"
                                + "alert(\" Balance updated, Money deposited succesfully...\");"
                                + "</script>");
                        req.getRequestDispatcher("deposit.jsp").include(req, res);
                    } else {
                        res.getWriter().println("<script type=\"text/javascript\">"
                                + "alert(\"Incorrect Pin...\");"
                                + "</script>");
                        req.getRequestDispatcher("deposit.jsp").include(req, res);
                    }
                else {
                    res.getWriter().println("<script type=\"text/javascript\">"
                            + "alert(\"Account is blocked cannot perform these operations... \");"
                            + "</script>");
                    req.getRequestDispatcher("deposit.jsp").include(req, res);
                }
            else {
                res.getWriter().println("<script type=\"text/javascript\">"
                        + "alert(\"Account deleted/Not present!!!\");"
                        + "</script>");
                req.getRequestDispatcher("deposit.jsp").include(req, res);
            }
        } catch (SQLException e) {
            res.getWriter().println("<script type=\"text/javascript\">"
                    + "alert(\"" + e.getMessage() + "\");"
                    + "</script>");
        }
    }
}
