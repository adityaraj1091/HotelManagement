package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Locale;

public class AddEmployees extends JFrame implements ActionListener {

    JTextField nameTextField,ageTextField,salaryTextField;
    JTextField phoneTextField,mailTextField,aadharTextField;
    JRadioButton male,female;
    JComboBox jobTextField;


    public AddEmployees(){

        setSize(850,550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);


        JLabel name=new JLabel("Name");
        name.setBounds(70,60,50,30);
        name.setFont(new Font("sansserif",Font.BOLD,15));
        add(name);
        nameTextField=new JTextField();
        nameTextField.setBounds(180,67,150,20);
        add(nameTextField);

        JLabel age=new JLabel("Age");
        age.setBounds(70,100,30,30);
        age.setFont(new Font("sansserif",Font.BOLD,15));
        add(age);
        ageTextField=new JTextField();
        ageTextField.setBounds(180,107,150,20);
        add(ageTextField);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(70,140,70,30);
        gender.setFont(new Font("sansserif",Font.BOLD,15));
        add(gender);
        male=new JRadioButton("Male");
        male.setBounds(177,147,52,20);
        male.setBackground(Color.white);
        add(male);
        female=new JRadioButton("Female");
        female.setBackground(Color.white);
        female.setBounds(250,147,66,20);
        add(female);
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel job=new JLabel("Job");
        job.setBounds(70,180,40,30);
        job.setFont(new Font("sansserif",Font.BOLD,15));
        add(job);
        String str[]={
                "Select",
                "Front Desk Clerk",
                "Porters",
                "Housekeeping",
                "Kitchen Staff",
                "Room Service",
                "Chefs",
                "Waiter/Waitress",
                "Manager"
        };
        jobTextField=new JComboBox(str);
        jobTextField.setBounds(180,187,150,20);
        jobTextField.setBackground(Color.white);
        add(jobTextField);

        JLabel salary=new JLabel("Salary");
        salary.setBounds(70,220,50,30);
        salary.setFont(new Font("sansserif",Font.BOLD,15));
        add(salary);
        salaryTextField=new JTextField();
        salaryTextField.setBounds(180,227,150,20);
        add(salaryTextField);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(70,260,50,30);
        phone.setFont(new Font("sansserif",Font.BOLD,15));
        add(phone);
        phoneTextField=new JTextField();
        phoneTextField.setBounds(180,267,150,20);
        add(phoneTextField);

        JLabel email=new JLabel("Email");
        email.setBounds(70,300,50,30);
        email.setFont(new Font("sansserif",Font.BOLD,15));
        add(email);
        mailTextField=new JTextField();
        mailTextField.setBounds(180,307,150,20);
        add(mailTextField);

        JLabel aadhar=new JLabel("Aadhar no");
        aadhar.setBounds(70,340,80,30);
        aadhar.setFont(new Font("sansserif",Font.BOLD,15));
        add(aadhar);
        aadharTextField=new JTextField();
        aadharTextField.setBounds(180,347,150,20);
        add(aadharTextField);

        JButton submit=new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setFont(new Font("sansserif",Font.BOLD,13));
        submit.setBounds(170,400,120,30);
        add(submit);
        submit.addActionListener(this);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/employeesPicture.jpg"));
        JLabel employeesPic=new JLabel(img1);
        employeesPic.setBounds(400,50,400,400);
        add(employeesPic);

        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String string;

        String name=nameTextField.getText().toUpperCase();
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(null,"enter name");
            return;
        }else if(!name.contains(" ")){
            JOptionPane.showMessageDialog(null,"enter surname");
            return;
        }
        else if(name.contains(" ")){
            int index=name.indexOf(" ");
            if(name.length()<=index+1){
                JOptionPane.showMessageDialog(null,"enter surname");
                return;
            }
        }


        int age;
        string=ageTextField.getText();
        if(string.equals("")) {
            JOptionPane.showMessageDialog(null,"enter age");
            return;
        }
        else{
            age = Integer.parseInt(ageTextField.getText());
        }


        String gender="";
        if(male.isSelected())
            gender="male".toUpperCase();
        else if(female.isSelected())
            gender="female".toUpperCase();

        if(gender.equals("")) {
            JOptionPane.showMessageDialog(null, "gender should not be empty");
            return;
        }


        String job= ((String)jobTextField.getItemAt(jobTextField.getSelectedIndex())).toUpperCase();
        if(job.equals("Select")) {
            JOptionPane.showMessageDialog(null, "select a valid job");
            return;
        }



        long salary;
        string=salaryTextField.getText();
        if(string.equals("")) {
            JOptionPane.showMessageDialog(null,"enter sal");
            return;
        }
        else{
            salary = Long.parseLong(salaryTextField.getText());
        }



        long phone;
        string=phoneTextField.getText();
        if(string.equals("")) {
            JOptionPane.showMessageDialog(null,"enter phone no");
            return;
        }
        if(string.length()!=10){
            JOptionPane.showMessageDialog(null,"enter valid phone no");
            return;
        }
        else{
            phone = Long.parseLong(phoneTextField.getText());
        }



        String mail=String.valueOf(mailTextField.getText());
        if(mail.equals("")) {
            JOptionPane.showMessageDialog(null, "mail should not be empty");
            return;
        }



        long aadhar;
        string=aadharTextField.getText();
        if(string.equals("")) {
            JOptionPane.showMessageDialog(null,"enter aadhar");
            return;
        }else if(string.length()!=12){
            JOptionPane.showMessageDialog(null,"enter valid aadhar");
            return;
        }
        else{
            aadhar = Long.parseLong(aadharTextField.getText());
        }


        int pos=mail.indexOf("@");
        String str="";

        if(pos>-1) {
            str = mail.substring(pos);
        }

        else if(age<25 || age>60){
            JOptionPane.showMessageDialog(null,"age should be between 25 to 60");
            return;
        }


        else if(salary<20000){
            JOptionPane.showMessageDialog(null,"salary should be greater than 20000");
            return;
        }
        else if((phone < 1000000000) || (phone > 9999999999l)){
            JOptionPane.showMessageDialog(null,"phone no invalid");
            return;
        }

        else if(!str.equals("@gmail.com")) {
            JOptionPane.showMessageDialog(null, "mail invalid");
            return;
        }
        else if(aadhar<100000000000l || aadhar>999999999999l){
            JOptionPane.showMessageDialog(null,"aadhar invalid");
            return;
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

            String query="insert into employeetable values('"+name+"',"+age+",'"+gender+"','"+job+"',"+salary+","+phone+",'"+mail+"',"+aadhar+")";

            con.st.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Employee Added Successfully");

            setVisible(false);

        }catch(SQLIntegrityConstraintViolationException ex){
            if(ex.getMessage().toLowerCase().contains("phone")){
                JOptionPane.showMessageDialog(null,"phone no exist");
            }else if(ex.getMessage().toLowerCase().contains("email")){
                JOptionPane.showMessageDialog(null,"email is exist");
            }else if(ex.getMessage().toLowerCase().contains("aadhar")){
                JOptionPane.showMessageDialog(null,"aadhar is exist");
            }
        }catch (SQLException ex) {
            System.out.println("Exception in addemployee: "+ex);
        }finally {
            if(con!=null){
                try {
                    con.conn.close();
                    System.out.println("DB disconnected successfully");
                } catch (SQLException ex) {
                    System.out.println("Exception in addEmployee in close DB: "+ex);
                }

            }
        }

    }

}
