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

public class UpdateCussStatus extends JFrame implements ActionListener {

    private DBConnection con=null;
    private JLabel bgImage;
    private JTextField searchRoom,showName,showPhone,showIdNo,showPaid,showDue,payTF;
    private JTextField pName,pPhone,pIdNo;
    private Choice updateRoomTF;
    private JButton show,update, back;
    private long due;

    public UpdateCussStatus(){
        frameDesign();
        showPartner();
    }    // constructor


    public void frameDesign(){
        setSize(550,500);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/updateStatus.jpg"));
        Image img2=img1.getImage().getScaledInstance(550,500,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        bgImage=new JLabel(img3);
        bgImage.setBounds(0,0,550,500);
        add(bgImage);

        JLabel heading=new JLabel("UPDATE STATUS");
        heading.setBounds(180,25,200,30);
        heading.setForeground(Color.red);
        heading.setFont(new Font("sansserif",Font.BOLD,23));
        bgImage.add(heading);

        JLabel roomNo=new JLabel("Room No");
        roomNo.setBounds(50,80,70,20);
        roomNo.setFont(new Font("sansserif",Font.BOLD,15));
        roomNo.setForeground(Color.black);
        bgImage.add(roomNo);


        searchRoom=new JTextField();
        searchRoom.setBounds(170,80,150,20);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.white);
        searchRoom.setFont(new Font("sansserif",Font.BOLD,12));
        bgImage.add(searchRoom);

        show=new JButton("Show");
        show.setBounds(340,79,80,22);
        show.setFont(new Font("sansserif",Font.BOLD,14));
        show.setForeground(Color.white);
        show.setBackground(Color.BLACK);
        bgImage.add(show);
        show.addActionListener(this);

        JLabel name=new JLabel("Name");
        name.setBounds(50,110,50,20);
        name.setFont(new Font("sansserif",Font.BOLD,15));
        name.setForeground(Color.black);
        bgImage.add(name);

        showName=new JTextField();
        showName.setBounds(170,110,150,20);
        showName.setBackground(Color.BLACK);
        showName.setForeground(Color.white);
        showName.setFont(new Font("sansserif",Font.BOLD,12));
        showName.setEnabled(false);
        bgImage.add(showName);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(50,140,50,20);
        phone.setFont(new Font("sansserif",Font.BOLD,15));
        phone.setForeground(Color.black);
        bgImage.add(phone);

        showPhone=new JTextField();
        showPhone.setBounds(170,140,150,20);
        showPhone.setBackground(Color.BLACK);
        showPhone.setForeground(Color.white);
        showPhone.setFont(new Font("sansserif",Font.BOLD,12));
        showPhone.setEnabled(false);
        bgImage.add(showPhone);

        JLabel idNo=new JLabel("Id no");
        idNo.setBounds(50,170,50,20);
        idNo.setFont(new Font("sansserif",Font.BOLD,15));
        idNo.setForeground(Color.black);
        bgImage.add(idNo);

        showIdNo=new JTextField();
        showIdNo.setBounds(170,170,150,20);
        showIdNo.setBackground(Color.BLACK);
        showIdNo.setForeground(Color.white);
        showIdNo.setFont(new Font("sansserif",Font.BOLD,12));
        showIdNo.setEnabled(false);
        bgImage.add(showIdNo);

        JLabel paid=new JLabel("Paid");
        paid.setBounds(50,200,50,20);
        paid.setFont(new Font("sansserif",Font.BOLD,15));
        paid.setForeground(Color.black);
        bgImage.add(paid);

        showPaid=new JTextField();
        showPaid.setBounds(170,200,150,20);
        showPaid.setBackground(Color.BLACK);
        showPaid.setForeground(Color.white);
        showPaid.setFont(new Font("sansserif",Font.BOLD,12));
        showPaid.setEnabled(false);
        bgImage.add(showPaid);

        JLabel due=new JLabel("Due");
        due.setBounds(50,230,50,20);
        due.setFont(new Font("sansserif",Font.BOLD,15));
        due.setForeground(Color.black);
        bgImage.add(due);

        showDue=new JTextField();
        showDue.setBounds(170,230,150,20);
        showDue.setBackground(Color.BLACK);
        showDue.setForeground(Color.white);
        showDue.setFont(new Font("sansserif",Font.BOLD,12));
        showDue.setEnabled(false);
        bgImage.add(showDue);

        JLabel updateRoom=new JLabel("Update Room");
        updateRoom.setBounds(50,260,100,20);
        updateRoom.setFont(new Font("sansserif",Font.BOLD,15));
        updateRoom.setForeground(Color.black);
        bgImage.add(updateRoom);

        updateRoomTF=new Choice();
        updateRoomTF.setBounds(170,260,150,20);
        updateRoomTF.setBackground(Color.BLACK);
        updateRoomTF.setForeground(Color.white);
        updateRoomTF.setFont(new Font("sansserif",Font.BOLD,12));
        bgImage.add(updateRoomTF);

        JLabel pay=new JLabel("Pay");
        pay.setBounds(50,290,50,20);
        pay.setFont(new Font("sansserif",Font.BOLD,15));
        pay.setForeground(Color.black);
        bgImage.add(pay);

        payTF=new JTextField();
        payTF.setBounds(170,290,150,20);
        payTF.setBackground(Color.BLACK);
        payTF.setForeground(Color.white);
        payTF.setFont(new Font("sansserif",Font.BOLD,12));
        bgImage.add(payTF);

        update=new JButton("UPDATE");
        update.setBounds(55,350,100,28);
        update.setFont(new Font("sansserif",Font.BOLD,14));
        update.setForeground(Color.white);
        update.setBackground(Color.BLACK);
        bgImage.add(update);
        update.addActionListener(this);

        back =new JButton("BACK");
        back.setBounds(200,350,100,28);
        back.setFont(new Font("sansserif",Font.BOLD,14));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        bgImage.add(back);
        back.addActionListener(this);

        setVisible(true);
    }


    public void showPartner(){
        pName=new JTextField();
        pName.setBounds(340,110,150,20);
        pName.setBackground(Color.BLACK);
        pName.setForeground(Color.white);
        pName.setFont(new Font("sansserif",Font.BOLD,12));
        pName.setVisible(false);
        pName.setEnabled(false);
        bgImage.add(pName);

        pPhone=new JTextField();
        pPhone.setBounds(340,140,150,20);
        pPhone.setBackground(Color.BLACK);
        pPhone.setForeground(Color.white);
        pPhone.setFont(new Font("sansserif",Font.BOLD,12));
        pPhone.setVisible(false);
        pPhone.setEnabled(false);
        bgImage.add(pPhone);

        pIdNo=new JTextField();
        pIdNo.setBounds(340,170,150,20);
        pIdNo.setBackground(Color.BLACK);
        pIdNo.setForeground(Color.white);
        pIdNo.setFont(new Font("sansserif",Font.BOLD,12));
        pIdNo.setVisible(false);
        pIdNo.setEnabled(false);
        bgImage.add(pIdNo);
    }

    public void partnerVisiblity(Boolean status){
        pName.setVisible(status);
        pPhone.setVisible(status);
        pIdNo.setVisible(status);
    }

    public void showRooms(String bedType) throws SQLException{
        String query="select room_no from addrooms where availability='Available' and bed_type='"+bedType+"'\n"
                +" union all\n"
                +"select room_no from addrooms where room_no="+Integer.parseInt(searchRoom.getText())+"\n"
                +"order by room_no";

        ResultSet rs=con.st.executeQuery(query);
        while(rs.next()){
            updateRoomTF.add(rs.getString("room_no"));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==show){
            updateRoomTF.removeAll();
            try{

                con=new DBConnection();
                String query="select * from customertable where room_no="+Integer.parseInt(searchRoom.getText());
                ResultSet rs=con.st.executeQuery(query);
                String bedType;
                if(rs.next()){
                    showName.setText(rs.getString("name"));
                    showPhone.setText(rs.getString("phone_no"));
                    showIdNo.setText(rs.getString("id_no"));
                    showPaid.setText(String.valueOf(rs.getInt("deposit")));
                    int paid=rs.getInt("deposit");

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate cin=LocalDate.parse(rs.getString("checkin"),formatter);
                    LocalDate cout=LocalDate.parse(rs.getString("checkout"),formatter);
                    long totaldays= ChronoUnit.DAYS.between(cin, cout);

                    String query2="select * from partnertable where room_no="+Integer.parseInt(searchRoom.getText());
                    ResultSet rs2=con.st.executeQuery(query2);
                    if(rs2.next()){
                        pName.setText(rs2.getString("name"));
                        pPhone.setText(rs2.getString("phone_no"));
                        pIdNo.setText(rs2.getString("id_no"));
                        partnerVisiblity(true);
                    } else{
                        partnerVisiblity(false);
                    }

                    String query3="select price,bed_type from addrooms where room_no="+Integer.parseInt(searchRoom.getText());
                    ResultSet rs3=con.st.executeQuery(query3);
                    rs3.next();
                    int price=rs3.getInt("price");
                    bedType=rs3.getString("bed_type");

                    due=(totaldays*price)-paid;
                    showDue.setText(String.valueOf(due));

                }else{
                    partnerVisiblity(false);
                    JOptionPane.showMessageDialog(null,"room is not occupied");
                    searchRoom.setText("");
                    showName.setText("");
                    showPhone.setText("");
                    showIdNo.setText("");
                    showPaid.setText("");
                    showDue.setText("");
                    return;
                }
                showRooms(bedType);

            }catch(SQLException ex){
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

        else if(e.getSource()==update){
            if(payTF.getText().isEmpty()){
                payTF.setText("0");
            }
            if(due<Long.parseLong(payTF.getText())){
                JOptionPane.showMessageDialog(null,"enter equal amount or less than due");
                return;
            }else{
                try {
                    con = new DBConnection();
                    String query = "update customertable set room_no=" + Integer.parseInt(updateRoomTF.getSelectedItem()) + ",\n"
                            +"deposit=" + (Integer.parseInt(showPaid.getText()) + Integer.parseInt(payTF.getText()))+"\n"
                            +"where room_no="+Integer.parseInt(searchRoom.getText());
                    con.st.executeUpdate(query);

                    String query2="update partnertable set room_no=" + Integer.parseInt(updateRoomTF.getSelectedItem()) + ",\n"
                            +"deposit=" + (Integer.parseInt(showPaid.getText()) + Integer.parseInt(payTF.getText()))+"\n"
                            +"where room_no="+Integer.parseInt(searchRoom.getText());
                    con.st.executeUpdate(query2);

                    String query3="update addrooms set availability='Available' where room_no="+Integer.parseInt(searchRoom.getText());
                    con.st.executeUpdate(query3);

                    String query4="update addrooms set availability='Occupied' where room_no="+Integer.parseInt(updateRoomTF.getSelectedItem());
                    con.st.executeUpdate(query4);

                    JOptionPane.showMessageDialog(null,"update successful");
                    setVisible(false);
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }finally {
                    if(con!=null){
                        try{
                            con.conn.close();
                            System.out.println("DB is disconnected");
                        }catch(SQLException ex){
                            System.out.println("Exception in UpdateStatus in close Db: "+ex.getMessage());
                        }
                    }
                }
            }
        }

        else{
            setVisible(false);
            new AddReception();
        }
    }

}
