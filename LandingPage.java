package CustomerGUI;

import CorporateGUI.CorporateSignUp;
import StaffGUI.StaffSignUp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LandingPage extends JFrame implements ActionListener {
    private RoundPanel landingPage;
    private JLabel hotelName;
    public AttractiveButton loginB;
    public JButton signupB;
    private JLabel descHed;
    private JLabel descSub;
    protected AttractiveButton getStarted;
    private JLabel accmod;
    private JButton btnCorp;
    private JButton btnStaff;
    private JLabel choseUser;

    public LandingPage() {
        super();

        this.setLayout(null);
//
        landingPage = new RoundPanel();
        landingPage.setBackground(Color.white);
        landingPage.setBounds(95, 80, 800, 500);
        landingPage.setLayout(null);
        this.add(landingPage);

        hotelName = new JLabel("Luton");
        hotelName.setBounds(20, 5, 140, 50);
        hotelName.setFont(new Font("Arial", Font.BOLD, 37));
        landingPage.add(hotelName);

        descHed = new JLabel("Book your");
        descHed.setBounds(20, 77, 500, 160);
        descHed.setFont(new Font("Arial", Font.BOLD, 50));
        descHed.setForeground(Color.black);
        landingPage.add(descHed);

        accmod = new JLabel("Accomodation.");
        accmod.setBounds(20, 135, 500, 160);
        accmod.setFont(new Font("League spartan", Font.PLAIN, 55));
        accmod.setForeground(Color.black);
        landingPage.add(accmod);

        descSub = new JLabel("<html>Stay with comfort and enjoy with freedom <br>book hotel in 50% offer during the easter breaks.<br>Join with us to get more offers and discount.</html>");
        descSub.setBounds(20, 235, 500, 100);
        descSub.setFont(new Font("League spartan", Font.PLAIN, 15));
        descSub.setForeground(Color.gray);
        landingPage.add(descSub);

        loginB = new AttractiveButton("Login");
        loginB.setBounds(420, 25, 100, 40);
        loginB.setFocusPainted(false);
        loginB.setBorderPainted(false);
        loginB.addActionListener(this::actionPerformed3);
        landingPage.add(loginB);

        btnCorp = new AttractiveButton("corporate");
        btnCorp.setBounds(678, 25, 100, 40);
        btnCorp.addActionListener(this::actionPerformed2);
        btnCorp.setFocusPainted(false);
        btnCorp.setBorderPainted(false);
        landingPage.add(btnCorp);

        btnStaff = new AttractiveButton("Staff");
        btnStaff.setBounds(550, 25, 100, 40);
        btnStaff.addActionListener(this::actionPerformed4);
        btnStaff.setFocusPainted(false);
        btnStaff.setBorderPainted(false);
        landingPage.add(btnStaff);

        getStarted = new AttractiveButton("Get Started");
        getStarted.setBounds(60, 353, 150, 45);
        getStarted.addActionListener(this::actionPerformed);
        landingPage.add(getStarted);

        choseUser = new JLabel("Sign up here. For");
        choseUser.setBounds(555, 1, 500, 20);
        choseUser.setFont(new Font("League spartan", Font.PLAIN, 15));
        choseUser.setForeground(Color.black);
        landingPage.add(choseUser);

        ImageIcon serviceImg = new ImageIcon(LandingPage.class.getResource("HBS(photoDirectory)/illustration.png"));
        JLabel service1 = new JLabel(serviceImg);
        service1.setBounds(430, 90, 350, 350);
        landingPage.add(service1);

        ImageIcon paneImg = new ImageIcon(LandingPage.class.getResource("HBS(photoDirectory)/Polygon 6.png"));
        JLabel paneLbl = new JLabel(paneImg);
        paneLbl.setBounds(290, -25, 1000, 700);
        landingPage.add(paneLbl);

        ImageIcon bgImg = new ImageIcon(LandingPage.class.getResource("HBS(photoDirectory)/Desktop.jpg"));
        JLabel bgLbl = new JLabel(bgImg);
        bgLbl.setBounds(0, 0, 1000, 700);
        this.add(bgLbl);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this. setResizable(false);
        this.setBackground(Color.WHITE);
        this. setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.setVisible(true);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(landingPage);
        frame.dispose();
    }
    public void actionPerformed2(ActionEvent e){
        CorporateSignUp corporateSignUp = new CorporateSignUp();
        corporateSignUp.setVisible(true);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(landingPage);
        frame.dispose();
    }
    public void actionPerformed3(ActionEvent e){
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(landingPage);
        frame.dispose();
    }
    public void actionPerformed4(ActionEvent e){
        StaffSignUp staffSignUp = new StaffSignUp();
        staffSignUp.setVisible(true);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(landingPage);
        frame.dispose();

    }
    public static void main(String[] args){
        new LandingPage();
    }
}


