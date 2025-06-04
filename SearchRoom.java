package HotelManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchRoom extends JFrame implements ItemListener {

    JComboBox searchCombo;
    String selected;
    DBConnection con=null;
    JTable roomList;

    public SearchRoom(){

        setSize(600,300);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/roomImage.jpg"));
        Image img2= img1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel roomImage=new JLabel(img3);
        roomImage.setBounds(0,0,600,400);
        add(roomImage);

        JLabel search=new JLabel("Search");
        search.setBounds(180,20,70,20);
        search.setFont(new Font("sansserif",Font.BOLD,15));
        roomImage.add(search);

        String[] str={
                "Single Bed",
                "Double Bed"
        };
        searchCombo=new JComboBox(str);
        searchCombo.setBounds(250,22,150,19);
        roomImage.add(searchCombo);
        searchCombo.addItemListener(this);

        roomList=new JTable();
        roomList.setFont(new Font("serif",Font.BOLD,13));
        roomList.setForeground(new Color(0,250,0,220));
        roomList.setBackground(new Color(0, 0, 0, 130));
        roomList.setGridColor(Color.BLACK);


        JScrollPane scrollPane = new JScrollPane(roomList);
        scrollPane.setBounds(0, 70, 605, 193);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setIgnoreRepaint(false);
        roomImage.add(scrollPane);

        JTableHeader tableHeader = roomList.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);

        selected=""+searchCombo.getSelectedItem();

        try{
            con=new DBConnection();
            String query1="select * from addrooms where availability='Available' and bed_type='"+selected+"' order by room_no";
            ResultSet rs1=con.st.executeQuery(query1);
            roomList.setModel(DbUtils.resultSetToTableModel(rs1));
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        selected=""+searchCombo.getSelectedItem();
        try{
            con=new DBConnection();
            String query1="select * from addrooms where availability='Available' and bed_type='"+selected+"' order by room_no";
            ResultSet rs1=con.st.executeQuery(query1);
            roomList.setModel(DbUtils.resultSetToTableModel(rs1));
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
    }
}
