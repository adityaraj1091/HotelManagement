package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends JFrame implements ActionListener {

    private final JTextField userTextField;
    private final JPasswordField passTextField;
    private final JButton login,cancel;
    private final String str;

    public Login(String str){

        this.str=str;

        setSize(600,300);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);



        JLabel username=new JLabel("Username:");
        username.setBounds(70,50,70,20);
        add(username);

        userTextField=new JTextField();
        userTextField.setBounds(150,53,150,20);
        add(userTextField);

        JLabel password=new JLabel("Password:");
        password.setBounds(70,90,70,20);
        add(password);

        passTextField=new JPasswordField();
        passTextField.setBounds(150,93,150,20);
        add(passTextField);

        login=new JButton("Login");
        login.setBounds(70,165,80,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("serif",Font.PLAIN,15));
        add(login);
        login.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBounds(210,165,80,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.PLAIN,15));
        add(cancel);
        cancel.addActionListener(this);


        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/login.png"));
        Image img2=img1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel loginImg=new JLabel(img3);
        loginImg.setBounds(390,40,150,150);
        add(loginImg);


        setVisible(true);
        if(str.isEmpty()){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }else{
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==login){
            String user=userTextField.getText();
            String pass = passTextField.getText();

            DBConnection con = new DBConnection();
            try {

                String query = "select * from logintable where login='" + user + "' and password='" + pass + "'";
                ResultSet rs = con.st.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    switch (str) {
                        case "" -> new Dashboard();
                        case "addEmployee" -> new AddEmployees();
                        case "addDriver" -> new AddDriver();
                        case "addRooms" -> new AddRooms();
                        case "register" -> new AdminRegister();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"invalid username or password");

                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            finally {
                if(con.conn!=null){
                    try{
                        con.conn.close();
                        System.out.println("db disconnected");
                    }catch(SQLException ex) {
                        System.out.println("exception in login to disconnect: " + ex);
                    }
                }
            }

        }
        else if(e.getSource()==cancel){
            if(str.isEmpty()){
                System.exit(0);
            }else{
                setVisible(false);
            }
        }
    }

}
