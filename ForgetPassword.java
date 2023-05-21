package CustomerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ForgetPassword extends JFrame implements ActionListener {
    private RoundPanel frgtPan;
    private JLabel forgetPassword;
    private JLabel lblEmail;
    private JTextField fieldEmail;
    private JLabel lblPassword;
    private JTextField fieldPassword;
    private JLabel lblConPass;
    private JTextField fieldConPass;
    private AttractiveButton btnUpdate;
    private JLabel errorLabel;

    public ForgetPassword(){
        super();

        this.setLayout(null);

        frgtPan = new RoundPanel();
        frgtPan.setBackground(Color.white);
        frgtPan.setBounds(290, 80, 400, 480);
        frgtPan.setLayout(null);
        this.add(frgtPan);

        forgetPassword = new JLabel("Forgot Password");
        forgetPassword.setBounds(90, 20, 250, 40);
        forgetPassword.setFont(new Font("Arial", Font.BOLD, 30));
        forgetPassword.setForeground(Color.black);
        frgtPan.add(forgetPassword);

        errorLabel = new JLabel("");
        errorLabel.setBounds(97, 75, 250, 30);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        errorLabel.setForeground(Color.red);
        frgtPan.add(errorLabel);

        // Create the username label and text field
        lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        lblEmail.setBounds(50, 80, 100, 30);
        frgtPan.add(lblEmail);
//
        fieldEmail = new designedText("Email");
        fieldEmail.setBounds(50, 120, 280, 35);
        frgtPan.add(fieldEmail);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        lblPassword.setBounds(50, 160, 100, 30);
        frgtPan.add(lblPassword);

        fieldPassword = new designedText("Password");
        fieldPassword.setBounds(50, 200, 280, 30);
        frgtPan.add(fieldPassword);

        lblConPass = new JLabel("Confirm Password");
        lblConPass.setFont(new Font("Arial", Font.PLAIN, 15));
        lblConPass.setBounds(50, 240, 150, 30);
        frgtPan.add(lblConPass);

        fieldConPass = new designedText("Password");
        fieldConPass.setBounds(50, 280, 280, 30);
        frgtPan.add(fieldConPass);

        btnUpdate = new AttractiveButton("Update");
        btnUpdate.setBounds(110, 320, 150, 40);
        btnUpdate.addActionListener(this);
        frgtPan.add(btnUpdate);

        ImageIcon bgImg = new ImageIcon(LoginPage.class.getResource("HBS(photoDirectory)/Desktop.jpg"));
        JLabel imgLbl = new JLabel(bgImg);
        imgLbl.setBounds(0,0,1000,667);
        this.add(imgLbl);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this. setResizable(false);
        this. setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String frgtEmail = fieldEmail.getText();
        String frgtPassword = fieldPassword.getText();
        String frgtConPassword = fieldConPass.getText();
        if(frgtEmail.equals("") || frgtPassword.equals("") || frgtConPassword.equals("") && frgtEmail.equals("Email") || frgtPassword.equals("Password") || frgtConPassword.equals("Confirm Password")){
            errorLabel.setText("Invalid email and password");
        }else{
            try{
                Socket socket = new Socket("localhost", 5000);
                System.out.println("Client connected");
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                String request = "forgotPassword:" + frgtEmail + ":" + frgtPassword;
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


            } catch (IOException e1) {
                e1.printStackTrace();

            }
        }
    }
    public static void main(String[] args){
        new ForgetPassword();
    }
}
