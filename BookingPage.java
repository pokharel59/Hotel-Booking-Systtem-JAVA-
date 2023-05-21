package CustomerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.jdesktop.swingx.border.DropShadowBorder;
import com.toedter.calendar.JDateChooser;

public class BookingPage extends JFrame implements ActionListener {
    private JButton hotelName;
    private RoundPanel bookingPan;
    private AttractiveButton btnBooking;
    private RoundPanel userType;
    private static JDateChooser checkInDate;
    private static JDateChooser checkOutDate;
    private static JComboBox checkRooms;
    private TextField roomField;
    private TextField guestField;
    private  JButton roomBtn;
    private JButton guestBtn;
    private JLabel bookingLbl;
    private JLabel lblCheckin;
    private JLabel lblCheckout;
    private designedText cmtText;
    private String emailID;
    private String responce1;
    private JLabel errorLabel;
    private JButton profileBtn;
    private JButton loginBtn;
    private JButton signupBtn;
    private JLabel lblCheckRoom;
    private JLabel lblRooms;
    private JLabel lblGuest;
    private JButton btnDescRoom;
    private JButton btnDescGuest;
    private JLabel lblWel;
    private JTextField fieldID;
    private JButton btnHist;
    public BookingPage(){
        super();

        this.setLayout(null);


        userType = new RoundPanel();
        userType.setBackground(Color.white);
        userType.setBounds(370, 150, 250, 50);
        DropShadowBorder border = new DropShadowBorder();
        userType.setBorder(border);
        userType.setLayout(null);
        this.add(userType);

        bookingLbl = new JLabel("Booking");
        bookingLbl.setBounds(65, 2, 200, 50);
        bookingLbl.setFont(new Font("Arial", Font.BOLD, 30));
        userType.add(bookingLbl);

        btnBooking = new AttractiveButton("Search");
        btnBooking.setBounds(370, 520, 250, 60);
        btnBooking.setFont(new Font("Arial", Font.PLAIN, 30));
        DropShadowBorder border1 = new DropShadowBorder();
        btnBooking.setBorder(border1);
        btnBooking.addActionListener(this);
        btnBooking.setFocusPainted(false);
        this.add(btnBooking);

        bookingPan = new RoundPanel();
        bookingPan.setBackground(Color.white);
        bookingPan.setBounds(150, 170, 700, 380);
        bookingPan.setLayout(null);
        this.add(bookingPan);

        errorLabel = new JLabel("");
        errorLabel.setBounds(97, 75, 250, 30);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        errorLabel.setForeground(Color.red);
        bookingPan.add(errorLabel);

        lblCheckin = new JLabel("Check-in date");
        lblCheckin.setBounds(50, 35, 100, 30);
        lblCheckin.setFont(new Font("Arial", Font.PLAIN, 15));
        bookingPan.add(lblCheckin);

        checkInDate = new JDateChooser();
        checkInDate.setBounds(50, 65, 225, 30);
        bookingPan.add(checkInDate);

        lblCheckout = new JLabel("Check-out date");
        lblCheckout.setBounds(380, 35, 105, 30);
        lblCheckout.setFont(new Font("Arial", Font.PLAIN, 15));
        bookingPan.add(lblCheckout);

        checkOutDate = new JDateChooser();
        checkOutDate.setBounds(380, 65, 225, 30);
        bookingPan.add(checkOutDate);

        lblCheckRoom = new JLabel("Room Type");
        lblCheckRoom.setBounds(50, 170, 105, 30);
        lblCheckRoom.setFont(new Font("Arial", Font.PLAIN, 15));
        bookingPan.add(lblCheckRoom);

        String[] roomTypes = {"Standard Single Bed Room", "Deluxe Double Bed Room", "Budget room"};
        checkRooms = new JComboBox(roomTypes);
        checkRooms.setBounds(50, 200, 280, 30);
        bookingPan.add(checkRooms);

        lblGuest = new JLabel("Guests");
        lblGuest.setBounds(380, 100, 105, 30);
        lblGuest.setFont(new Font("Arial", Font.PLAIN, 15));
        bookingPan.add(lblGuest);

        guestField = new TextField("1");
        guestField.setBounds(420, 130, 150, 30);
        bookingPan.add(guestField);
        guestBtn = new AttractiveButton("+");
        guestBtn.setFont(new Font("Arial", getFont().PLAIN, 15));
        guestBtn.setFocusPainted(false);
        guestBtn.setBounds(565, 130, 45, 29);
        guestBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value1 = Integer.parseInt(guestField.getText());
                guestField.setText(Integer.toString(value1 + 1));
            }
        });
        btnDescGuest = new AttractiveButton("-");
        btnDescGuest.setFont(new Font("Arial", getFont().PLAIN, 15));
        btnDescGuest.setFocusPainted(false);
        btnDescGuest.setBounds(380, 130, 45, 29);
        btnDescGuest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value2 = Integer.parseInt(guestField.getText());
                guestField.setText(Integer.toString(value2 - 1));
            }
        });
        bookingPan.add(guestBtn);
        bookingPan.add(btnDescGuest);

        lblRooms = new JLabel("Rooms");
        lblRooms.setBounds(50, 100, 105, 30);
        lblRooms.setFont(new Font("Arial", Font.PLAIN, 15));
        bookingPan.add(lblRooms);

        roomField = new TextField("1");
        roomField.setBounds(90, 130, 165, 30);
        bookingPan.add(roomField);
        roomBtn = new AttractiveButton("+");
        roomBtn.setFont(new Font("Arial", getFont().PLAIN, 15));
        roomBtn.setFocusPainted(false);
        roomBtn.setBounds(250, 130, 45, 29);
        roomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(roomField.getText());
                roomField.setText(Integer.toString(value + 1));
            }
        });
        btnDescRoom = new AttractiveButton("-");
        btnDescRoom.setFont(new Font("Arial", getFont().PLAIN, 15));
        btnDescRoom.setFocusPainted(false);
        btnDescRoom.setBounds(50, 130, 45, 29);
        btnDescRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value3 = Integer.parseInt(roomField.getText());
                roomField.setText(Integer.toString(value3 - 1));
            }
        });
        bookingPan.add(roomBtn);
        bookingPan.add(btnDescRoom);

        String email = UserInput.getEmail();
        String ID = userDetail.getID(email);
        fieldID = new JTextField(ID);
        System.out.println(ID);

        cmtText = new designedText("Enter comments.......");
        cmtText.setBorder(BorderFactory.createLineBorder(Color.black));
        cmtText.setFont(new Font("Ariel", Font.PLAIN, 15));
        cmtText.setBounds(50, 250, 625, 85);
        bookingPan.add(cmtText);

        String loMail = UserInput.getEmail();
        String uName = userDetail.getName(loMail);
        lblWel = new JLabel("Welcome Back " + uName + "!");
        lblWel.setBounds(320, 0, 210, 30);
        lblWel.setForeground(Color.BLACK);
        lblWel.setFont(new Font("Arial", Font.BOLD, 16));
        lblWel.setOpaque(true);
        this.add(lblWel);

        profileBtn = new AttractiveButton("Profile");
        profileBtn.setFont(new Font("Ariel", Font.PLAIN, 15));
        profileBtn.setBounds(870, 10, 100, 40);
        profileBtn.setFocusPainted(false);
        profileBtn.addActionListener(this::actionPerformed1);
        this.add(profileBtn);

        signupBtn = new AttractiveButton("Signup");
        signupBtn.setFont(new Font("Ariel", Font.PLAIN, 15));
        signupBtn.setBounds(630, 10, 100, 40);
        signupBtn.setFocusPainted(false);
        signupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpPage signUpPage = new SignUpPage();
                signUpPage.setVisible(true);
                dispose();
            }
        });
        this.add(signupBtn);

        loginBtn = new AttractiveButton("Login");
        loginBtn.setFont(new Font("Ariel", Font.PLAIN, 15));
        loginBtn.setBounds(750, 10, 100, 40);
        loginBtn.setFocusPainted(false);
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
                dispose();
            }
        });
        this.add(loginBtn);

        hotelName = new JButton("Luton");
        hotelName.setBounds(5, 0, 140, 30);
        hotelName.setOpaque(true);
        hotelName.setBackground(new Color(238,238,238));
        hotelName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        hotelName.setFocusPainted(false);
        hotelName.setBorderPainted(false);
        hotelName.setFont(new Font("Arial", Font.BOLD, 30));
        hotelName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LandingPage landingPage = new LandingPage();
                landingPage.setVisible(true);
                dispose();
            }
        });
        this.add(hotelName);

        ImageIcon bgImg = new ImageIcon(LoginPage.class.getResource("HBS(photoDirectory)/bookingBg.png"));
        JLabel imgLbl = new JLabel(bgImg);
        imgLbl.setBounds(5,30,976,337);
        this.add(imgLbl);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this. setResizable(false);
        this. setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Customer Booking");
    }

    public void actionPerformed(ActionEvent e) {
        // Get the input values from the GUI
        String DatecheckIn = getFormattedDate(checkInDate.getDate());
        if (DatecheckIn == null) {
            JOptionPane.showMessageDialog(null,"Please select a valid date of birth.");
            return;
        }
        String DatecheckOut = getFormattedDate(checkOutDate.getDate());
        if (DatecheckIn == null) {
            JOptionPane.showMessageDialog(null,"Please select a valid date of birth.");
            return;
        }
        String roomTypes = checkRooms.getSelectedItem().toString();
        String noRooms = roomField.getText();
        String noGuest = guestField.getText();
        String comments = cmtText.getText();
        String id = fieldID.getText();

        // Check if any required field is empty
        if(isInputValid(DatecheckIn, DatecheckOut, roomTypes, noRooms, noGuest)) {
            try {
                // Create a socket and send the booking request to the server
                Socket socket = new Socket("localhost", 5000);
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                String request = "booking:" + id + ":" + DatecheckIn + ":" + DatecheckOut + ":" + roomTypes + ":" + noRooms + ":" + noGuest + ":" + comments;
                printWriter.println(request);

                // Wait for the server's response and print it to the console
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String response = bufferedReader.readLine();
                System.out.println(response);

                // Close the streams and the socket
                printWriter.close();
                bufferedReader.close();
                inputStream.close();
                outputStream.close();
                socket.close();

                // Set the selected room type in the UserInput class
                UserInput.setRoomType(roomTypes);

                // Get the available rooms for the selected room type and dates
                AvailableRooms availableRooms = new AvailableRooms();
                availableRooms.setVisible(true);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            // Display an error message if any required field is empty
            errorLabel.setText("Please fill in all required fields.");
        }
    }

    public void actionPerformed1(ActionEvent e){
        ProfilePage profilePage = new ProfilePage();
        profilePage.setVisible(true);
        dispose();
    }

    // Check if any required field is empty
    private boolean isInputValid(String DatecheckIn, String DatecheckOut, String roomTypes, String noRooms, String noGuest) {
        return !DatecheckIn.isEmpty() && !DatecheckOut.isEmpty() && !roomTypes.isEmpty() && !noRooms.isEmpty() && !noGuest.isEmpty();
    }

    // Format a date object as a string
    private static String getFormattedDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    // Get the selected room type from the GUI
    public static String getRoomType() {
        return checkRooms.getSelectedItem().toString();
    }

    // Get the check-in date from the GUI
    public static String getCheckIn() {
        return getFormattedDate(checkInDate.getDate());
    }

    // Get the check-out date from the GUI
    public static String getCheckOut() {
        return getFormattedDate(checkOutDate.getDate());
    }

    // Get the total cost of the booking
    public static double getTotalCost() {
        long totalCost = ChronoUnit.DAYS.between(checkInDate.getDate().toInstant(), checkOutDate.getDate().toInstant());
        Double rate = userDetail.getRoomRate(checkRooms.getSelectedItem().toString());
        return totalCost * rate;
    }

    public static void main(String[] args){
        new BookingPage();
    }
}
