package CustomerGUI;

import java.sql.*;
public class getEmail_ID {
    public static String getEmailID(String emailID) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT customerPassword From customers WHERE customerEmail = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, emailID);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Customer email ID + " + rs);

            if (rs.next()) {
                String customerPassword = rs.getString("customerPassword");
                System.out.println("Customer email id :" + customerPassword);
                return customerPassword;
            } else {
                System.out.print("Could not find the ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User invalid";
    }

    public static String getcorpEmailID(String emailID) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT corporatePassword FROM corporates WHERE corporateEmail = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, emailID);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Corporate email ID: " + rs);

            if (rs.next()) {
                String corporatePassword = rs.getString("corporatePassword");
                System.out.println("Corporate ID: " + corporatePassword);
                return corporatePassword;
            } else {
                System.out.print("Could not find the ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User invalid";
    }

    public static String getstaffEmailID(String emailID) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT staffPassword FROM staffs WHERE staffEmail = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, emailID);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Corporate email ID: " + rs);

            if (rs.next()) {
                String staffPassword = rs.getString("staffPassword");
                System.out.println("staff ID: " + staffPassword);
                return staffPassword;
            } else {
                System.out.print("Could not find the ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User invalid";
    }

    public static int getBookingID(String nameID) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT customerID FROM customers WHERE customerName= ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nameID);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Customer email ID: " + rs);

            if (rs.next()) {
                int customerID = rs.getInt("customerID");
                System.out.println("Customer ID: " + customerID);
                return customerID;
            } else {
                System.out.print("Could not find the ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public static int getcorpID(String nameID) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT corporateID FROM corporates WHERE corporateName = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nameID);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Corporate email ID: " + rs);

            if (rs.next()) {
                int corporateID = rs.getInt("corporateID");
                System.out.println("Corporate ID: " + corporateID);
                return corporateID;
            } else {
                System.out.print("Could not find the ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
