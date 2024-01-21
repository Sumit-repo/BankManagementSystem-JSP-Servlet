package customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login-customer")
public class login extends GenericServlet {
    public static String name = "";
    public static String salute = "";
    public static long acc;
    public static Connection conn;


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        acc = Long.parseLong(req.getParameter("acc"));
        String pincode = req.getParameter("pincode");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            PreparedStatement ps = conn.prepareStatement("select * from account where account_number = ?;");
            ps.setLong(1, acc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString(3).equals(pincode)) {
                    int hour = LocalTime.now().getHour();
                    name = rs.getString(1);
                    if (hour > 6 && hour < 12)
                        salute = "Good Morning, ";
                    else if (hour >= 12 && hour < 17)
                        salute = "Good Afternoon, ";
                    else
                        salute = "Good Evening, ";
                    req.getRequestDispatcher("/cus_login").forward(req, res);
                } else {
                    req.setAttribute("message", "Wrong password, please double check your pin.");
                    req.getRequestDispatcher("/customer_login.jsp").forward(req, res);
                }
            } else {
                req.setAttribute("message", "No user found for provided email-id, please try again");
                req.getRequestDispatcher("Customer_login.jsp").forward(req, res);
            }
        } catch (Exception e) {
            res.getWriter().println("<script type=\"text/javascript\">alert(\"" + e.getMessage() + "\");</script>");
        }
    }
}
