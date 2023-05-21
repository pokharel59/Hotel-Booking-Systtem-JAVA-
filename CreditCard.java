package CustomerGUI;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCard  extends JFrame implements ActionListener {
    private JLabel creditCard;
    private JTextField cardNumber;
    private JTextField cvcNumber;
    private JComboBox paymentCombobox;
    private JDateChooser expDate;
    private JTextField cardHolderName;
    private JLabel errorLabel;
    private JButton btnDone;
    private String responce2;
    private String nameID;
    private JLabel lblCardNumber;
    private JLabel lblCvcNumber;
    private JLabel lblExpDate;
    private JLabel lblCardHolder;
    private JButton btnBck;
    public CreditCard(){
        super();

        // Set the layout manager for the panel
        this.setLayout(null);

        ImageIcon credImg = new ImageIcon(LoginPage.class.getResource("HBS(photoDirectory)/Component 26.png"));
        JLabel credImgLbl = new JLabel(credImg);
        credImgLbl.setBounds(440, 55, 100, 80);
        this.add(credImgLbl);

        RoundPanel ccPan = new RoundPanel();
        ccPan.setBackground(Color.white);
        ccPan.setBounds(290, 100, 400, 450);
        ccPan.setLayout(null);
        this.add(ccPan);

        creditCard = new JLabel("Credit Card");
        creditCard.setBounds(115, 25, 250, 40);
        creditCard.setFont(new Font("Arial", Font.BOLD, 30));
        creditCard.setForeground(Color.black);
        ccPan.add(creditCard);

        lblCardNumber = new JLabel("Card Number");
        lblCardNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        lblCardNumber.setBounds(50,80,200,30);
        ccPan.add(lblCardNumber);

        cardNumber = new JTextField();
        cardNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        cardNumber.setBounds(50, 120, 270, 30);
        ccPan.add(cardNumber);

        lblCvcNumber = new JLabel("CVC Number");
        lblCvcNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        lblCvcNumber.setBounds(50,240,200,30);
        ccPan.add(lblCvcNumber);

        cvcNumber = new JTextField();
        cvcNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        cvcNumber.setBounds(50, 280, 130, 30);
        ccPan.add(cvcNumber);

        lblExpDate = new JLabel("Expiry Date");
        lblExpDate.setFont(new Font("Arial", Font.PLAIN, 15));
        lblExpDate.setBounds(200, 240, 100, 30);
        ccPan.add(lblExpDate);

        expDate = new JDateChooser();
        expDate.setFont(new Font("Arial", Font.PLAIN, 15));
        expDate.setBounds(200, 280, 130, 30);
        ccPan.add(expDate);

        lblCardHolder = new JLabel("Card Holder");
        lblCardHolder.setFont(new Font("Arial", Font.PLAIN, 15));
        lblCardHolder.setBounds(50, 160, 200, 30);
        ccPan.add(lblCardHolder);

        cardHolderName = new JTextField();
        cardHolderName.setFont(new Font("Arial", Font.PLAIN, 15));
        cardHolderName.setBounds(50, 200, 270, 30);
        ccPan.add(cardHolderName);

        btnDone = new AttractiveButton("Done");
        btnDone.setFont(new Font("Arial", Font.PLAIN, 15));
        btnDone.addActionListener(this);
        btnDone.setBounds(50, 340, 280, 40);
        ccPan.add(btnDone);

        btnBck = new AttractiveButton("Back");
        btnBck.setBounds(10, 10, 50, 40);
        btnBck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LandingPage landingPage = new LandingPage();
                landingPage.setVisible(true);
                dispose();
            }
        });
        ccPan.add(btnBck);

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
    public void actionPerformed(ActionEvent e) {
         String cardNo = cardNumber.getText();
        String cvcNo = cvcNumber.getText();
        String cardHolder = cardHolderName.getText();
        Date expiryDate = expDate.getDate();
        if (expiryDate == null) {
            JOptionPane.showMessageDialog(null,"Please select a valid date of birth.");
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String cardExpiryDate = dateFormat.format(expiryDate);
        if (cardNo.equals("") || cvcNo.equals("") || cardHolder.equals("") || cardExpiryDate.equals("")){
            JOptionPane.showMessageDialog(null, "Field cannot be empty");

        }else{
            responce2 = "";
            nameID = cardHolderName.getText();
            System.out.println(nameID);
            responce2 = String.valueOf(getEmail_ID.getBookingID(nameID));
            System.out.println("Email ID + " + responce2);
            try {
                Socket socket = new Socket("localhost", 5000);
                System.out.println("Client connected");
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                String request = "Credit card:" + cardNo + ":" + responce2 + ":" + cvcNo + ":" + cardExpiryDate + ":" + cardHolder ;
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

                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
                CreditCard custCredit = (CreditCard) SwingUtilities.getWindowAncestor((AbstractButton) e.getSource());
                custCredit.dispose();

            } catch (IOException e1) {
                e1.printStackTrace();

            }
        }

    }
    public static void main(String[] args){
        new CreditCard();
    }
}
