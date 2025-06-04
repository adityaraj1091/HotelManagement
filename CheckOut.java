package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CheckOut extends JFrame implements ActionListener {

    private JTextField roomNoField,showName,showPhone,showId,showIdNo,showCheckIn,showDeposit,showRoomPrice,showDue,payField,showCheckOut,showTotalCost;
    private JTextField showPartnername,showPartnerPhone,showPartnerId,showPartnerIdNo;
    private JButton submit,showdetail;
    JLabel bgImage;
    private int roomPrice, deposit;
    private long totaldays;
    private DBConnection con=null;

    public CheckOut(){
        frameDesigh();
        partnerDetail();
        clickButton();
    }

    public void frameDesigh(){

        setSize(600,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/checkOutImage.jpg"));
        Image img2=img1.getImage().getScaledInstance(600,500,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        bgImage=new JLabel(img3);
        bgImage.setBounds(0,0,600,480);
        add(bgImage);

        JLabel roomNo=new JLabel("Room No");
        roomNo.setBounds(70,50,70,20);
        roomNo.setFont(new Font("sansserif",Font.BOLD,15));
        roomNo.setForeground(Color.BLACK);
        bgImage.add(roomNo);

        roomNoField=new JTextField();
        roomNoField.setBounds(200,52,150,20);
        roomNoField.setForeground(Color.white);
        roomNoField.setFont(new Font("sansserrif",Font.BOLD,12));
        roomNoField.setBackground(Color.BLACK);
        bgImage.add(roomNoField);

        showdetail=new JButton("Show");
        showdetail.setBounds(370,50,70,25);
        showdetail.setForeground(Color.white);
        showdetail.setBackground(Color.black);
        bgImage.add(showdetail);


        JLabel name=new JLabel("Name");
        name.setBounds(70,80,70,20);
        name.setFont(new Font("sansserif",Font.BOLD,15));
        name.setForeground(Color.BLACK);
        bgImage.add(name);

        showName= new JTextField();
        showName.setBounds(200,80,150,20);
        showName.setForeground(Color.white);
        showName.setFont(new Font("sansserrif",Font.BOLD,12));
        showName.setBackground(Color.BLACK);
        showName.setEnabled(false);
        bgImage.add(showName);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(70,110,70,20);
        phone.setFont(new Font("sansserif",Font.BOLD,15));
        phone.setForeground(Color.BLACK);
        bgImage.add(phone);

        showPhone=new JTextField();
        showPhone.setBounds(200,110,150,20);
        showPhone.setForeground(Color.white);
        showPhone.setFont(new Font("sansserrif",Font.BOLD,13));
        showPhone.setBackground(Color.BLACK);
        showPhone.setEnabled(false);
        bgImage.add(showPhone);

        JLabel id=new JLabel("Id");
        id.setBounds(70,140,70,20);
        id.setFont(new Font("sansserif",Font.BOLD,15));
        id.setForeground(Color.BLACK);
        bgImage.add(id);

        showId=new JTextField();
        showId.setBounds(200,140,150,20);
        showId.setForeground(Color.white);
        showId.setFont(new Font("sansserrif",Font.BOLD,12));
        showId.setBackground(Color.BLACK);
        showId.setEnabled(false);
        bgImage.add(showId);

        JLabel idNo=new JLabel("Id No");
        idNo.setBounds(70,170,70,20);
        idNo.setFont(new Font("sansserif",Font.BOLD,15));
        idNo.setForeground(Color.BLACK);
        bgImage.add(idNo);

        showIdNo=new JTextField();
        showIdNo.setBounds(200,170,150,20);
        showIdNo.setForeground(Color.white);
        showIdNo.setFont(new Font("sansserrif",Font.BOLD,13));
        showIdNo.setBackground(Color.BLACK);
        showIdNo.setEnabled(false);
        bgImage.add(showIdNo);

        JLabel checkIn=new JLabel("Checkin");
        checkIn.setBounds(70,200,70,20);
        checkIn.setFont(new Font("sansserif",Font.BOLD,15));
        checkIn.setForeground(Color.BLACK);
        bgImage.add(checkIn);

        showCheckIn=new JTextField();
        showCheckIn.setBounds(200,200,150,20);
        showCheckIn.setForeground(Color.white);
        showCheckIn.setFont(new Font("sansserrif",Font.BOLD,13));
        showCheckIn.setBackground(Color.BLACK);
        showCheckIn.setEnabled(false);
        bgImage.add(showCheckIn);

        JLabel checkOut=new JLabel("Checkout");
        checkOut.setBounds(70,230,100,20);
        checkOut.setFont(new Font("sansserif",Font.BOLD,15));
        checkOut.setForeground(Color.BLACK);
        bgImage.add(checkOut);

        showCheckOut=new JTextField();
        showCheckOut.setBounds(200,230,150,20);
        showCheckOut.setForeground(Color.white);
        showCheckOut.setFont(new Font("sansserrif",Font.BOLD,13));
        showCheckOut.setBackground(Color.BLACK);
        bgImage.add(showCheckOut);

        JLabel roomPrice=new JLabel("Room Price");
        roomPrice.setBounds(70,260,100,20);
        roomPrice.setFont(new Font("sansserif",Font.BOLD,15));
        roomPrice.setForeground(Color.BLACK);
        bgImage.add(roomPrice);

        showRoomPrice=new JTextField();
        showRoomPrice.setBounds(200,260,150,20);
        showRoomPrice.setForeground(Color.white);
        showRoomPrice.setFont(new Font("sansserrif",Font.BOLD,13));
        showRoomPrice.setBackground(Color.BLACK);
        showRoomPrice.setEnabled(false);
        bgImage.add(showRoomPrice);

        JLabel totalCost=new JLabel("Total Cost");
        totalCost.setBounds(70,290,100,20);
        totalCost.setFont(new Font("sansserif",Font.BOLD,15));
        totalCost.setForeground(Color.BLACK);
        bgImage.add(totalCost);

        showTotalCost=new JTextField();
        showTotalCost.setBounds(200,290,150,20);
        showTotalCost.setForeground(Color.white);
        showTotalCost.setFont(new Font("sansserrif",Font.BOLD,13));
        showTotalCost.setBackground(Color.BLACK);
        showTotalCost.setEnabled(false);
        bgImage.add(showTotalCost);

        JLabel deposit=new JLabel("Deposit");
        deposit.setBounds(70,320,70,20);
        deposit.setFont(new Font("sansserif",Font.BOLD,15));
        deposit.setForeground(Color.BLACK);
        bgImage.add(deposit);

        showDeposit=new JTextField();
        showDeposit.setBounds(200,320,150,20);
        showDeposit.setForeground(Color.white);
        showDeposit.setFont(new Font("sansserrif",Font.BOLD,13));
        showDeposit.setBackground(Color.BLACK);
        showDeposit.setEnabled(false);
        bgImage.add(showDeposit);

        JLabel due=new JLabel("Due");
        due.setBounds(70,350,70,20);
        due.setFont(new Font("sansserif",Font.BOLD,15));
        due.setForeground(Color.BLACK);
        bgImage.add(due);

        showDue=new JTextField();
        showDue.setBounds(200,350,150,20);
        showDue.setForeground(Color.white);
        showDue.setFont(new Font("sansserrif",Font.BOLD,13));
        showDue.setBackground(Color.BLACK);
        showDue.setEnabled(false);
        bgImage.add(showDue);

        JLabel pay=new JLabel("Pay");
        pay.setBounds(70,380,70,20);
        pay.setFont(new Font("sansserif",Font.BOLD,15));
        pay.setForeground(Color.BLACK);
        bgImage.add(pay);

        payField=new JTextField();
        payField.setBounds(200,380,150,20);
        payField.setForeground(Color.white);
        payField.setFont(new Font("sansserrif",Font.BOLD,13));
        payField.setBackground(Color.BLACK);
        bgImage.add(payField);


        submit=new JButton("Submit");
        submit.setBounds(180,430,100,25);
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        bgImage.add(submit);

        setVisible(true);

    }

    public void clickButton() {
            showdetail.addActionListener(this);
            submit.addActionListener(this);
    }

    public void partnerDetail(){
        showPartnername=new JTextField();
        showPartnername.setBounds(370,80,150,20);
        showPartnername.setForeground(Color.white);
        showPartnername.setFont(new Font("sansserrif",Font.BOLD,12));
        showPartnername.setBackground(Color.BLACK);
        showPartnername.setEnabled(false);
        showPartnername.setVisible(false);
        bgImage.add(showPartnername);

        showPartnerPhone=new JTextField();
        showPartnerPhone.setBounds(370,110,150,20);
        showPartnerPhone.setForeground(Color.white);
        showPartnerPhone.setFont(new Font("sansserrif",Font.BOLD,12));
        showPartnerPhone.setBackground(Color.BLACK);
        showPartnerPhone.setEnabled(false);
        showPartnerPhone.setVisible(false);
        bgImage.add(showPartnerPhone);

        showPartnerId=new JTextField();
        showPartnerId.setBounds(370,140,150,20);
        showPartnerId.setForeground(Color.white);
        showPartnerId.setFont(new Font("sansserrif",Font.BOLD,12));
        showPartnerId.setBackground(Color.BLACK);
        showPartnerId.setEnabled(false);
        showPartnerId.setVisible(false);
        bgImage.add(showPartnerId);

        showPartnerIdNo=new JTextField();
        showPartnerIdNo.setBounds(370,170,150,20);
        showPartnerIdNo.setForeground(Color.white);
        showPartnerIdNo.setFont(new Font("sansserrif",Font.BOLD,12));
        showPartnerIdNo.setBackground(Color.BLACK);
        showPartnerIdNo.setEnabled(false);
        showPartnerIdNo.setVisible(false);
        bgImage.add(showPartnerIdNo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int roomNo=Integer.parseInt(roomNoField.getText());
        if(e.getSource()==showdetail){
            payField.setText("");
            try{
                con = new DBConnection();
                String query1 = "select * from customertable where room_no=" + roomNo;
                String query2 = "select price from addrooms where room_no=" + roomNo;
                String query3 = "select * from partnertable where room_no=" + roomNo;
                ResultSet rs1 = con.st.executeQuery(query1);
                if(rs1.next()) {
                    showName.setText(rs1.getString("name"));
                    showPhone.setText(rs1.getString("phone_no"));
                    showId.setText(rs1.getString("id"));
                    showIdNo.setText(rs1.getString("id_no"));
                    showCheckIn.setText(rs1.getString("checkin"));
                    showDeposit.setText(rs1.getString("deposit"));
                    showCheckOut.setText(rs1.getString("checkout"));
                    deposit = rs1.getInt("deposit");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate cin=LocalDate.parse(rs1.getString("checkin"),formatter);
                    LocalDate cout=LocalDate.parse(rs1.getString("checkout"),formatter);
                    totaldays=ChronoUnit.DAYS.between(cin, cout);
                }else{
                    JOptionPane.showMessageDialog(null,"room is not occupied");
                    resetDetail();
                    return;
                }
                ResultSet rs2 = con.st.executeQuery(query2);
                while (rs2.next()) {
                    showRoomPrice.setText(rs2.getString("price"));
                    roomPrice = rs2.getInt("price");
                }
                ResultSet rs3 = con.st.executeQuery(query3);
                if (rs3.next()) {
                    showPartnername.setVisible(true);
                    showPartnerPhone.setVisible(true);
                    showPartnerId.setVisible(true);
                    showPartnerIdNo.setVisible(true);
                    showPartnername.setText(rs3.getString("name"));
                    showPartnerPhone.setText(rs3.getString("phone_no"));
                    showPartnerId.setText(rs3.getString("id"));
                    showPartnerIdNo.setText(rs3.getString("id_no"));
                } else {
                    showPartnername.setVisible(false);
                    showPartnerPhone.setVisible(false);
                    showPartnerId.setVisible(false);
                    showPartnerIdNo.setVisible(false);
                }
                showDue.setText(String.valueOf((totaldays*roomPrice) - deposit));
                showTotalCost.setText(String.valueOf(totaldays*roomPrice));
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }finally {
                if(con!=null){
                    try{
                        con.conn.close();
                        System.out.println("DB is disconnected");
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }

        else if(e.getSource()==submit){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate cin=LocalDate.parse(showCheckIn.getText(),formatter);
            LocalDate cout=LocalDate.parse(showCheckOut.getText(),formatter);
            totaldays=ChronoUnit.DAYS.between(cin, cout);
            showTotalCost.setText(String.valueOf(totaldays*roomPrice));
            long dues = (roomPrice * totaldays)-deposit;
            showDue.setText(String.valueOf(dues));
            if(dues==0){
                confirmCheckOut(roomNo);
            }else if(payField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"enter payment");
                return;
            }else if(dues == Long.parseLong(payField.getText())) {
                confirmCheckOut(roomNo);
            }else if(dues<Long.parseLong(payField.getText())){
                JOptionPane.showMessageDialog(null,"enter only due amount");
                return;
            }else{
                JOptionPane.showMessageDialog(null,"please clear the payment");
                return;
            }
        }
    }

    public void resetDetail(){
        roomNoField.setText("");
        showName.setText("");
        showPhone.setText("");
        showId.setText("");
        showIdNo.setText("");
        showCheckIn.setText("");
        showCheckOut.setText("");
        showDeposit.setText("");
        showRoomPrice.setText("");
        showName.setText("");
        payField.setText("");
        showDue.setText("");
        showTotalCost.setText("");
        showPartnername.setVisible(false);
        showPartnerPhone.setVisible(false);
        showPartnerIdNo.setVisible(false);
        showPartnerId.setVisible(false);
    }

    public void confirmCheckOut(int roomNo){
        try{
            con=new DBConnection();
            String query1 = "delete from customertable where room_no=" + roomNo;
            String query2 = "delete from partnertable where room_no=" + roomNo;
            String query3 = "update addrooms set availability='Available' where room_no=" + roomNo;
            con.st.executeUpdate(query1);
            con.st.executeUpdate(query2);
            con.st.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"checkout confirmed");
            setVisible(false);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }finally {
            if(con!=null){
                try{
                    con.conn.close();
                    System.out.println("DB is disconnected");
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }


}
