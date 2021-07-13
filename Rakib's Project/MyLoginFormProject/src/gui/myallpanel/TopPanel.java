package gui.myallpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TopPanel extends JPanel{
    JLabel title;

    static String item;
     public TopPanel(){
        setLayout(null);
        setBounds(0,0,600,150);
        setBackground(Color.blue);

        title = new JLabel("Select Your Mobile Banking");
        title.setBounds(180,30,300,30);
        title.setFont(new Font("Serif",Font.BOLD,20));
        title.setForeground(Color.WHITE);


        add(title);


    }
}
