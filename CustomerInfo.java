package HotelManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerInfo extends JFrame {

    JTable customertable;

    public CustomerInfo(){

        setSize(900,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);


        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/customerInfoimage.jpg"));
        Image img2= img1.getImage().getScaledInstance(900,400,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel bgImage=new JLabel(img3);
        bgImage.setBounds(0,0,900,400);
        add(bgImage);

        JLabel heading =new JLabel("Customer Info");
        heading.setBounds(380,15,150,20);
        heading.setFont(new Font("sansserif",Font.BOLD,20));
        heading.setForeground(Color.BLACK);
        bgImage.add(heading);

        customertable=new JTable();
        customertable=new JTable();
        customertable.setFont(new Font("serif",Font.BOLD,13));
        customertable.setForeground(Color.white);
        customertable.setBackground(new Color(0, 0, 0, 170));
        customertable.setGridColor(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(customertable);
        scrollPane.setBounds(0, 70, 890, 290);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setIgnoreRepaint(false);
        bgImage.add(scrollPane);

        JTableHeader tableHeader = customertable.getTableHeader();
        tableHeader.setFont(new Font("sansserif", Font.BOLD, 10));
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);

        DBConnection con=null;

        try{
            con=new DBConnection();
            String query="select room_no,name,gender,phone_no,country,id,id_no,time,checkin,deposit\n"+
                    "from customertable\n"+
                    "union all\n"+
                    "select room_no,name,gender,phone_no,country,id,id_no,time,checkin,deposit\n"+
                    "from partnertable\n"+
                    "order by room_no";
            ResultSet rs=con.st.executeQuery(query);
            customertable.setModel(DbUtils.resultSetToTableModel(rs));
            adjustColumnSize();
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

        setVisible(true);
    }


    private void adjustColumnSize(){
        for(int i=0;i<customertable.getColumnCount();i++){
            String colName=customertable.getColumnName(i).toLowerCase();
            switch(colName){
                case "room_no":
                    customertable.getColumnModel().getColumn(i).setPreferredWidth(30);
                    break;
                case "name":
                    customertable.getColumnModel().getColumn(i).setPreferredWidth(200);
                    break;
                case "gender":
                    customertable.getColumnModel().getColumn(i).setPreferredWidth(60);
                    break;
                case "country":
                    customertable.getColumnModel().getColumn(i).setPreferredWidth(45);
                    break;
                case "id":
                    customertable.getColumnModel().getColumn(i).setPreferredWidth(150);
                    break;
                case "id_no":
                    customertable.getColumnModel().getColumn(i).setPreferredWidth(100);
                    break;

                case "curr_date":
                    customertable.getColumnModel().getColumn(i).setPreferredWidth(70);
                    break;
                case "time":
                    customertable.getColumnModel().getColumn(i).setPreferredWidth(50);
                    break;
                case "deposit":
                    customertable.getColumnModel().getColumn(i).setPreferredWidth(40);
                    break;


            }
        }
    }
}
