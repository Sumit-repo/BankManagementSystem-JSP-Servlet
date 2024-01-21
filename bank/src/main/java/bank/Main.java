package bank;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Bank newBank = new Bank();
        if (newBank.verifyUser()) {
            System.out.println(
                    "1. Add Customer\n2. View Customer\n3. Block Customer\n4. Unblock Customer\n5. Update Customer Details\n6. Delete Customer\n0. Exit");
            System.out.print("Select option : ");
            switch (newBank.sc.nextInt()) {
                case 1:
                    newBank.addCustomer();
                    break;
                case 2:
                    System.out.print("Enter Account Number : ");
                    newBank.viewCustomer(newBank.sc.nextLong());
                    break;
                case 3:
                    System.out.print("Enter Account Number : ");
                    newBank.blockCustomer(newBank.sc.nextLong());
                    break;
                case 4:
                    System.out.print("Enter Account Number : ");
                    newBank.unblockCustomer(newBank.sc.nextLong());
                    break;
                case 5:
                    System.out.print("Enter Account Number : ");
                    newBank.updateCustomer(newBank.sc.nextLong());
                    break;
                case 6:
                    System.out.print("Enter Account Number : ");
                    newBank.deleteCustomer(newBank.sc.nextLong());
                    break;

                default:
                    break;

            }
        }
        newBank.conn.close();
    }
}