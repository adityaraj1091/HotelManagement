package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddReception extends JFrame implements ActionListener {

    JButton newCustomer,rooms,department, employeeInfo,customerInfo,managerInfo;
    JButton checkOut, upgradeCustomerStatus, upgradeRoomStatus,searchRoom;

    public AddReception(){

        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        newCustomer=new JButton("New Customer Form");
        newCustomer.setBounds(20,20,170,30);
        newCustomer.setFont(new Font("sansserif",Font.PLAIN,13));
        newCustomer.setForeground(Color.white);
        newCustomer.setBackground(Color.black);
        add(newCustomer);

        newCustomer.addActionListener(this);

        rooms=new JButton("Rooms");
        rooms.setBounds(20,60,170,30);
        rooms.setFont(new Font("sansserif",Font.PLAIN,13));
        rooms.setForeground(Color.white);
        rooms.setBackground(Color.black);
        add(rooms);
        rooms.addActionListener(this);

        department=new JButton("Department");
        department.setBounds(20,100,170,30);
        department.setFont(new Font("sansserif",Font.PLAIN,13));
        department.setForeground(Color.white);
        department.setBackground(Color.black);
        add(department);
        department.addActionListener(this);

        employeeInfo =new JButton("Employees Info");
        employeeInfo.setBounds(20,140,170,30);
        employeeInfo.setFont(new Font("sansserif",Font.PLAIN,13));
        employeeInfo.setForeground(Color.white);
        employeeInfo.setBackground(Color.black);
        add(employeeInfo);
        employeeInfo.addActionListener(this);

        customerInfo=new JButton("Customer Info");
        customerInfo.setBounds(20,180,170,30);
        customerInfo.setFont(new Font("sansserif",Font.PLAIN,13));
        customerInfo.setForeground(Color.white);
        customerInfo.setBackground(Color.black);
        add(customerInfo);
        customerInfo.addActionListener(this);

        managerInfo=new JButton("Manager Info");
        managerInfo.setBounds(20,220,170,30);
        managerInfo.setFont(new Font("sansserif",Font.PLAIN,13));
        managerInfo.setForeground(Color.white);
        managerInfo.setBackground(Color.black);
        add(managerInfo);
        managerInfo.addActionListener(this);

        checkOut=new JButton("Checkout");
        checkOut.setBounds(20,260,170,30);
        checkOut.setFont(new Font("sansserif",Font.PLAIN,13));
        checkOut.setForeground(Color.white);
        checkOut.setBackground(Color.black);
        add(checkOut);
        checkOut.addActionListener(this);

        upgradeCustomerStatus =new JButton("Update Customer Status");
        upgradeCustomerStatus.setBounds(20,300,170,30);
        upgradeCustomerStatus.setFont(new Font("sansserif",Font.PLAIN,12));
        upgradeCustomerStatus.setForeground(Color.white);
        upgradeCustomerStatus.setBackground(Color.black);
        add(upgradeCustomerStatus);
        upgradeCustomerStatus.addActionListener(this);

        upgradeRoomStatus =new JButton("Update Room Status");
        upgradeRoomStatus.setBounds(20,340,170,30);
        upgradeRoomStatus.setFont(new Font("sansserif",Font.PLAIN,13));
        upgradeRoomStatus.setForeground(Color.white);
        upgradeRoomStatus.setBackground(Color.black);
        add(upgradeRoomStatus);
        upgradeRoomStatus.addActionListener(this);

        searchRoom=new JButton("Search room");
        searchRoom.setBounds(20,380,170,30);
        searchRoom.setFont(new Font("sansserif",Font.PLAIN,13));
        searchRoom.setForeground(Color.white);
        searchRoom.setBackground(Color.black);
        add(searchRoom);
        searchRoom.addActionListener(this);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/reception.jpg"));
        Image img2=img1.getImage().getScaledInstance(570,390,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel receptionImg=new JLabel(img3);
        receptionImg.setBounds(200,20,570,390);
        add(receptionImg);



        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

        if(e.getSource()==newCustomer)         new AddNewCustomer();

        else if(e.getSource()==rooms)          new Rooms();

        else if(e.getSource()==employeeInfo)   new EmployeeInfo();

        else if(e.getSource()==customerInfo)   new CustomerInfo();

        else if(e.getSource()==managerInfo)    new ManagerInfo();

        else if(e.getSource()==searchRoom)     new SearchRoom();

        else if(e.getSource()==checkOut)       new CheckOut();

        else if(e.getSource()== upgradeCustomerStatus)   new UpdateCussStatus();

        else if(e.getSource()== upgradeRoomStatus)       new UpdateRoomStatus();

    }

}
