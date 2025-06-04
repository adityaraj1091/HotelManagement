package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;

public class HotelManagementApp extends JFrame implements ActionListener {



    public HotelManagementApp(){

        setSize(1366,565);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("image/Hotel.jpg"));
        JLabel hotelImg=new JLabel(image);
        hotelImg.setBounds(0,0,1366,565);
        add(hotelImg);

        JLabel welcomeText=new JLabel("Welcome to the Hotel");
        welcomeText.setBounds(550,50,400,40);
        welcomeText.setForeground(Color.RED);
        welcomeText.setFont(new Font("serif",Font.PLAIN,40));
        hotelImg.add(welcomeText);



        JButton next=new JButton("Next");
        next.setBounds(650,450,80,30);
        next.setFont(new Font("serif",Font.PLAIN,20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        hotelImg.add(next);

        next.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        while(true){

            welcomeText.setVisible(true);

            try {
                sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            welcomeText.setVisible(false);

            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login("");
    }


    public static void main(String[] args) {
        new HotelManagementApp();
    }


}
