package gui.myallpanel;

import javax.swing.*;
import java.awt.*;

public class AddingButtonPanel extends JPanel {
    public static JButton paymentMethodAddingButton;
    public AddingButtonPanel(){
        setLayout(null);
        setBounds(0,452,600,145);
        setBackground(Color.blue);

        paymentMethodAddingButton = new JButton("Submit");
        paymentMethodAddingButton.setFont(new Font("Serif",Font.BOLD,16));
        paymentMethodAddingButton.setBounds(180,0,250,30);

        add(paymentMethodAddingButton);

    }
}
