package CustomerGUI;

import java.sql.*;

public class userDetail {
    public static String getID(String custMail){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT customerID FROM customers WHERE customerEmail=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, custMail);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String customerID = rs.getString("customerID");
                System.out.println(customerID);
                return customerID;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return "not found";
    }
    public static String getName(String custMail){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT customerName FROM customers WHERE customerEmail=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, custMail);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String customerName = rs.getString("customerName");
                System.out.println(customerName);
                return customerName;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return "not found";
    }
    public static String getAddress(String custMail){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT customerAddress FROM customers WHERE customerEmail=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, custMail);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String customerAddress = rs.getString("customerAddress");
                System.out.println(customerAddress);
                return customerAddress;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return "not found";
    }
    public static String getPhone(String custMail){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT customerPhone FROM customers WHERE customerEmail=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, custMail);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String customerPhone = rs.getString("customerPhone");
                System.out.println(customerPhone);
                return customerPhone;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return "not found";
    }
    public static String getEmail(String custMail){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT customerEmail FROM customers WHERE customerEmail=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, custMail);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String customerEmail = rs.getString("customerEmail");
                System.out.println(customerEmail);
                return customerEmail;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return "not found";
    }

    public static String getPass(String custEmail){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT customerPassword FROM customers WHERE customerEmail=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, custEmail);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String customerPasword = rs.getString("customerPassword");
                System.out.println(customerPasword);
                return customerPasword;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return "not found";
    }
    public static String getDOB(String custEmail){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT customerDOB FROM customers WHERE customerEmail=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, custEmail);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String customerDOB = rs.getString("customerDOB");
                System.out.println(customerDOB);
                return customerDOB;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return "not found";
    }
    public static String getRoomDesc(String roomType){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT roomDescription FROM roomTypes WHERE roomType=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, roomType);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String roomDescription = rs.getString("roomDescription");
                System.out.println(roomDescription);
                return roomDescription;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return "not found";
    }
    public static Double getRoomRate(String roomType){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT roomRate FROM roomTypes WHERE roomType=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, roomType);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                Double roomRate = rs.getDouble("roomRate");
                System.out.println(roomRate);
                return roomRate;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return (double) 0;
    }
    public static String getcuPhone(String phone){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT customerPhone FROM customers WHERE customerPhone=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, phone);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String customerPhone = rs.getString("customerPhone");
                System.out.println(customerPhone);
                return customerPhone;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return "not found";
    }
    }
