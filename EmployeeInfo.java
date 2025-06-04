package HotelManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeInfo extends JFrame implements ItemListener{


    JComboBox searchCombo;

    String selected;

    JTable employeeTable;

    DBConnection con=null;


    public EmployeeInfo(){

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

        JLabel search=new JLabel("Search");
        search.setBounds(200,30,70,20);
        search.setFont(new Font("sansserif",Font.BOLD,15));
        bgImage.add(search);


        String[] str={
                "Front Desk Clerk",
                "Porters",
                "Housekeeping",
                "Kitchen Staff",
                "Room Service",
                "Chefs",
                "Waiter/Waitress",
                "Manager"
        };

        searchCombo=new JComboBox(str);
        searchCombo.setBounds(270,33,150,20);
        bgImage.add(searchCombo);
        searchCombo.addItemListener(this);


        selected= ""+searchCombo.getSelectedItem();

        employeeTable=new JTable();
        employeeTable.setFont(new Font("serif",Font.BOLD,13));
        employeeTable.setForeground(Color.white);
        employeeTable.setBackground(new Color(0, 0, 0, 170));
        employeeTable.setGridColor(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBounds(0, 70, 705, 320);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setIgnoreRepaint(false);
        bgImage.add(scrollPane);

        JTableHeader tableHeader = employeeTable.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);

        try{

            con=new DBConnection();
            String query1="select * from employeetable where job='"+selected+"'";
            ResultSet rs1=con.st.executeQuery(query1);
            employeeTable.setModel(DbUtils.resultSetToTableModel(rs1));

            adjustColumnWidths();

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

        if(e.getStateChange()==ItemEvent.SELECTED){
            selected = String.valueOf(searchCombo.getSelectedItem());
            try{

                con=new DBConnection();
                String query1="select * from employeetable where job='"+selected+"'";
                ResultSet rs1=con.st.executeQuery(query1);
                employeeTable.setModel(DbUtils.resultSetToTableModel(rs1));

                adjustColumnWidths();

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


    private void adjustColumnWidths() {
        for (int i = 0; i < employeeTable.getColumnCount(); i++) {
            String columnName = employeeTable.getColumnName(i).toLowerCase();

            switch (columnName) {
                case "name":
                    employeeTable.getColumnModel().getColumn(i).setPreferredWidth(60);
                    break;
                case "age":
                    employeeTable.getColumnModel().getColumn(i).setPreferredWidth(10);
                    break;
                case "gender":
                    employeeTable.getColumnModel().getColumn(i).setPreferredWidth(30);
                    break;
                case "job":
                    employeeTable.getColumnModel().getColumn(i).setPreferredWidth(80);
                    break;
                case "salary":
                    employeeTable.getColumnModel().getColumn(i).setPreferredWidth(30);
                    break;
                case "phone":
                    employeeTable.getColumnModel().getColumn(i).setPreferredWidth(60);
                    break;
                case "email":
                    employeeTable.getColumnModel().getColumn(i).setPreferredWidth(90);
                    break;
                case "aadhar":
                    employeeTable.getColumnModel().getColumn(i).setPreferredWidth(70);
                    break;
            }
        }
    }


}
