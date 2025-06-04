package HotelManagement;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateRoomStatus extends JFrame implements ActionListener {

    private JTable roomTable;
    private JTextField roomNoTF;
    private JComboBox statusTF;
    private JButton submit,back;
    private DBConnection con=null;

    public UpdateRoomStatus(){
        designFrame();
    }

    public void designFrame(){
        setSize(400,450);
        setLocationRelativeTo(null);
        setResizable(false);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/updateStatus.jpg"));
        Image img2= img1.getImage().getScaledInstance(400,450,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel roomImage=new JLabel(img3);
        roomImage.setBounds(0,0,400,450);
        add(roomImage);

        roomTable=new JTable();
        roomTable.setFont(new Font("serif",Font.BOLD,13));
        roomTable.setForeground(Color.white);
        roomTable.setBackground(new Color(0, 0, 0, 130));
        roomTable.setGridColor(Color.BLACK);


        JTableHeader tableHeader1 = roomTable.getTableHeader();
        tableHeader1.setReorderingAllowed(false);
        tableHeader1.setResizingAllowed(false);

        JScrollPane scrollPane1 = new JScrollPane(roomTable);
        scrollPane1.setBounds(90, 35, 200, 200);
        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setOpaque(false);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());
        scrollPane1.setIgnoreRepaint(false);
        roomImage.add(scrollPane1);

        try{

            con=new DBConnection();
            String query1="select room_no,clean_status from addrooms where clean_status='Dirty' order by room_no";
            ResultSet rs1=con.st.executeQuery(query1);
            roomTable.setModel(DbUtils.resultSetToTableModel(rs1));

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

        JLabel roomNo=new JLabel("Room No");
        roomNo.setBounds(70,265,70,20);
        roomNo.setFont(new Font("sansserif",Font.BOLD,15));
        roomNo.setForeground(Color.BLACK);
        roomImage.add(roomNo);

        roomNoTF=new JTextField();
        roomNoTF.setBounds(160,265,150,20);
        roomImage.add(roomNoTF);

        JLabel status=new JLabel("Status");
        status.setBounds(70,300,70,20);
        status.setFont(new Font("sansserif",Font.BOLD,15));
        status.setForeground(Color.BLACK);
        roomImage.add(status);

        String[] str={
                "Select",
                "Cleaned",
                "Dirty"
        };

        statusTF=new JComboBox(str);
        statusTF.setBounds(160,300,150,20);
        roomImage.add(statusTF);

        submit=new JButton("Submit");
        submit.setBounds(70,350,100,25);
        submit.setFont(new Font("sansserif",Font.BOLD,12));
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        roomImage.add(submit);
        submit.addActionListener(this);

        back=new JButton("Back");
        back.setBounds(210,350,100,25);
        back.setFont(new Font("sansserif",Font.BOLD,12));
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        roomImage.add(back);
        back.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){

            if(roomNoTF.getText().equals("")){
                JOptionPane.showMessageDialog(null,"enter room no");
                return;
            }
            if(statusTF.getSelectedItem().equals("Select")){
                JOptionPane.showMessageDialog(null,"select status");
                return;
            }
            try {
                con=new DBConnection();

                String query1="select room_no from addrooms where room_no="+Integer.parseInt(roomNoTF.getText());
                ResultSet rs1=con.st.executeQuery(query1);
                if(!rs1.next()){
                    JOptionPane.showMessageDialog(null,"room no does not exist");
                    return;
                }
                String query2 = "update addrooms set clean_status='" + statusTF.getSelectedItem() + "' where room_no=" + Integer.parseInt(roomNoTF.getText());
                con.st.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"update successfull");
                String query3="select room_no,clean_status from addrooms where clean_status='Dirty' order by room_no";
                ResultSet rs2=con.st.executeQuery(query3);
                roomTable.setModel(DbUtils.resultSetToTableModel(rs2));
                roomNoTF.setText("");
                statusTF.setSelectedIndex(0);
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }finally {
                if(con!=null){
                    try{
                        con.conn.close();
                        System.out.println("DB is Disconnected");
                    }catch (SQLException ex){
                        System.out.println(ex.getMessage());
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
