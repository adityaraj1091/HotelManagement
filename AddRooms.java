package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class AddRooms extends JFrame implements ActionListener {

    JTextField roomNoTextField,priceTextArea;
    JComboBox availableComboBox,cleaningStatusCombo,bedTypeCombo;
    JButton submit,cancel;

    public AddRooms(){

        setSize(800,500);
        setLocationRelativeTo(null);
        setLayout(null);


        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/roomImage.jpg"));
        Image img2= img1.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel roomImage=new JLabel(img3);
        roomImage.setBounds(0,0,800,500);
        add(roomImage);



        JLabel addRooms=new JLabel("Add Rooms");
        addRooms.setBounds(350,25,150,30);
        addRooms.setFont(new Font("serif",Font.BOLD,25));
        addRooms.setForeground(Color.BLACK);
        roomImage.add(addRooms);

        JLabel roomNumber=new JLabel("Room number");
        roomNumber.setBounds(200,100,110,20);
        roomNumber.setFont(new Font("sansserif",Font.BOLD,15));
        roomNumber.setForeground(Color.BLACK);
        roomImage.add(roomNumber);

        roomNoTextField=new JTextField();
        roomNoTextField.setBounds(350,103,150,20);
        roomImage.add(roomNoTextField);


        JLabel available=new JLabel("Available");
        available.setBounds(200,150,80,20);
        available.setFont(new Font("sansserif",Font.BOLD,15));
        available.setForeground(Color.BLACK);
        roomImage.add(available);

        String str1[]={
                "Select",
                "Available",
                "Occupied"
        };

        availableComboBox=new JComboBox(str1);
        availableComboBox.setBounds(350,153,150,20);
        roomImage.add(availableComboBox);


        JLabel cleaningStatus=new JLabel("Cleaning Status");
        cleaningStatus.setBounds(200,200,120,20);
        cleaningStatus.setFont(new Font("sansserif",Font.BOLD,15));
        cleaningStatus.setForeground(Color.BLACK);
        roomImage.add(cleaningStatus);

        String str2[]={
                "Select",
                "Cleaned",
                "Dirty"
        };

        cleaningStatusCombo=new JComboBox(str2);
        cleaningStatusCombo.setBounds(350,203,150,20);
        roomImage.add(cleaningStatusCombo);




        JLabel price=new JLabel("Price");
        price.setBounds(200,250,50,20);
        price.setFont(new Font("sansserif",Font.BOLD,15));
        price.setForeground(Color.BLACK);
        roomImage.add(price);

        priceTextArea=new JTextField();
        priceTextArea.setBounds(350,253,150,20);
        roomImage.add(priceTextArea);



        JLabel bedType=new JLabel("Bed Type");
        bedType.setBounds(200,300,100,20);
        bedType.setFont(new Font("sansserif",Font.BOLD,15));
        bedType.setForeground(Color.black);

        roomImage.add(bedType);

        String str3[]={
                "Select",
                "Single Bed",
                "Double Bed",
                "for family"
        };

        bedTypeCombo=new JComboBox(str3);
        bedTypeCombo.setBounds(350,303,150,20);
        roomImage.add(bedTypeCombo);


        submit=new JButton("Add Rooms");
        submit.setBounds(210,370,120,30);
        submit.setFont(new Font("serif",Font.PLAIN,16));
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        roomImage.add(submit);
        submit.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBounds(370,370,120,30);
        cancel.setFont(new Font("serif",Font.PLAIN,16));
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        roomImage.add(cancel);
        cancel.addActionListener(this);





        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==submit) {

            String str = "";

            int roomno;
            str = roomNoTextField.getText();
            if (str.equals("")) {
                JOptionPane.showMessageDialog(null, "enter room no");
                return;
            } else {
                roomno = Integer.parseInt(roomNoTextField.getText());
            }

            String available;
            str = (String) availableComboBox.getItemAt(availableComboBox.getSelectedIndex());
            if (str.equals("Select")) {
                JOptionPane.showMessageDialog(null, "enter available rooms");
                return;
            } else {
                available = (String) availableComboBox.getItemAt(availableComboBox.getSelectedIndex());
            }

            String cleaningStatus;
            str = (String) cleaningStatusCombo.getItemAt(cleaningStatusCombo.getSelectedIndex());
            if (str.equals("Select")) {
                JOptionPane.showMessageDialog(null, "enter cleaning status");
                return;
            } else {
                cleaningStatus = (String) cleaningStatusCombo.getItemAt(cleaningStatusCombo.getSelectedIndex());
            }

            int price;
            str = priceTextArea.getText();
            if (str.equals("")) {
                JOptionPane.showMessageDialog(null, "enter price");
                return;
            } else {
                price = Integer.parseInt(priceTextArea.getText());
            }


            String bedType;
            str = (String) bedTypeCombo.getItemAt(bedTypeCombo.getSelectedIndex());
            if (str.equals("Select")) {
                JOptionPane.showMessageDialog(null, "enter bed type");
                return;
            } else {
                bedType = (String) bedTypeCombo.getItemAt(bedTypeCombo.getSelectedIndex());
            }

            DBConnection con=null;
            try {
                con = new DBConnection();
                String query = "insert into addrooms values(" + roomno + ",'" + available + "','" + cleaningStatus + "'," + price + ",'" + bedType + "')";
                con.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Room Added Successfully");
                setVisible(false);

            }catch(SQLIntegrityConstraintViolationException ex){
                JOptionPane.showMessageDialog(null, "this room no is exist");
                System.out.println(ex.getMessage());
            }catch(SQLException ex){
                System.out.println("exception in AddRooms: "+ex);
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

        }else{
            setVisible(false);
        }

    }

}
