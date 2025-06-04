package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRegister extends JFrame implements ActionListener {

    JTextField userNameTF;
    JPasswordField passwordTF,cnfPassTF;
    JButton submit,cancel;

    public AdminRegister(){
        designFrame();
    }

    public void designFrame(){
        setSize(500,300);
        setLocationRelativeTo(null);
        setLayout(null);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/registerAdminImage.jpg"));
        Image img2=img1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel bgImage=new JLabel(img3);
        bgImage.setBounds(0,0,500,300);
        add(bgImage);

        JLabel username=new JLabel("User Name");
        username.setBounds(60,50,100,20);
        username.setFont(new Font("sansserif",Font.BOLD,15));
        username.setForeground(Color.white);
        bgImage.add(username);

        userNameTF=new JTextField();
        userNameTF.setBounds(180,50,180,20);
        bgImage.add(userNameTF);

        JLabel password=new JLabel("Password");
        password.setBounds(60,90,100,20);
        password.setFont(new Font("sansserif",Font.BOLD,15));
        password.setForeground(Color.white);
        bgImage.add(password);

        passwordTF=new JPasswordField();
        passwordTF.setBounds(180,90,180,20);
        bgImage.add(passwordTF);

        JLabel confirmPassword=new JLabel("Confirm Pass");
        confirmPassword.setBounds(60,130,150,20);
        confirmPassword.setFont(new Font("sansserif",Font.BOLD,15));
        confirmPassword.setForeground(Color.white);
        bgImage.add(confirmPassword);

        cnfPassTF=new JPasswordField();
        cnfPassTF.setBounds(180,130,180,20);
        bgImage.add(cnfPassTF);

        submit=new JButton("Submit");
        submit.setBounds(60,200,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("sansserif",Font.BOLD,13));
        bgImage.add(submit);
        submit.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBounds(240,200,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("sansserif",Font.BOLD,13));
        bgImage.add(cancel);
        cancel.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){

            String username=userNameTF.getText();
            String pass=passwordTF.getText();
            String cnfpass=cnfPassTF.getText();

            if(username.equals("")){
                JOptionPane.showMessageDialog(null,"enter username");
                return;
            }else if(pass.equals("")){
                JOptionPane.showMessageDialog(null,"enter password");
                return;
            }else if(cnfpass.equals("")){
                JOptionPane.showMessageDialog(null,"enter confirm password");
                return;
            }else if(!pass.equals(cnfpass)){
                JOptionPane.showMessageDialog(null,"password and confirm password must be same");
                return;
            }

            DBConnection con=null;
            try{
                con=new DBConnection();
                String query1="select login from logintable";
                ResultSet rs1=con.st.executeQuery(query1);
                while(rs1.next()){
                    if(username.equals(rs1.getString("login"))){
                        JOptionPane.showMessageDialog(null,"username is exist");
                        return;
                    }
                }
                rs1.close();

                String query2="insert into logintable values('"+username+"','"+pass+"')";
                con.st.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Admin added successfully");
                setVisible(false);
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }finally {
                if(con!=null){
                    try{
                        con.conn.close();
                        System.out.println("DB in AdminRegister is disconnected");
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }

        }

        else{
            setVisible(false);
        }
    }
}
