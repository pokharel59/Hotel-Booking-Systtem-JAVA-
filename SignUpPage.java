package CustomerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class SignUpPage extends JFrame implements ActionListener {
    private JLabel signUp;
    private RoundPanel signPan;
    private JLabel signTitle;
    private JLabel userName;
    private designedText userField;
    private JLabel address;
    private designedText addressField;
    private JLabel phone;
    private designedText phoneField;
    private JLabel email;
    private designedText emailField;
    private JLabel password;
    private JPasswordField passField;
    private JLabel lblDob;
    private JDateChooser fieldDob;
    protected static AttractiveButton btnSignUp;
    private JButton backBtn;

    public SignUpPage() {
        super();

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

        signTitle = new JLabel("Signup Account");
        signTitle.setBounds(90, 20, 250, 40);
        signTitle.setFont(new Font("Arial", Font.BOLD, 30));
        signTitle.setForeground(Color.black);
        signPan.add(signTitle);

        userName = new JLabel("Username");
        userName.setFont(new Font("Arial", Font.PLAIN, 15));
        userName.setBounds(50, 65, 100, 30);
        signPan.add(userName);

        userField = new designedText("Username");
        userField.setBounds(50, 105, 280, 30);
        signPan.add(userField);

        address = new JLabel("Address");
        address.setFont(new Font("Arial", Font.PLAIN, 15));
        address.setBounds(50, 145, 100, 30);
        signPan.add(address);

        addressField = new designedText("Address");
        addressField.setBounds(50, 185, 280, 30);
        signPan.add(addressField);

        phone = new JLabel("Phone");
        phone.setFont(new Font("Arial", Font.PLAIN, 15));
        phone.setBounds(50, 225, 100, 30);
        signPan.add(phone);

        phoneField = new designedText("Phone");
        phoneField.setBounds(50, 265, 280, 30);
        signPan.add(phoneField);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 15));
        email.setBounds(50, 305, 100, 30);
        signPan.add(email);

        emailField = new designedText("Email");
        emailField.setBounds(50, 345, 280, 30);
        signPan.add(emailField);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setBounds(50, 385, 100, 30);
        signPan.add(password);

        passField = new JPasswordField("Password");
        passField.setBounds(50, 425, 280, 30);
        signPan.add(passField);

        lblDob = new JLabel("Date of birth");
        lblDob.setFont(new Font("Arial", Font.PLAIN, 15));
        lblDob.setBounds(50, 465, 150, 30);
        signPan.add(lblDob);

// Create JCalendar component
        fieldDob = new JDateChooser();
        fieldDob.setBounds(50, 505, 280, 30);
        signPan.add(fieldDob);

        backBtn = new AttractiveButton("Back");
        backBtn.setBounds(10, 10, 50, 40);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LandingPage landingPage = new LandingPage();
                landingPage.setVisible(true);
                dispose();
            }
        });
        signPan.add(backBtn);

        btnSignUp = new AttractiveButton("Signup");
        btnSignUp.setBounds(50, 550, 280, 40);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setFocusPainted(false);
        btnSignUp.setBackground(Color.white);
        btnSignUp.addActionListener(this);
        signPan.add(btnSignUp);

        ImageIcon bgImg = new ImageIcon(LoginPage.class.getResource("HBS(photoDirectory)/Desktop.jpg"));
        JLabel imgLbl = new JLabel(bgImg);
        imgLbl.setBounds(0, 0, 1000, 667);
        this.add(imgLbl);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Customer Signup");

    }

    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String password = passField.getText();
        Date selectedDate = fieldDob.getDate(); // get the date object from the date picker field
        if (selectedDate == null) {
           JOptionPane.showMessageDialog(null,"Please select a valid date of birth.");
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateOfBirth = dateFormat.format(selectedDate);
        String phoneUser = userDetail.getcuPhone(phone);
        String pattern = "^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]+$";
        if (username.equals("") || address.equals("") || phone.equals("") || email.equals("") || password.equals("") && username.equals("Username") || address.equals("Address") || phone.equals("Phone") || email.equals("Email") || password.equals("Password")) {
            JOptionPane.showMessageDialog(null,"Fields cannot be empty.");
        } else if (phone.equals(phoneUser)) {
            JOptionPane.showMessageDialog(null,"User already exist");
        } else if (phone.length() < 9) {
            JOptionPane.showMessageDialog(null,"Invalid contact no.");
        } else if (password.length() > 16) {
            JOptionPane.showMessageDialog(null,"Password is longer.");
        } else if (!password.matches(pattern)) {
            JOptionPane.showMessageDialog(null,"Password must contain at least one symbol and one number.");
        } else {
            try {
                Socket socket = new Socket("localhost", 5000);
                System.out.println("Client connected");
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                String request = "registration:" + username + ":" + address + ":" + phone + ":" + email + ":" + password + ":" + dateOfBirth;
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

                CreditCard creditCard = new CreditCard();
                creditCard.setVisible(true);
                SignUpPage custSignUpPage = (SignUpPage) SwingUtilities.getWindowAncestor((AbstractButton) e.getSource());
                custSignUpPage.dispose();

            } catch (IOException e1) {
                e1.printStackTrace();

            }
        }
    }

    public static void main(String[] args) {
        new SignUpPage();
    }
}
