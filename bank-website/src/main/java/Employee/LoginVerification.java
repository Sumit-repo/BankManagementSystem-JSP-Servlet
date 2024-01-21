package Employee;
import java.io.IOException;
import java.sql.*;
import java.time.LocalTime;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginVerification extends GenericServlet {
    public static Connection conn;
    RequestDispatcher rD;
    public static String name = "";
    public static String salute = "";

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            ResultSet rs = conn.createStatement().executeQuery("select * from admin where email = '" + email + "'");
            if (rs.next()) {
                if (rs.getString(4).equals(password)) {
                    int hour = LocalTime.now().getHour();
                    name = rs.getString(2);
                    if (hour > 6 && hour < 12)
                        salute = "Good Morning, ";
                    else if (hour >= 12 && hour < 17)
                        salute = "Good Afternoon, ";
                    else
                        salute = "Good Evening, ";
                    req.getRequestDispatcher("/new").forward(req, res);
                } else {
                    req.setAttribute("message", "Wrong password, please double check your password.");
                    req.getRequestDispatcher("/index.jsp").forward(req, res);
                }
            } else {
                req.setAttribute("message", "No user found for provided email-id, please try again");
                req.getRequestDispatcher("index.jsp").forward(req, res);
            }
        } catch (Exception e) {
            res.getWriter().println("<script type=\"text/javascript\">"
                    + "alert(\"" + e.getMessage() + "\");"
                    + "</script>");
        }
    }
}