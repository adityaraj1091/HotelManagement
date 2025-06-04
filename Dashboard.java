package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JLabel welcomeText;
    JMenuItem addEmployee,addRooms,addDrivers,reception, register;

    public Dashboard()  {

        setSize(1600,850);
        setLayout(null);


        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/dashboard.jpg"));
        Image img2=img1.getImage().getScaledInstance(1600,870,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);

        JLabel dashImage=new JLabel(img3);
        dashImage.setBounds(0,0,1600,850);
        add(dashImage);

        welcomeText=new JLabel("Welcome to the Grand Central Hotel");
        welcomeText.setBounds(450,100,500,40);
        welcomeText.setFont(new Font("Tahoma",Font.PLAIN,30));
        dashImage.add(welcomeText);

        JMenuBar menuBar=new JMenuBar();
        menuBar.setBounds(0,0,1600,30);
        dashImage.add(menuBar);

        JMenu hotelManagement=new JMenu("Hotel Management");
        menuBar.add(hotelManagement);

        reception=new JMenuItem("Reception");
        hotelManagement.add(reception);

        JMenu admin=new JMenu("Admin");
        menuBar.add(admin);

        addEmployee=new JMenuItem("Add Employee");
        admin.add(addEmployee);
        addRooms=new JMenuItem("Add Rooms");
        admin.add(addRooms);
        addDrivers=new JMenuItem("Add Drivers");
        admin.add(addDrivers);

        JMenu registerAdmin=new JMenu("Register Admin");
        menuBar.add(registerAdmin);

        register =new JMenuItem("Register Admin");
        register.setBounds(200,200,100,20);
        registerAdmin.add(register);


        addEmployee.addActionListener(this);
        addRooms.addActionListener(this);
        addDrivers.addActionListener(this);
        reception.addActionListener(this);
        register.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startTransition();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addEmployee)         new Login("addEmployee");

        else if (e.getSource()==addRooms)      new Login("addRooms");

        else if(e.getSource()==addDrivers)     new Login("addDriver");

        else if(e.getSource()==reception)      new AddReception();

        else if(e.getSource()== register)      new Login("register");
    }

    public void startTransition() {
        String str = "Welcome to the Grand Central Hotel";
        final StringBuilder mess = new StringBuilder();

        Timer timer = new Timer(150, null);

        timer.addActionListener(new ActionListener() {
            int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < str.length()) {
                    mess.append(str.charAt(index));
                    welcomeText.setText(mess.toString());
                    index++;
                } else {
                    // Reset and restart
                    mess.setLength(0);
                    welcomeText.setText("");
                    index = 0;
                }
            }
        });

        timer.start();
    }


}