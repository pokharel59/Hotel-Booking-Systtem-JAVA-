package CustomerGUI;

import org.jdesktop.swingx.border.DropShadowBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBooking extends JFrame {
    private JPanel viewTitle;
    private JPanel viewPan;
    private JButton btnOk;
    private JLabel lblUser;
    private JLabel lblRoomType;
    private JLabel lblNoBeds;
    private JLabel lblCheckIn;
    private JLabel lblCheckOut;
    private JLabel lblRoomDescription;
    private JLabel lblRoomRate;
    private JLabel lblTotalPrice;
    private JLabel userName;
    private JLabel userAdd;
    private JLabel userPhone;
    private JLabel userEmail;
    private JLabel roomtype;
    private JLabel CheckIn;
    private JLabel CheckOut;
    private JLabel lblRoomDesc;
    private JLabel totalRate;
    private JLabel rmRate;
    private JLabel title;
    private JButton btnConfirm;
    private JButton hotelName;
    private JButton profileBtn;
    private JButton historyBtn;
    private JLabel lblWel;
    private JButton btnLogin;
    public ViewBooking(){
        super();

        this.setLayout(null);

        viewTitle = new RoundPanel();
        viewTitle.setBackground(Color.white);
        viewTitle.setBounds(400, 150, 200, 50);
        DropShadowBorder border = new DropShadowBorder();
        viewTitle.setBorder(border);
        viewTitle.setLayout(null);
        this.add(viewTitle);

        title = new JLabel("View Booking");
        title.setBounds(25, 2, 200, 50);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        viewTitle.add(title);

        btnOk = new AttractiveButton("Edit");
        btnOk.setBounds(300, 520, 150, 50);
        btnOk.setFont(new Font("Arial", Font.PLAIN, 20));
        DropShadowBorder border1 = new DropShadowBorder();
        btnOk.setBorder(border1);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateBooking updateBooking = new UpdateBooking();
                updateBooking.setVisible(true);
            }
        });
        btnOk.setFocusPainted(false);
        this.add(btnOk);

        btnConfirm = new AttractiveButton("Confirm");
        btnConfirm.setBounds(550, 520, 150, 50);
        btnConfirm.setFont(new Font("Arial", Font.PLAIN, 20));
        DropShadowBorder border2 = new DropShadowBorder();
        btnConfirm.setBorder(border2);
        btnConfirm.setFocusPainted(false);
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateBooking updateBooking = new UpdateBooking();
            }
        });
        this.add(btnConfirm);

        viewPan = new RoundPanel();
        viewPan.setBackground(Color.white);
        viewPan.setBounds(250, 170, 500, 380);
        viewPan.setLayout(null);
        this.add(viewPan);

        lblUser = new JLabel("User Description:");
        lblUser.setFont(new Font("Arial", Font.PLAIN, 15));
        lblUser.setBounds(50, 40, 150, 20);
        viewPan.add(lblUser);

        String getemail = UserInput.getEmail();
        String getuserName = userDetail.getName(getemail);
        userName = new JLabel(getuserName);
        userName.setFont(new Font("Arial", Font.PLAIN, 15));
        userName.setBounds(320, 40, 100, 15);
        viewPan.add(userName);

        String getuserAdd = userDetail.getAddress(getemail);
        userAdd = new JLabel(getuserAdd);
        userAdd.setFont(new Font("Arial", Font.PLAIN, 10));
        userAdd.setBounds(320, 55, 100, 15);
        viewPan.add(userAdd);

        String getuserPhone = userDetail.getPhone(getemail);
        userPhone = new JLabel(getuserPhone);
        userPhone.setFont(new Font("Arial", Font.PLAIN, 10));
        userPhone.setBounds(320, 70, 100, 15);
        viewPan.add(userPhone);

        String getuserEmail = userDetail.getEmail(getemail);
        userEmail = new JLabel(getuserEmail);
        userEmail.setFont(new Font("Arial", Font.PLAIN, 10));
        userEmail.setBounds(320, 85, 100, 15);
        viewPan.add(userEmail);

        String typRoom = BookingPage.getRoomType();
        roomtype = new JLabel(typRoom);
        roomtype.setFont(new Font("Arial", Font.PLAIN, 15));
        roomtype.setBounds(320, 120, 200, 20);
        viewPan.add(roomtype);

        String inRoom = BookingPage.getCheckIn();
        CheckIn = new JLabel(inRoom);
        CheckIn.setFont(new Font("Arial", Font.PLAIN, 15));
        CheckIn.setBounds(320, 160, 100, 20);
        viewPan.add(CheckIn);

        String outRoom = BookingPage.getCheckOut();
        CheckOut = new JLabel(outRoom);
        CheckOut.setFont(new Font("Arial", Font.PLAIN, 15));
        CheckOut.setBounds(320, 200, 100, 20);
        viewPan.add(CheckOut);

        String stRoomTyp = roomtype.toString();
        String descRoom = userDetail.getRoomDesc(stRoomTyp);
        lblRoomDesc = new JLabel(descRoom);
        lblRoomDesc.setFont(new Font("Arial", Font.PLAIN, 15));
        lblRoomDesc.setBounds(320, 240, 100, 20);
        viewPan.add(lblRoomDesc);

        Double rate = BookingPage.getTotalCost();
        String stRate = rate.toString();
        totalRate = new JLabel(stRate);
        totalRate.setFont(new Font("Arial", Font.PLAIN, 15));
        totalRate.setBounds(320, 320, 100, 20);
        viewPan.add(totalRate);

        lblRoomType = new JLabel("Room Type:");
        lblRoomType.setFont(new Font("Arial", Font.PLAIN, 15));
        lblRoomType.setBounds(50, 120, 150, 20);
        viewPan.add(lblRoomType);

        lblCheckIn = new JLabel("Check In Date:");
        lblCheckIn.setFont(new Font("Arial", Font.PLAIN, 15));
        lblCheckIn.setBounds(50, 160, 150, 20);
        viewPan.add(lblCheckIn);

        lblCheckOut = new JLabel("Check Out Date:");
        lblCheckOut.setFont(new Font("Arial", Font.PLAIN, 15));
        lblCheckOut.setBounds(50, 200, 150, 20);
        viewPan.add(lblCheckOut);

        lblRoomDescription = new JLabel("Room Description:");
        lblRoomDescription.setFont(new Font("Arial", Font.PLAIN, 15));
        lblRoomDescription.setBounds(50, 240, 150, 20);
        viewPan.add(lblRoomDescription);

        lblRoomRate = new JLabel("Room Rate:");
        lblRoomRate.setFont(new Font("Arial", Font.PLAIN, 15));
        lblRoomRate.setBounds(50, 280, 150, 20);
        viewPan.add(lblRoomRate);

        String typRm = BookingPage.getRoomType();
        Double rmPrice = userDetail.getRoomRate(typRm);
        String stPrice = rmPrice.toString();
        rmRate = new JLabel(stPrice);
        rmRate.setFont(new Font("Arial", Font.PLAIN, 15));
        rmRate.setBounds(320, 280, 100, 20);
        viewPan.add(rmRate);

        lblTotalPrice = new JLabel("Total Price:");
        lblTotalPrice.setFont(new Font("Arial", Font.PLAIN, 15));
        lblTotalPrice.setBounds(50, 320, 150, 20);
        viewPan.add(lblTotalPrice);

        String loMail = UserInput.getEmail();
        String uName = userDetail.getName(loMail);
        lblWel = new JLabel("Welcome Back " + uName + "!");
        lblWel.setBounds(330, 0, 350, 30);
        lblWel.setForeground(Color.BLACK);
        lblWel.setFont(new Font("Arial", Font.BOLD, 16));
        lblWel.setOpaque(true);
        this.add(lblWel);

        btnLogin = new AttractiveButton("Login");
        btnLogin.setFont(new Font("Ariel", Font.PLAIN, 15));
        btnLogin.setBounds(630, 10, 100, 40);
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
                dispose();
            }
        });
        this.add(btnLogin);

        historyBtn = new AttractiveButton("History");
        historyBtn.setFont(new Font("Ariel", Font.PLAIN, 15));
        historyBtn.setBounds(750, 10, 100, 40);
        historyBtn.setFocusPainted(false);
        historyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateBooking updateBooking = new UpdateBooking();
            }
        });
        this.add(historyBtn);

        profileBtn = new AttractiveButton("Profile");
        profileBtn.setFont(new Font("Ariel", Font.PLAIN, 15));
        profileBtn.setBounds(870, 10, 100, 40);
        profileBtn.setFocusPainted(false);
        profileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfilePage profilePage = new ProfilePage();
                profilePage.setVisible(true);
                dispose();
            }
        });
        this.add(profileBtn);

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
                BookingPage bookingPage = new BookingPage();
                bookingPage.setVisible(true);
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
        this.setBackground(Color.WHITE);
        this. setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Customer Booking");
    }

    public void actionPerformed(ActionEvent e){
        BookingPage bookingPage = new BookingPage();
        ViewBooking viewBooking = new ViewBooking();
        viewBooking.dispose();
    }

    public static void main(String[] args){
        new ViewBooking();
    }
}
