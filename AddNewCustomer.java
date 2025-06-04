package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AddNewCustomer extends JFrame implements ActionListener,ItemListener{

    JLabel timeTextField,price;
    JTextField nameField, countryField, idNumberField, numberField, depositField,checkoutField;
    JTextField nameField2,countryField2,idNumberField2,numberField2;
    JRadioButton male, female,male2,female2;
    ButtonGroup genderGroup,genderGroup2;
    JComboBox idCombo, roomTypeField,idCombo2;
    Choice roomChoice;
    JButton submit, back;
    JLabel heading2,name2,gender2,country2,id2,idNumber2,number2;

    int[] chooseRoom;

    public AddNewCustomer() {

        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Add New Customer");
        heading.setBounds(130, 10, 200, 30);
        heading.setForeground(Color.red);
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(heading);


        heading2 = new JLabel("Add  Partner");
        heading2.setBounds(500, 10, 200, 30);
        heading2.setForeground(Color.red);
        heading2.setFont(new Font("Raleway", Font.BOLD, 20));
        heading2.setVisible(false);
        add(heading2);


        JLabel name = new JLabel("<html>Name<font color='red' size=5>*<font/></html>");
        name.setBounds(50, 50, 60, 20);
        name.setFont(new Font("sansserif", Font.BOLD, 13));
        add(name);

        nameField = new JTextField();
        nameField.setBounds(170, 53, 150, 20);
        add(nameField);

        name2=new JLabel("<html>Name<font color='red' size=5>*<font/></html>");
        name2.setBounds(420, 50, 60, 20);
        name2.setFont(new Font("sansserif", Font.BOLD, 13));
        name2.setVisible(false);
        add(name2);

        nameField2 = new JTextField();
        nameField2.setBounds(540, 53, 150, 20);
        nameField2.setVisible(false);
        add(nameField2);

        JLabel gender = new JLabel("<html>Gender<font color='red' size=5>*<font/></html>");
        gender.setBounds(50, 85, 80, 20);
        gender.setFont(new Font("sansserif", Font.BOLD, 13));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(170, 88, 53, 20);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(250, 88, 70, 20);
        female.setBackground(Color.WHITE);
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        gender2 = new JLabel("<html>Gender<font color='red' size=5>*<font/></html>");
        gender2.setBounds(420, 85, 80, 20);
        gender2.setFont(new Font("sansserif", Font.BOLD, 13));
        gender2.setVisible(false);
        add(gender2);

        male2 = new JRadioButton("Male");
        male2.setBounds(540, 88, 53, 20);
        male2.setBackground(Color.WHITE);
        male2.setVisible(false);
        add(male2);

        female2 = new JRadioButton("Female");
        female2.setBounds(620, 88, 70, 20);
        female2.setBackground(Color.WHITE);
        female2.setVisible(false);
        add(female2);

        genderGroup2 = new ButtonGroup();
        genderGroup2.add(male);
        genderGroup2.add(female);

        JLabel number = new JLabel("<html>Phone no<font color='red' size=5>*<font/></html>");
        number.setBounds(50, 120, 80, 20);
        number.setFont(new Font("sansserif", Font.BOLD, 13));
        add(number);

        number2=new JLabel("Phone no");
        number2.setBounds(420, 120, 80, 20);
        number2.setFont(new Font("sansserif", Font.BOLD, 13));
        number2.setVisible(false);
        add(number2);

        numberField = new JTextField();
        numberField.setBounds(170, 123, 150, 20);
        add(numberField);

        numberField2 = new JTextField();
        numberField2.setBounds(540, 123, 150, 20);
        numberField2.setVisible(false);
        add(numberField2);

        JLabel country = new JLabel("<html>Country<font color='red' size=5>*<font/></html>");
        country.setBounds(50, 155, 80, 20);
        country.setFont(new Font("sansserif", Font.BOLD, 13));
        add(country);

        countryField = new JTextField();
        countryField.setBounds(170, 158, 150, 20);
        add(countryField);

        country2 = new JLabel("<html>Country<font color='red' size=5>*<font/></html>");
        country2.setBounds(420, 155, 80, 20);
        country2.setFont(new Font("sansserif", Font.BOLD, 13));
        country2.setVisible(false);
        add(country2);

        countryField2 = new JTextField();
        countryField2.setBounds(540, 158, 150, 20);
        countryField2.setVisible(false);
        add(countryField2);

        JLabel id = new JLabel("<html>ID<font color='red' size=5>*<font/></html>");
        id.setBounds(50, 190, 30, 20);
        id.setFont(new Font("sansserif", Font.BOLD, 13));
        add(id);

        String[] str1 = {
                "Select",
                "Aadhar card",
                "Passport",
                "Driving Lisence",
                "Voter-id card"
        };

        idCombo = new JComboBox(str1);
        idCombo.setBounds(170, 193, 150, 20);
        idCombo.setBackground(Color.WHITE);
        add(idCombo);

        id2 = new JLabel("<html>ID<font color='red' size=5>*<font/></html>");
        id2.setBounds(420, 190, 30, 20);
        id2.setFont(new Font("sansserif", Font.BOLD, 13));
        id2.setVisible(false);
        add(id2);

        idCombo2 = new JComboBox(str1);
        idCombo2.setBounds(540, 193, 150, 20);
        idCombo2.setBackground(Color.WHITE);
        idCombo2.setVisible(false);
        add(idCombo2);

        JLabel idNumber = new JLabel("<html>ID Number<font color='red' size=5>*<font/></html>");
        idNumber.setBounds(50, 235, 80, 20);
        idNumber.setFont(new Font("sansserif", Font.BOLD, 13));
        add(idNumber);

        idNumberField = new JTextField();
        idNumberField.setBounds(170, 238, 150, 20);
        add(idNumberField);

        idNumber2 = new JLabel("<html>ID Number<font color='red' size=5>*<font/></html>");
        idNumber2.setBounds(420, 235, 80, 20);
        idNumber2.setFont(new Font("sansserif", Font.BOLD, 13));
        idNumber2.setVisible(false);
        add(idNumber2);

        idNumberField2 = new JTextField();
        idNumberField2.setBounds(540, 238, 150, 20);
        idNumberField2.setVisible(false);
        add(idNumberField2);


        JLabel roomType = new JLabel("<html>Room Type<font color='red' size=5>*<font/></html>");
        roomType.setBounds(50, 270, 80, 20);
        roomType.setFont(new Font("sansserif", Font.BOLD, 13));
        add(roomType);

        String[] str2 = {
                "Single Bed",
                "Double Bed"
        };

        roomTypeField = new JComboBox(str2);
        roomTypeField.setBounds(170, 273, 150, 20);
        add(roomTypeField);
        roomTypeField.addItemListener(this);


        JLabel roomNumber = new JLabel("<html>Room Number<font color='red' size=5>*<font/></html>");
        roomNumber.setBounds(50, 310, 100, 20);
        roomNumber.setFont(new Font("sansserif", Font.BOLD, 13));
        add(roomNumber);

        roomChoice = new Choice();
        DBConnection con = null;
        try {
            con = new DBConnection();
            String query = "select * from addrooms where availability ='Available' and bed_type='" + roomTypeField.getSelectedItem() + "' order by room_no asc";
            ResultSet rs = con.st.executeQuery(query);
            while (rs.next()) {
                roomChoice.add(rs.getString("room_no"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (con != null) {
                try {
                    con.conn.close();
                    System.out.println("db disconnected");
                } catch (SQLException e) {
                    System.out.println("Exception in addNewCustomer in close Db: " + e);
                }
            }
        }

        roomChoice.setBounds(170, 313, 150, 20);
        add(roomChoice);

        JLabel roomPrice = new JLabel("Room Price");
        roomPrice.setBounds(50, 350, 80, 20);
        roomPrice.setFont(new Font("sansserif", Font.BOLD, 13));
        add(roomPrice);

        chooseRoom = new int[1];
        chooseRoom[0] = Integer.parseInt(roomChoice.getSelectedItem());
        price = new JLabel("");
        price.setBounds(170, 353, 80, 20);
        price.setFont(new Font("sansserif", Font.BOLD, 13));
        add(price);

        try {
            con = new DBConnection();
            chooseRoom[0] = Integer.parseInt(roomChoice.getSelectedItem());
            String query = "select price from addrooms where room_no=" + chooseRoom[0];
            ResultSet rs = con.st.executeQuery(query);
            while (rs.next()) {
                price.setText(rs.getString("price"));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (con != null) {
                try {
                    con.conn.close();
                    System.out.println("db disconnected");
                } catch (SQLException e) {
                    System.out.println("Exception in addNewCustomer in close Db: " + e);
                }
            }
        }


        roomChoice.addItemListener(this);


        JLabel time = new JLabel("Checkin time");
        time.setBounds(50, 390, 80, 20);
        time.setFont(new Font("sansserif", Font.BOLD, 13));
        add(time);

        Date d1 = new Date();

        timeTextField = new JLabel("" + d1);
        timeTextField.setBounds(170, 393, 190, 20);
        timeTextField.setFont(new Font("sansserif", Font.BOLD, 12));
        add(timeTextField);

        JLabel checkOut=new JLabel("checkout");
        checkOut.setBounds(50, 430, 80, 20);
        checkOut.setFont(new Font("sansserif", Font.BOLD, 13));
        add(checkOut);

        checkoutField=new JTextField();
        checkoutField.setBounds(170, 433, 150, 20);
        add(checkoutField);

        JLabel format=new JLabel("(DD/MM/YYYY)");
        format.setBounds(330,430,90,20);
        add(format);

        JLabel deposit = new JLabel("<html>Deposit<font color='red' size=5>*<font/></html>");
        deposit.setBounds(50, 470, 80, 20);
        deposit.setFont(new Font("sansserif", Font.BOLD, 13));
        add(deposit);

        depositField = new JTextField();
        depositField.setBounds(170, 473, 150, 20);
        add(depositField);

        submit = new JButton("Submit");
        submit.setBounds(70, 510, 80, 24);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        add(submit);

        back = new JButton("Back");
        back.setBounds(230, 510, 80, 24);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        add(back);


        submit.addActionListener(this);

        back.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if(e.getSource()==roomTypeField) {

            visiblity();

            roomChoice.removeAll();
            DBConnection con = null;
            try {
                con = new DBConnection();
                String query = "select * from addrooms where availability ='Available' and bed_type='" + roomTypeField.getSelectedItem() + "' order by room_no asc";
                ResultSet rs = con.st.executeQuery(query);
                while (rs.next()) {
                    roomChoice.add(rs.getString("room_no"));
                }
                price.setText("");
                if(rs!=null) {
                    chooseRoom[0] = Integer.parseInt(roomChoice.getItem(roomChoice.getSelectedIndex()));
                    String query1 = "select price from addrooms where room_no=" + chooseRoom[0];
                    ResultSet rs2 = con.st.executeQuery(query1);
                    while (rs2.next()) {
                        price.setText(rs2.getString("price"));
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("no room available for this type of room");
            } finally {
                if (con != null) {
                    try {
                        con.conn.close();
                        System.out.println("db disconnected");
                    } catch (SQLException ex) {
                        System.out.println("Exception in itemStateChanged: " + ex);
                    }
                }
            }
        }
        else if(e.getSource()==roomChoice) {
            DBConnection con = null;
            try {
                con = new DBConnection();
                chooseRoom[0] = Integer.parseInt(roomChoice.getItem(roomChoice.getSelectedIndex()));
                String query1 = "select price from addrooms where room_no=" + chooseRoom[0];
                ResultSet rs = con.st.executeQuery(query1);
                while (rs.next()) {
                    price.setText(rs.getString("price"));
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } finally {
                if (con != null) {
                    try {
                        con.conn.close();
                        System.out.println("db disconnected");
                    } catch (SQLException ex) {
                        System.out.println("Exception in itemStateChanged: " + ex);
                    }
                }
        }
    }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==submit){

            String str;

            str=nameField.getText();
            if(str.isEmpty()){
                JOptionPane.showMessageDialog(null,"enter customer name");
                return;
            }
            else if(!str.contains(" ")){
                JOptionPane.showMessageDialog(null,"enter customer surname");
                return;
            }
            else if(str.contains(" ")){
                int index=str.indexOf(" ");
                if(str.length()<=index+1){
                    JOptionPane.showMessageDialog(null,"enter customer surname");
                    return;
                }
            }


            str="";
            if(male.isSelected())
                str="Male".toUpperCase();
            else if(female.isSelected())
                str="Female".toUpperCase();
            if(str.isEmpty()){
                JOptionPane.showMessageDialog(null,"select customer gender");
                return;
            }


            str=numberField.getText();
            if(str.isEmpty()){
                JOptionPane.showMessageDialog(null,"enter customer phone no");
                return;
            }
            if(str.indexOf('0')==0){
                JOptionPane.showMessageDialog(null,"enter customer's valid phone no");
                return;
            }
            if(str.length()!=10){
                JOptionPane.showMessageDialog(null,"enter customer's valid phone no");
                return;
            }



            str=countryField.getText();
            if(str.isEmpty()){
                JOptionPane.showMessageDialog(null,"enter customer's country name");
                return;
            }


            str=""+idCombo.getItemAt(idCombo.getSelectedIndex());
            if(str.equals("Select")){
                JOptionPane.showMessageDialog(null,"select customer's id option");
                return;
            }

            str=idNumberField.getText();
            if(str.isEmpty()){
                JOptionPane.showMessageDialog(null,"enter customer's id number");
                return;
            }

            str=checkoutField.getText();
            if(str.isEmpty()){
                JOptionPane.showMessageDialog(null,"enter checkout date");
                return;
            }


            str=depositField.getText();
            if(str.isEmpty()){
                JOptionPane.showMessageDialog(null,"enter deposit amount");
                return;
            }



            String name=nameField.getText().toUpperCase();

            String gender="";
            if(male.isSelected())
                gender="Male".toUpperCase();
            if(female.isSelected())
                gender="Female".toUpperCase();



            String phoneNo=numberField.getText();

            String country=countryField.getText().toUpperCase();

            String id=((String)idCombo.getItemAt(idCombo.getSelectedIndex())).toUpperCase();

            String idNo=idNumberField.getText();

            int roomNo=Integer.parseInt(roomChoice.getSelectedItem());

            String time=timeTextField.getText().substring(11,19);

            DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = LocalDate.now().format(dtf);

            String checkout=checkoutField.getText();

            int deposit=Integer.parseInt(depositField.getText());

            String name_2 = "",gender_2="",country_2="",id_2="",idNo_2="",phoneNo_2=" ";


            if("Double Bed".equals(roomTypeField.getSelectedItem())){
                str=nameField2.getText();
                if(str.isEmpty()){
                    JOptionPane.showMessageDialog(null,"enter partner name");
                    return;
                }
                else if(!str.contains(" ")){
                    JOptionPane.showMessageDialog(null,"enter partner surname");
                    return;
                }
                else if(str.contains(" ")){
                    int index=str.indexOf(" ");
                    if(str.length()<=index+1){
                        JOptionPane.showMessageDialog(null,"enter partner surname");
                        return;
                    }
                }

                str="";
                if(male2.isSelected())
                    str="Male";
                else if(female2.isSelected())
                    str="Female";
                if(str.isEmpty()){
                    JOptionPane.showMessageDialog(null,"select partner gender");
                    return;
                }

                phoneNo_2=numberField2.getText();
                if(!phoneNo_2.isEmpty() && (phoneNo_2.length()!=10 || phoneNo_2.charAt(0)=='0')){
                    JOptionPane.showMessageDialog(null,"partner's phone no is invalid");
                    return;
                }


                str=countryField2.getText();
                if(str.isEmpty()){
                    JOptionPane.showMessageDialog(null,"enter partner's country name");
                    return;
                }

                str=""+idCombo2.getItemAt(idCombo2.getSelectedIndex());
                if(str.equals("Select")){
                    JOptionPane.showMessageDialog(null,"select partner's id option");
                    return;
                }

                str=idNumberField2.getText();
                if(str.isEmpty()){
                    JOptionPane.showMessageDialog(null,"enter partner's id number");
                    return;
                }

                name_2=nameField2.getText().toUpperCase();

                gender_2="";
                if(male2.isSelected())
                    gender_2="Male".toUpperCase();
                if(female2.isSelected())
                    gender_2="Female".toUpperCase();


                country_2=countryField2.getText().toUpperCase();

                id_2=((String)idCombo2.getItemAt(idCombo2.getSelectedIndex())).toUpperCase();

                idNo_2=idNumberField2.getText();

                if(idNo.equals(idNo_2)){
                    JOptionPane.showMessageDialog(null,"both ids must be different");
                    return;
                }else if(!phoneNo_2.isEmpty() && phoneNo.equals(phoneNo_2)){
                    JOptionPane.showMessageDialog(null,"both phones must be different");
                    return;
                }


            }


            DBConnection con=null;
            try{

                con=new DBConnection();
                con.conn.setAutoCommit(false);

                String checkQuery="select phone_no,id_no \n"
                        +"from customertable \n"
                        +"union all \n"
                        +"select phone_no,id_no \n"
                        +"from partnertable \n";

                ResultSet rs=con.st.executeQuery(checkQuery);
                while(rs.next()){
                    String dbPhoneNo = rs.getString("phone_no");
                    String dbIdNo = rs.getString("id_no");

                    if(dbPhoneNo!=null && dbPhoneNo.equals(phoneNo)){
                        JOptionPane.showMessageDialog(null,"customer's phone no already exist");
                        return;
                    }else if(dbIdNo!=null && dbIdNo.equals(idNo)){
                        JOptionPane.showMessageDialog(null,"customer's id no already exist");
                        return;
                    }
                    else if(!phoneNo_2.isEmpty() && dbPhoneNo != null && dbPhoneNo.equals(phoneNo_2)){
                        JOptionPane.showMessageDialog(null,"partner's phone no already exist");
                        return;
                    }else if(!idNo_2.isEmpty() && dbIdNo != null && dbIdNo.equals(idNo_2)){
                        JOptionPane.showMessageDialog(null,"partner's id no already exist");
                        return;
                    }
                }

                String query="insert into customertable values('"+name+"','"+gender+"',"+phoneNo+",'"+country+"','"+id+"','"+idNo+"',"+roomNo+",'"+time+"','"+date+"',"+deposit+",'"+checkout+"')";

                if("Double Bed".equals(roomTypeField.getSelectedItem())){
                    String query2="insert into partnertable values('"+name_2+"','"+gender_2+"','"+country_2+"','"+id_2+"','"+idNo_2+"',"+roomNo+",'"+time+"','"+date+"',"+deposit+",'"+phoneNo_2+"','"+checkout+"')";
                    con.st.executeUpdate(query2);
                }
                con.st.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"new customer added successfully");

                String query3="update addrooms set availability = 'Occupied' where room_no="+roomNo;

                con.st.executeUpdate(query3);

                con.conn.commit();

                setVisible(false);
                new AddReception();


            }catch(SQLException ex){
                System.out.println(ex.getMessage());
                try {
                    con.conn.rollback();
                    System.out.println("query rollbacked");
                } catch (SQLException exc) {
                    System.out.println("query rollback failed");
                }
            } catch(Exception ex){
                ex.printStackTrace();
            } finally {
                if(con!=null){
                    try{
                        con.conn.close();
                        System.out.println("db disconnected");
                    } catch (SQLException ex) {
                        System.out.println("Exception in addNewCustomer in close Db: "+ex);
                    }
                }
            }




        }
        else if(e.getSource()==back){
            setVisible(false);
            new AddReception();
        }
    }

    public void visiblity(){
        if("Double Bed".equals(roomTypeField.getSelectedItem())) {
            heading2.setVisible(true);
            name2.setVisible(true);
            nameField2.setVisible(true);
            gender2.setVisible(true);
            male2.setVisible(true);
            female2.setVisible(true);
            number2.setVisible(true);
            numberField2.setVisible(true);
            country2.setVisible(true);
            countryField2.setVisible(true);
            id2.setVisible(true);
            idCombo2.setVisible(true);
            idNumber2.setVisible(true);
            idNumberField2.setVisible(true);
        }else{
            heading2.setVisible(false);
            name2.setVisible(false);
            nameField2.setVisible(false);
            gender2.setVisible(false);
            male2.setVisible(false);
            female2.setVisible(false);
            number2.setVisible(false);
            numberField2.setVisible(false);
            country2.setVisible(false);
            countryField2.setVisible(false);
            id2.setVisible(false);
            idCombo2.setVisible(false);
            idNumber2.setVisible(false);
            idNumberField2.setVisible(false);
        }
    }



}

