package CustomerGUI;

import CorporateGUI.CorporateDetails;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfilePage extends JFrame implements ActionListener {
    private JLabel signUp;
    private RoundPanel signPan;
    private JLabel signTitle;
    private JLabel userName;
    private JTextField userField;
    private JLabel address;
    private JTextField addressField;
    private JLabel phone;
    private JTextField phoneField;
    private JLabel email;
    private JTextField emailField;
    private JLabel password;
    private JPasswordField passField;
    private JLabel lblDob;
    private JDateChooser fieldDob;
    protected static AttractiveButton btnSignUp;
    private JButton btnFb;
    private JLabel oRlbl;
    private JLabel errorLabel;
    private JTextField id;
    private JButton btnBack;
    public ProfilePage(){
        this.setLayout(null);

        ImageIcon signImg = new ImageIcon(LoginPage.class.getResource("HBS(photoDirectory)/Component 24.png"));
        JLabel signImgLbl = new JLabel(signImg);
        signImgLbl.setBounds(435, 5, 100, 80);
        this.add(signImgLbl);

        signPan = new RoundPanel();
        signPan.setBackground(Color.white);
        signPan.setBounds(290, 50, 400, 600);
        signPan.setLayout(null);
        this.add(signPan);

        signTitle = new JLabel("Profile Page");
        signTitle.setBounds(90, 20, 250, 40);
        signTitle.setFont(new Font("Arial", Font.BOLD, 30));
        signTitle.setForeground(Color.black);
        signPan.add(signTitle);

        errorLabel = new JLabel("");
        errorLabel.setBounds(97, 75, 250, 30);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        errorLabel.setForeground(Color.red);
        signPan.add(errorLabel);

        userName = new JLabel("Username");
        userName.setFont(new Font("Arial", Font.PLAIN, 15));
        userName.setBounds(50, 65, 100, 30);
        signPan.add(userName);

        String userMail = UserInput.getEmail().toString();
        String stName = userDetail.getName(userMail);
        userField = new JTextField(stName);
        userField.setBounds(50, 105, 280, 30);
        signPan.add(userField);

        String userID = userDetail.getID(userMail);
        String uid = userID.toString();
        System.out.println(uid);
        id = new JTextField(uid);

        address = new JLabel("Address");
        address.setFont(new Font("Arial", Font.PLAIN, 15));
        address.setBounds(50, 145, 100, 30);
        signPan.add(address);

        String stAddress = userDetail.getAddress(userMail);
        addressField = new JTextField(stAddress);
        addressField.setBounds(50, 185, 280, 30);
        signPan.add(addressField);

        phone = new JLabel("Phone");
        phone.setFont(new Font("Arial", Font.PLAIN, 15));
        phone.setBounds(50, 225, 100, 30);
        signPan.add(phone);

        String stPhone = userDetail.getPhone(userMail);
        phoneField = new JTextField(stPhone);
        phoneField.setBounds(50, 265, 280, 30);
        signPan.add(phoneField);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 15));
        email.setBounds(50, 305, 100, 30);
        signPan.add(email);

        String stEmail = userDetail.getEmail(userMail);
        emailField = new JTextField(stEmail);
        emailField.setBounds(50, 345, 280, 30);
        signPan.add(emailField);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setBounds(50, 385, 100, 30);
        signPan.add(password);

        String stPassword = userDetail.getPass(userMail);
        passField = new JPasswordField(stPassword);
        passField.setBounds(50, 425, 280, 30);
        signPan.add(passField);

        lblDob = new JLabel("Date of birth");
        lblDob.setFont(new Font("Arial", Font.PLAIN, 15));
        lblDob.setBounds(50, 465, 150, 30);
        signPan.add(lblDob);

        fieldDob = new JDateChooser();
        fieldDob.setBounds(50, 505, 280, 30);
        signPan.add(fieldDob);

        btnSignUp = new AttractiveButton("Update");
        btnSignUp.setBounds(50, 550, 280, 30);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setFocusPainted(false);
        btnSignUp.setBackground(Color.white);
        btnSignUp.addActionListener(this);
        signPan.add(btnSignUp);

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
        signPan.add(btnBack);

        ImageIcon bgImg = new ImageIcon(LoginPage.class.getResource("HBS(photoDirectory)/Desktop.jpg"));
        JLabel imgLbl = new JLabel(bgImg);
        imgLbl.setBounds(0, 0, 1000, 667);
        this.add(imgLbl);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this. setResizable(false);
        this. setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Customer Signup");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String uID = id.getText();
        String username = userField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String password = passField.getText();
        if(username.equals("") || address.equals("") || phone.equals("") || email.equals("") || password.equals("") && username.equals("Username") || address.equals("Address") || phone.equals("Phone") || email.equals("Email") || password.equals("Password")) {
            errorLabel.setText("fill up the fields.");
        }else{
                try{
                    Socket socket = new Socket("localhost", 5000);
                    System.out.println("Client connected");
                    OutputStream outputStream = socket.getOutputStream();
                    PrintWriter printWriter = new PrintWriter(outputStream, true);
                    String profUpdate = "Profile update:" + uID + ":" + username + ":" + address + ":" + phone + ":" + email + ":" + password;
                    InputStream inputStream = socket.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String respose = bufferedReader.readLine();
                    printWriter.println(respose);
                    printWriter.close();
                    bufferedReader.close();
                    inputStream.close();
                    outputStream.close();
                    socket.close();

                    JOptionPane.showMessageDialog(null, "Updated sucessfullt");

                }catch(IOException err1){
                    err1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "updation failed");
                }
            }

            }
    public static void main(String[] args){
        new ProfilePage();
    }
}
