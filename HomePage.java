package CustomerGUI;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
    private JPanel homePan;
    private JLabel lblHotel;
    private JPanel reserveInfo;
    public HomePage(){
        super();

        this.setLayout(null);

        homePan = new RoundPanel();
        homePan.setBackground(Color.white);
        homePan.setBounds(140, 80, 700, 500);
        homePan.setLayout(null);
        this.add(homePan);

        reserveInfo = new RoundPanel();
        reserveInfo.setBackground(Color.white);
        reserveInfo.setBounds(100, 210, 500, 100);
        homePan.add(reserveInfo);

        lblHotel = new JLabel("Luton");
        lblHotel.setBounds(20, 5, 140, 50);
        lblHotel.setFont(new Font("Arial", Font.BOLD, 30));
        homePan.add(lblHotel);

        ImageIcon imgBg = new ImageIcon(HomePage.class.getResource("homeIMG.png"));
        JLabel lblImg = new JLabel(imgBg);
        lblImg.setBounds(3, 60, 700, 209);
        homePan.add(lblImg);

        ImageIcon bgImg = new ImageIcon(LoginPage.class.getResource("Desktop.jpg"));
        JLabel imgLbl = new JLabel(bgImg);
        imgLbl.setBounds(0,0,1000,667);
        this.add(imgLbl);
    }
}
