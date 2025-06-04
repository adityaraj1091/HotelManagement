package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class AddDriver extends JFrame implements ActionListener{

    JTextField nameTextField,ageTextField,carNoTextField,aadharTextField,licenseTextField,salaryTextField,phoneTextField;

    JComboBox genderCombo,carTypeCombo;

    JButton addDriver,cancel;

    public AddDriver(){

        setSize(900,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading=new JLabel("Add Drivers");
        heading.setBounds(200,20,130,30);
        heading.setFont(new Font("serif",Font.BOLD,17));
        add(heading);

        JLabel name=new JLabel("name");
        name.setBounds(70,80,50,20);
        name.setFont(new Font("sansserif",Font.BOLD,13));
        add(name);

        nameTextField=new JTextField();
        nameTextField.setBounds(200,83,150,20);
        add(nameTextField);

        JLabel age=new JLabel("Age");
        age.setBounds(70,110,30,20);
        age.setFont(new Font("sansserif",Font.BOLD,13));
        add(age);

        ageTextField=new JTextField();
        ageTextField.setBounds(200,113,150,20);
        add(ageTextField);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(70,145,70,20);
        gender.setFont(new Font("sansserif",Font.BOLD,13));
        add(gender);

        String str1[]={
                "Select",
                "Male",
                "Female"
        };

        genderCombo=new JComboBox(str1);
        genderCombo.setBounds(200,145,150,20);
        add(genderCombo);


        JLabel phone=new JLabel("Phone");
        phone.setBounds(70,175,85,20);
        phone.setFont(new Font("sansserif",Font.BOLD,13));
        add(phone);

        phoneTextField=new JTextField();
        phoneTextField.setBounds(200,178,150,20);
        add(phoneTextField);


        JLabel carType=new JLabel("Car Type");
        carType.setBounds(70,205,85,20);
        carType.setFont(new Font("sansserif",Font.BOLD,13));
        add(carType);

        String str2[]={
                "Select",
                "Sedan",
                "SUV"
        };

        carTypeCombo=new JComboBox(str2);
        carTypeCombo.setBounds(200,208,150,20);
        add(carTypeCombo);

        JLabel carNo=new JLabel("Car No");
        carNo.setBounds(70,235,85,20);
        carNo.setFont(new Font("sansserif",Font.BOLD,13));
        add(carNo);

        carNoTextField=new JTextField();
        carNoTextField.setBounds(200,238,150,20);
        add(carNoTextField);

        JLabel license=new JLabel("License");
        license.setBounds(70,265,85,20);
        license.setFont(new Font("sansserif",Font.BOLD,13));
        add(license);

        licenseTextField=new JTextField();
        licenseTextField.setBounds(200,268,150,20);
        add(licenseTextField);

        JLabel salary=new JLabel("Salary");
        salary.setBounds(70,295,140,20);
        salary.setFont(new Font("sansserif",Font.BOLD,13));
        add(salary);

        salaryTextField=new JTextField();
        salaryTextField.setBounds(200,298,150,20);
        add(salaryTextField);

        JLabel available=new JLabel("Aadhar");
        available.setBounds(70,325,85,20);
        available.setFont(new Font("sansserif",Font.BOLD,13));
        add(available);


        aadharTextField=new JTextField();
        aadharTextField.setBounds(200,328,150,20);
        add(aadharTextField);

        addDriver=new JButton("Add Driver");
        addDriver.setBounds(90,390,100,30);
        addDriver.setBackground(Color.black);
        addDriver.setForeground(Color.white);
        add(addDriver);
        addDriver.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBounds(250,390,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/driverImage.jpg"));
        Image img2=img1.getImage().getScaledInstance(450,270,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel driverImage=new JLabel(img3);
        driverImage.setBounds(400,67,450,300);
        add(driverImage);


        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addDriver){

            String str;

            String name=nameTextField.getText().toUpperCase();
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"enter name");
                return;
            }else if(!name.contains(" ")){
                JOptionPane.showMessageDialog(null,"enter surname");
                return;
            }else{
                int index=name.indexOf(" ");
                if(index+1==name.length()) {
                    JOptionPane.showMessageDialog(null, "enter surname");
                    return;
                }
            }


            str=ageTextField.getText();
            int age;
            if(str.equals("")){
                JOptionPane.showMessageDialog(null,"enter age");
                return;
            }else{
                age=Integer.parseInt(ageTextField.getText());
            }
            if(age<25 || age>70){
                JOptionPane.showMessageDialog(null,"enter age between 25 and 70");
                return;
            }


            String gender=((String)genderCombo.getItemAt(genderCombo.getSelectedIndex())).toUpperCase();
            if(gender.equalsIgnoreCase("Select")){
                JOptionPane.showMessageDialog(null,"Select Gender");
                return;
            }

            str=phoneTextField.getText();
            int phone;
            if(str.isEmpty()){
                JOptionPane.showMessageDialog(null,"enter phone no");
                return;
            }else if(str.length()!=10){
                JOptionPane.showMessageDialog(null,"enter valid phone no");
                return;
            }else{
                phone=Integer.parseInt(phoneTextField.getText());
            }


            String carType= carTypeCombo.getSelectedItem().toString().toUpperCase();
            if(carType.equals("")){
                JOptionPane.showMessageDialog(null,"enter car company name");
                return;
            }

            String carNo=carNoTextField.getText().toUpperCase();
            if(carNo.equals("")){
                JOptionPane.showMessageDialog(null,"enter car's model");
                return;
            }else if(carNo.length()!=10){
                JOptionPane.showMessageDialog(null,"enter valid car no");
                return;
            }

            String license=licenseTextField.getText().toUpperCase();
            if(license.isEmpty()){
                JOptionPane.showMessageDialog(null,"enter license no");
                return;
            }else if(license.length()!=16){
                JOptionPane.showMessageDialog(null,"enter valid license no");
                return;
            }

            int salary;
            str=salaryTextField.getText();
            if(str.isEmpty()){
                JOptionPane.showMessageDialog(null,"enter salary");
                return;
            }else{
                salary=Integer.parseInt(salaryTextField.getText());
            }
            if(salary<20000){
                JOptionPane.showMessageDialog(null,"salary should be greater than 20000");
                return;
            }

            long aadhar;
            str=aadharTextField.getText();
            if(str.equals("")) {
                JOptionPane.showMessageDialog(null,"enter aadhar");
                return;
            }else if(str.length()!=12){
                JOptionPane.showMessageDialog(null,"enter valid aadhar");
                return;
            } else{
                aadhar = Long.parseLong(aadharTextField.getText());
            }

            DBConnection con=null;
            try{

                con=new DBConnection();

                String query1="select phone,aadhar from employeetable union all select phone,aadhar from drivertable";
                ResultSet rs= con.st.executeQuery(query1);
                while(rs.next()){
                    if(rs.getInt("phone")==phone){
                        JOptionPane.showMessageDialog(null,"phone no exist");
                        return;
                    }
                    if(rs.getLong("aadhar")==aadhar){
                        JOptionPane.showMessageDialog(null,"aadhar no exist");
                        return;
                    }
                }

                String query="insert into drivertable values('"+name+"',"+age+",'"+gender+"','"+carType+"','"+carNo+"',"+aadhar+","+phone+",'"+license+"',"+salary+",'','')";
                con.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Add Driver Successfully");
                setVisible(false);

            }catch(SQLIntegrityConstraintViolationException ex){
                JOptionPane.showMessageDialog(null,"License no exist");
            }catch (SQLException ex) {
                System.out.println("exception in AddDriver: "+ex);
            }finally {
                if(con!=null){
                    try{
                        con.conn.close();
                        System.out.println("DB disconnected");
                    }catch (SQLException ex) {
                        System.out.println("Exception in AddDriver in close db: "+ex);
                    }
                }
            }


        }else{
            setVisible(false);
        }
    }

}
