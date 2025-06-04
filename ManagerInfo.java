package HotelManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerInfo extends JFrame {



    public ManagerInfo(){

        setSize(700,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);


        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/employeeInfo.jpg"));
        Image img2= img1.getImage().getScaledInstance(700,400,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel bgImage=new JLabel(img3);
        bgImage.setBounds(0,0,700,400);
        add(bgImage);

        JLabel heading=new JLabel("Manager Info");
        heading.setBounds(280,15,130,20);
        heading.setFont(new Font("sansserif",Font.BOLD,18));
        heading.setForeground(Color.RED);
        bgImage.add(heading);


        JTable managerTable =new JTable();
        managerTable.setFont(new Font("serif",Font.BOLD,13));
        managerTable.setForeground(Color.white);
        managerTable.setBackground(new Color(0, 0, 0, 170));
        managerTable.setGridColor(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(managerTable);
        scrollPane.setBounds(0, 70, 705, 292);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setIgnoreRepaint(false);
        bgImage.add(scrollPane);

        JTableHeader tableHeader = managerTable.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);

        DBConnection con=null;
        try{

            con=new DBConnection();
            String query1="select * from employeetable where job = MANAGER";
            ResultSet rs1=con.st.executeQuery(query1);
            managerTable.setModel(DbUtils.resultSetToTableModel(rs1));

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
