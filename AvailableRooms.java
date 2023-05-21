package CustomerGUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AvailableRooms extends JFrame {

    private JPanel assignWin;
    private DefaultTableModel roomColumn;
    private JTable roomTable;
    private JScrollPane tabPan;
    private JTextField fieldRoomID;
    private JTextField fieldBookingID;
    private JTextField fieldStaffID;
    private JTextField fieldRoomStatus;
    private JTextField fieldRoomType;
    private JTextField fieldRoomDescription;
    private JTextField fieldRoomRate;
    private String roomTyp;
    private JButton btnDone;
    private JButton btnBack;
    private JLabel lblInfo;
    public AvailableRooms(){
        super();

        this.setLayout(null);

        assignWin = new JPanel();
        assignWin.setLayout(null);
        assignWin.setSize(550, 380);
        this.add(assignWin);

        lblInfo = new JLabel("Room available");
        lblInfo.setBounds(200, 5, 200, 20);
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 15));
        assignWin.add(lblInfo);

        roomTyp = UserInput.getRoomType();

        roomColumn = new DefaultTableModel();
        roomColumn.addColumn("roomID");
        roomColumn.addColumn("bookingID");
        roomColumn.addColumn("staffID");
        roomColumn.addColumn("roomStatus");
        roomColumn.addColumn("roomType");

        roomTable = new JTable(roomColumn);

        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT * FROM rooms WHERE roomStatus='available' AND roomType=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, roomTyp);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Object[] row = {rs.getInt("roomID"), rs.getInt("bookingID"), rs.getInt("staffID"), rs.getString("roomStatus"), rs.getString("roomType")};
                roomColumn.addRow(row);
            }

            if(rs==null){
                lblInfo.setText("Sorry! Room not available.");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        tabPan = new JScrollPane(roomTable);
        tabPan.setBounds(20, 30, 500, 215);
        assignWin.add(tabPan);

        btnDone = new AttractiveButton("Done");
        btnDone.setBounds(350, 265, 150, 40);
        btnDone.addActionListener(this::actionPerformed);
        assignWin.add(btnDone);

        btnBack = new AttractiveButton("Back");
        btnBack.setBounds(30, 265, 150, 40);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        assignWin.add(btnBack);

        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setBounds(460, 220, 550, 380);
        this.setTitle("Room Availability");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        ViewBooking viewBooking = new ViewBooking();
        viewBooking.setVisible(true);
        dispose();
//        BookingPage bookingPage = new BookingPage();
//        bookingPage.dispose();
    }

    public  static void main(String[] args){
        new AvailableRooms();
    }
}
