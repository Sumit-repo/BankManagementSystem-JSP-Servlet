package bank;

import java.sql.*;
import java.time.LocalTime;
import java.util.*;

public class Bank {
    public Connection conn;
    Scanner sc = new Scanner(System.in);

    Bank() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
    }

    boolean verifyUser() throws SQLException {
        System.out.print("Enter Email Id : ");
        ResultSet rs = conn.createStatement().executeQuery("select * from admin where email = '" + sc.next() + "'");
        if (rs.next()) {
            System.out.print("Enter Password : ");
            if (rs.getString(4).equals(sc.next())) {
                int hour = LocalTime.now().getHour();
                if (hour > 6 && hour <= 12)
                    System.out.println("Goodmoring " + rs.getString(2));
                else if (hour > 12 && hour < 5)
                    System.out.println("Good Afternoon " + rs.getString(2));
                else
                    System.out.println("Good Evening " + rs.getString(2));
                return true;
            } else {
                System.out.println("Wrong Password");
                return false;
            }
        } else {
            System.out.println("No user found");
            return false;
        }
    }

    void addCustomer() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into account values(?,?,?,?,?,?);");
        System.out.print("Enter Customer new  Id : ");
        ps.setInt(1, sc.nextInt());
        System.out.print("Enter Name : ");
        ps.setString(2, sc.next());
        System.out.print("Enter Account Number : ");
        ps.setLong(3, sc.nextLong());
        System.out.print("Enter pincode : ");
        ps.setString(4, sc.next());
        System.out.print("Enter Balance : ");
        ps.setDouble(5, sc.nextDouble());
        System.out.print("Enter Status(true/false) : ");
        ps.setBoolean(6, sc.nextBoolean());
        ps.execute();
        System.out.println("Customer Added!!!");
    }

    boolean viewCustomer(long accoutNumber) throws SQLException {
        ResultSet rs = conn.createStatement()
                .executeQuery("select * from account where account_number = " + accoutNumber + ";");
        if (rs.next()) {
            if (rs.getBoolean(6) == true)
                System.out.println("Id : " + rs.getInt(1)
                        + "\nName : " + rs.getString(2)
                        + "\nAccount Number : " + rs.getLong(3)
                        + "\nPincode : " + rs.getString(4)
                        + "\nBalance : " + rs.getDouble(5)
                        + "\nStatus : " + "Active");
            else
                System.out.println("Id : " + rs.getInt(1)
                        + "\nName : " + rs.getString(2)
                        + "\nAccount Number : " + rs.getLong(3)
                        + "\nPincode : " + rs.getString(4)
                        + "\nBalance : " + rs.getDouble(5)
                        + "\nStatus : " + "Inactive");
            return true;
        } else {
            System.out.println("No account found...");
        }
        return false;
    }

    void blockCustomer(long accoutNumber) throws SQLException {
        conn.createStatement()
                .executeUpdate("update account set status = " + 0 + " where account_number = " + accoutNumber + ";");
        System.out.println("Acoount " + accoutNumber + " blocked!");
    }

    void unblockCustomer(long accoutNumber) throws SQLException {
        conn.createStatement()
                .executeUpdate("update account set status = " + 1 + " where account_number = " + accoutNumber + ";");
        System.out.println("Acoount " + accoutNumber + " unblocked!");
    }

    void updateCustomer(long accoutNumber) throws SQLException {
        if (viewCustomer(accoutNumber)) {
            System.out.print("What you want to update\n1. Name\n2. pincode\n3. balance\n");
            switch (sc.nextInt()) {
                case 1: {
                    PreparedStatement ps = conn
                            .prepareStatement("update account set name = ? where account_number = ?;");
                    System.out.print("Enter Name ");
                    ps.setString(1, sc.next());
                    ps.setLong(2, accoutNumber);
                    ps.execute();
                    System.out.println("Name updated!");
                    break;
                }
                case 2: {
                    PreparedStatement ps = conn
                            .prepareStatement("update account set pincode = ? where account_number = ?;");
                    System.out.print("Enter new pincode ");
                    ps.setString(1, sc.next());
                    ps.setLong(2, accoutNumber);
                    ps.execute();
                    System.out.println("Pincode updated!");
                    break;
                }
                case 3: {
                    PreparedStatement ps = conn
                            .prepareStatement("update account set balance = ? where account_number = ?;");
                    System.out.print("Enter new balance : ");
                    ps.setInt(1, sc.nextInt());
                    ps.setLong(2, accoutNumber);
                    ps.execute();
                    System.out.println("Balance updated!");
                    break;
                }
                default:
                    break;
            }
        }
    }

    void deleteCustomer(long accoutNumber) throws SQLException {
        conn.createStatement()
                .executeQuery("delete from account where account_number = " + accoutNumber + ";");
        System.out.println("Acoount " + accoutNumber + " deleted!");
    }

}
