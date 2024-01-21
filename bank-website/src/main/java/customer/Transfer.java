package customer;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/transfer")
public class Transfer extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        long fromAcc = Long.parseLong(req.getParameter("firstAcc"));
        long toAcc = Long.parseLong(req.getParameter("SecondACC"));
        String pin = req.getParameter("pin");
        Double amount = Double.parseDouble(req.getParameter("amount"));
        if (fromAcc != toAcc) {
            if (fromAcc == login.acc) {
                try {
                    PreparedStatement ps = login.conn
                            .prepareStatement("select * from account where account_number = ?;");
                    ps.setLong(1, fromAcc);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        if (rs.getString(3).equals(pin)) {
                            if (rs.getBoolean(5) == true) {
                                double sender_balance = rs.getDouble(4);
                                if (amount <= sender_balance) {
                                    PreparedStatement ps1 = login.conn
                                            .prepareStatement("select * from account where account_number = ?");
                                    ps1.setLong(1, toAcc);
                                    ResultSet rs1 = ps1.executeQuery();
                                    if (rs1.next()) {
                                        if (rs1.getBoolean(5) == true) {
                                            double reciver_balance = rs1.getDouble(4);
                                            PreparedStatement update = login.conn.prepareStatement(
                                                    "update account set balance = ? where account_number = ?;");
                                            update.setDouble(1, reciver_balance + amount);
                                            update.setLong(2, toAcc);
                                            update.addBatch();
                                            update.setDouble(1, sender_balance - amount);
                                            update.setDouble(2, fromAcc);
                                            update.addBatch();
                                            update.executeBatch();

                                            PreparedStatement statement = login.conn
                                                    .prepareStatement("Insert into statement values (?,?,?,?,?,?)");
                                            statement.setObject(1, new java.sql.Timestamp(System.currentTimeMillis()));
                                            statement.setLong(2, fromAcc);
                                            statement.setString(3, amount + " transfered to " + toAcc);
                                            statement.setDouble(4, amount);
                                            statement.setString(5, null);
                                            statement.setDouble(6, sender_balance - amount);
                                            statement.addBatch();
                                            statement.setObject(1, new java.sql.Timestamp(System.currentTimeMillis()));
                                            statement.setLong(2, toAcc);
                                            statement.setString(3, amount + " recieved from " + fromAcc);
                                            statement.setString(4, null);
                                            statement.setDouble(5, amount);
                                            statement.setDouble(6, reciver_balance + amount);
                                            statement.addBatch();
                                            statement.executeBatch();

                                            req.setAttribute("success",
                                                    "Transaction successful!!! Amount transfered...");
                                            req.getRequestDispatcher("/cus_login").forward(req, res);
                                        } else {
                                            req.setAttribute("alert",
                                                    "Reciver account is blocked, these operations cant be performed");
                                            req.getRequestDispatcher("/cus_login").forward(req, res);
                                        }
                                    } else {
                                        req.setAttribute("alert",
                                                "Reciver Account not found/deleted, please login again.");
                                        req.getRequestDispatcher("/cus_login").forward(req, res);
                                    }
                                } else {
                                    req.setAttribute("alert", "Insufficient Balance");
                                    req.getRequestDispatcher("/cus_login").forward(req, res);
                                }
                            } else {
                                req.setAttribute("alert",
                                        "Your account is blocked, these operations cant be performed");
                                req.getRequestDispatcher("/cus_login").forward(req, res);
                            }
                        } else {
                            req.setAttribute("alert", "Incorrect pin, recheck your pin");
                            req.getRequestDispatcher("/cus_login").forward(req, res);
                        }
                    } else {
                        req.setAttribute("alert", "Sender Account not found/deleted, please login again.");
                        req.getRequestDispatcher("/cus_login").forward(req, res);
                    }
                } catch (Exception e) {
                    res.getWriter().println("<script type=\"text/javascript\">"
                            + "alert(\"" + e.getMessage() + "\");"
                            + "</script>");
                    req.getRequestDispatcher("/cus_login").include(req, res);
                }
            } else {
                req.setAttribute("alert", "Sender Account Number mismatch, please login again.");
                req.getRequestDispatcher("/cus_login").forward(req, res);
            }
        } else {
            req.setAttribute("alert", "Sender and Reciver account number cannot not be same.");
            req.getRequestDispatcher("/cus_login").forward(req, res);
        }
    }

}
