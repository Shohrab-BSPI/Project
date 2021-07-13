package gui.myallpanel;

import javax.swing.*;
import java.awt.*;

public class TopPanelForDashBoard extends JPanel{
    JLabel title,title2,lblQuery;

     public TopPanelForDashBoard(){
        setLayout(null);
        setBounds(0,0,600,600);
        setBackground(Color.blue);

        title = new JLabel("WELCOME OUR MOBILE BANKING");
        title.setBounds(130,30,500,30);
        title.setFont(new Font("Serif",Font.BOLD,20));
        title.setForeground(Color.WHITE);


         title2 = new JLabel("DASHBOARD");
         title2.setBounds(230,80,500,30);
         title2.setFont(new Font("Serif",Font.BOLD,20));
         title2.setForeground(Color.WHITE);

         lblQuery = new JLabel("Select Your Query");
         lblQuery.setBounds(215,130,300,30);
         lblQuery.setFont(new Font("Serif",Font.BOLD,20));
         lblQuery.setForeground(Color.black);

         add(title);
         add(title2);
         add(lblQuery);


    }
}
