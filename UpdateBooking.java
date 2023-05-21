package CustomerGUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;

public class UpdateBooking extends JFrame {
    private JPanel updateBook;
    private DefaultTableModel updateColum;
    private JTable updateTable;
    private JTextField fieldcuID;
    private JLabel lblCheckIn;
    private JTextField fieldCheckIn;
    private  JLabel lblCheckOut;
    private JTextField fieldCheckOut;
    private JLabel lblRoom;
    private JTextField fieldRoom;
    private JLabel lblGuest;
    private JTextField fieldGuest;
    private JLabel lblRoomTyp;
    private JTextField fieldRoomTyp;
    private JLabel lblComment;
    private JTextField fieldComments;
    private JLabel lblBookStat;
    private JComboBox fieldBookingStat;
    private JScrollPane tabScroll;
    private JButton btnBack;
    private JButton btnUpdate;
    private JTextField fieldID;
    public UpdateBooking(){
        super();
        this.setLayout(null);

        updateBook = new JPanel();
        updateBook.setSize(550, 500);
        updateBook.setLayout(null);
        this.add(updateBook);

        updateColum = new DefaultTableModel();
        updateColum.addColumn("bookingID");
        updateColum.addColumn("checkInDate");
        updateColum.addColumn("checkOutDate");
        updateColum.addColumn("noOfRooms");
        updateColum.addColumn("noOfGuests");
        updateColum.addColumn("roomType");
        updateColum.addColumn("comments");
        updateColum.addColumn("bookingStatus");

        updateTable = new JTable(updateColum);

        String email = UserInput.getEmail();
        String ID = userDetail.getID(email);
        fieldcuID = new JTextField(ID);
        System.out.println(ID);
        String cid = fieldcuID.getText();
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
            String sql = "SELECT bookingID, checkInDate, checkOutDate, noOfRooms, noOfGuests, roomType, comments, bookingStatus FROM bookings WHERE customerID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cid);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Object[] row = {rs.getInt("bookingID"), rs.getDate("checkInDate"), rs.getDate("checkOutDate"), rs.getInt("noOfRooms"), rs.getInt("noOfGuests"), rs.getString("roomType"), rs.getString("comments"), rs.getString("bookingStatus")};
                updateColum.addRow(row);
            }

        }catch (SQLException ec){
            ec.printStackTrace();
        }

        updateTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int rowIndex = updateTable.getSelectedRow();

                if(rowIndex >= 0){
                    int bookingID = Integer.parseInt(updateTable.getValueAt(rowIndex, 0).toString());
                    String checkInDate = updateTable.getValueAt(rowIndex, 1).toString();
                    String checkOutDate = updateTable.getValueAt(rowIndex, 2).toString();
                    int noOfRooms = Integer.parseInt(updateTable.getValueAt(rowIndex, 3).toString());
                    int noOfGuest = Integer.parseInt(updateTable.getValueAt(rowIndex, 4).toString());
                    String roomTyp = updateTable.getValueAt(rowIndex, 5).toString();
                    String comm = updateTable.getValueAt(rowIndex, 6).toString();
                    String bookStat = updateTable.getValueAt(rowIndex, 7).toString();

                    fieldID.setText(String.valueOf(bookingID));
                    fieldCheckIn.setText(String.valueOf(checkInDate));
                    fieldCheckOut.setText(String.valueOf(checkOutDate));
                    fieldRoom.setText(String.valueOf(noOfRooms));
                    fieldGuest.setText(String.valueOf(noOfGuest));
                    fieldRoomTyp.setText(String.valueOf(roomTyp));
                    fieldComments.setText(comm);
                    fieldBookingStat.setSelectedItem(bookStat);
                }
            }
        });

        tabScroll = new JScrollPane(updateTable);
        tabScroll.setBounds(10, 20, 520, 200);
        updateBook.add(tabScroll);

        fieldID = new JTextField();
        updateBook.add(fieldID);

        lblCheckIn = new JLabel("Check In Date");
        lblCheckIn.setBounds(15, 230, 100, 40);
        updateBook.add(lblCheckIn);

        fieldCheckIn = new JTextField();
        fieldCheckIn.setBounds(15, 270, 80, 30);
        updateBook.add(fieldCheckIn);

        lblCheckOut = new JLabel("Check Out Date");
        lblCheckOut.setBounds(130, 230, 100, 40);
        updateBook.add(lblCheckOut);

        fieldCheckOut = new JTextField();
        fieldCheckOut.setBounds(130, 270, 80, 30);
        updateBook.add(fieldCheckOut);

        lblRoom = new JLabel("No of Rooms");
        lblRoom.setBounds(245, 230, 100, 40);
        updateBook.add(lblRoom);

        fieldRoom = new JTextField();
        fieldRoom.setBounds(245, 270, 80, 30);
        updateBook.add(fieldRoom);

        lblGuest = new JLabel("No of Guests");
        lblGuest.setBounds(360, 230, 100, 40);
        updateBook.add(lblGuest);

        fieldGuest = new JTextField();
        fieldGuest.setBounds(360, 270, 80, 30);
        updateBook.add(fieldGuest);

        lblRoomTyp = new JLabel("Room Type");
        lblRoomTyp.setBounds(15, 310, 100, 40);
        updateBook.add(lblRoomTyp);

        fieldRoomTyp = new JTextField();
        fieldRoomTyp.setBounds(15, 350, 80, 30);
        updateBook.add(fieldRoomTyp);

        lblComment = new JLabel("Comments");
        lblComment.setBounds(130, 310, 100, 40);
        updateBook.add(lblComment);

        fieldComments = new JTextField();
        fieldComments.setBounds(130, 350, 80, 30);
        updateBook.add(fieldComments);

        lblBookStat = new JLabel("Booking Status");
        lblBookStat.setBounds(245, 310, 100, 40);
        updateBook.add(lblBookStat);

        String[] stat = {"cancel", "confirm"};
        fieldBookingStat = new JComboBox(stat);
        fieldBookingStat.setBounds(245, 350, 80, 30);
        updateBook.add(fieldBookingStat);

        btnBack = new AttractiveButton("Back");
        btnBack.setBounds(30, 400, 100, 40);
//        btnBack.addActionListener(this::actionPerformed);
        updateBook.add(btnBack);

        btnUpdate = new AttractiveButton("Update");
        btnUpdate.setBounds(300, 400, 100, 40);
        btnUpdate.addActionListener(this::actionPerformed);
        updateBook.add(btnUpdate);

        this.setResizable(false);
        this.setSize(550, 500);
        this.setTitle("Assign Room");
        this.setLocation(450, 200);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String Id = fieldID.getText();
        String checkD = fieldCheckIn.getText();
        String checkDO = fieldCheckOut.getText();
        String nRoom = fieldRoom.getText();
        String noGuest = fieldGuest.getText();
        String rmTyp = fieldRoomTyp.getText();
        String cmm = fieldComments.getText();
        String bkStat = fieldBookingStat.getSelectedItem().toString();
        if (Id.isEmpty() || checkD.isEmpty() || checkDO.isEmpty() || nRoom.isEmpty() || noGuest.isEmpty() || rmTyp.isEmpty() || cmm.isEmpty() || bkStat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Filled cannot be empty");
        } else {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbookingsystem", "root", "");
                String sql = "UPDATE bookings set checkInDate=?, checkOutDate=?, noOfRooms=?, noOfGuests=?, roomType=?, comments=?, bookingStatus=? WHERE bookingID=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, checkD);
                statement.setString(2, checkDO);
                statement.setString(3, nRoom);
                statement.setString(4, noGuest);
                statement.setString(5, rmTyp);
                statement.setString(6, cmm);
                statement.setString(7, bkStat);
                statement.setString(8, Id);
                int rowsAffected = statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Updated sucessfuly");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Updation Failed");
            }
        }
    }

    public static void main(String[] args){
        new UpdateBooking();
    }
}
