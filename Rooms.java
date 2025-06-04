package HotelManagement;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proteanit.sql.*;

public class Rooms extends JFrame {

    public Rooms() {

        setSize(600,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/roomImage.jpg"));
        Image img2= img1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel roomImage=new JLabel(img3);
        roomImage.setBounds(0,0,600,400);
        add(roomImage);

        JLabel available=new JLabel("Available Rooms");
        available.setBounds(220,10,135,20);
        available.setFont(new Font("serif",Font.BOLD,17));
        available.setForeground(Color.black);
        roomImage.add(available);


        JTable ARooms=new JTable();
        ARooms.setFont(new Font("serif",Font.BOLD,13));
        ARooms.setForeground(new Color(0,250,0,220));
        ARooms.setBackground(new Color(0, 0, 0, 130));
        ARooms.setGridColor(Color.BLACK);


        JTableHeader tableHeader1 = ARooms.getTableHeader();
        tableHeader1.setReorderingAllowed(false);
        tableHeader1.setResizingAllowed(false);

        JScrollPane scrollPane1 = new JScrollPane(ARooms);
        scrollPane1.setBounds(0, 35, 605, 130);
        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setOpaque(false);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());
        scrollPane1.setIgnoreRepaint(false);
        roomImage.add(scrollPane1);

        JLabel occupied=new JLabel("Occupied Room");
        occupied.setBounds(220,170,135,20);
        occupied.setFont(new Font("serif",Font.BOLD,17));
        occupied.setForeground(Color.black);
        roomImage.add(occupied);

        JTable ORooms=new JTable();
        ORooms.setFont(new Font("serif",Font.BOLD,13));
        ORooms.setForeground(new Color(250,0,0));
        ORooms.setBackground(new Color(0, 0, 0, 200));
        ORooms.setGridColor(Color.BLACK);


        JTableHeader tableHeader2 = ORooms.getTableHeader();
        tableHeader2.setReorderingAllowed(false);
        tableHeader2.setResizingAllowed(false);

        JScrollPane scrollPane2 = new JScrollPane(ORooms);
        scrollPane2.setBounds(0, 200, 605, 162);
        scrollPane2.setOpaque(false);
        scrollPane2.getViewport().setOpaque(false);
        scrollPane2.setBorder(BorderFactory.createEmptyBorder());
        scrollPane2.setIgnoreRepaint(false);
        roomImage.add(scrollPane2);

        DBConnection con=null;
        try{

            con=new DBConnection();
            String query1="select * from addrooms where Availability='Available' order by room_no";
            ResultSet rs1=con.st.executeQuery(query1);
            ARooms.setModel(DbUtils.resultSetToTableModel(rs1));

            String query2="select * from addrooms where Availability='Occupied' order by room_no";
            ResultSet rs2=con.st.executeQuery(query2);
            ORooms.setModel(DbUtils.resultSetToTableModel(rs2));

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            if(con!=null){
                try{
                    con.conn.close();
                    System.out.println("DB Disconnected Successfully");
                } catch (SQLException ex) {
                    System.out.println("exception in disconnect in AddRooms: "+ex);
                }
            }
        }

        setVisible(true);
    }
}
