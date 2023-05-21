package CustomerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import CorporateGUI.CorporateBooking;
import StaffGUI.StaffCustDashbord;

public class LoginPage extends JFrame implements ActionListener {
    private JLabel emailLbl;
    private JLabel lblOr;
    protected static designedText emailField;
    private JTextField passwordField;
    private JLabel login;
    protected AttractiveButton btnLogin;
    protected JButton btnFgt;
    private JButton btnBack;

    public LoginPage() {
        super();

        // Set the layout manager for the panel
        this.setLayout(null);

        ImageIcon logImg = new ImageIcon(LoginPage.class.getResource("HBS(photoDirectory)/Component 23.png"));
        JLabel logImgLbl = new JLabel(logImg);
        logImgLbl.setBounds(385, 50, 100, 80);
        this.add(logImgLbl);

        RoundPanel logPan = new RoundPanel();
        logPan.setBackground(Color.white);
        logPan.setBounds(240, 100, 400, 430);
        logPan.setLayout(null);
        this.add(logPan);

        login = new JLabel("Login Account");
        login.setBounds(90, 40, 250, 40);
        login.setFont(new Font("Arial", Font.BOLD, 30));
        login.setForeground(Color.black);
        logPan.add(login);

        // Create the username label and text field
        emailLbl = new JLabel("Email");
        emailLbl.setFont(new Font("Arial", Font.PLAIN, 15));
        emailLbl.setBounds(50, 100, 100, 30);
        logPan.add(emailLbl);
//
        emailField = new designedText("Email");
        emailField.setBounds(50, 140, 280, 35);
        logPan.add(emailField);
//
        // Create the password label and text field
        lblOr = new JLabel("Password");
        lblOr.setFont(new Font("Arial", Font.PLAIN, 15));
        lblOr.setBounds(50, 190, 100, 30);
        logPan.add(lblOr);
//
        passwordField = new designedText("Password");
        passwordField.setBounds(50, 230, 280, 35);
        logPan.add(passwordField);

        btnLogin = new AttractiveButton("Login");
        btnLogin.setBounds(50, 310, 280, 40);
        btnLogin.addActionListener(this);
        logPan.add(btnLogin);

        btnBack = new AttractiveButton("Back");
        btnBack.setBounds(10, 10, 50, 40);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LandingPage landingPage = new LandingPage();
                landingPage.setVisible(true);
                dispose();
            }
        });
        logPan.add(btnBack);

        btnFgt = new JButton("Forget Password?");
        btnFgt.setBounds(197, 270, 150, 20);
        btnFgt.setBorderPainted(false);
        btnFgt.setFocusPainted(false);
        btnFgt.setBackground(Color.white);
        logPan.add(btnFgt);

        ImageIcon bgImg = new ImageIcon(LoginPage.class.getResource("HBS(photoDirectory)/Desktop.jpg"));
        JLabel imgLbl = new JLabel(bgImg);
        imgLbl.setBounds(0, 0, 1000, 667);
        this.add(imgLbl);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Login");

    }

    public void actionPerformed(ActionEvent e) {
        String eMail = emailField.getText();
        String passWord = passwordField.getText();
        if (eMail.equals("") || passWord.equals("") && eMail.equals("Email") || passWord.equals("Password")) {
            JOptionPane.showMessageDialog(null,"Invalid email and password");
        } else {
            try {
                Socket socket = new Socket("localhost", 5000);
                System.out.println("Client connected");
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                String request = "login:" + eMail + ":" + passWord;
                printWriter.println(request);
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String response = bufferedReader.readLine();
                printWriter.println(response);
                printWriter.close();
                bufferedReader.close();
                inputStream.close();
                outputStream.close();
                socket.close();

                UserInput.setEmail(eMail);

                String customerID = getEmail_ID.getEmailID(eMail);
                String corporateID = getEmail_ID.getcorpEmailID(eMail);
                String staffID = getEmail_ID.getstaffEmailID(eMail);

                if(passWord.equals(customerID)){ // user is a customer
                    BookingPage bookingPage = new BookingPage();
                    bookingPage.setVisible(true);
                    this.dispose();
                }else if(passWord.equals(corporateID)){ // user is a corporate user
                    CorporateBooking corporateBooking = new CorporateBooking();
                    corporateBooking.setVisible(true);
                    this.dispose();
                } else if(passWord.equals(staffID)) { // user is a corporate user
                    StaffCustDashbord staffCustDashbord = new StaffCustDashbord();
                    staffCustDashbord.setVisible(true);
                    this.dispose();
                }else{
                    // user not found
                    JOptionPane.showMessageDialog(this, "User not matched", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException e1) {
                e1.printStackTrace();

            }
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}

