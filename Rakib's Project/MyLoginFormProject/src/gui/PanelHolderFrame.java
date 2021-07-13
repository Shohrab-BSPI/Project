package gui;

import gui.myallpanel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanelHolderFrame extends JFrame{
    String[] paymentItemComboBox = {"select","bKash","Nagad","Rocket","uKash","sure kash"};
    JPanel comboboxPanel;
    public PanelHolderFrame(){
        setLayout(null);
        setBounds(300,0,600,600);
        setForeground(Color.RED);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);

        comboboxPanel = new JPanel(null);
        comboboxPanel.setBounds(178,90,260,40);
        comboboxPanel.setBackground(Color.white);

        JComboBox paymentBox = new JComboBox(paymentItemComboBox);
        paymentBox.setBounds(5,5,250,30);
        comboboxPanel.add(paymentBox);

        this.add(comboboxPanel);
        this.add(new TopPanel());
        this.add(new UnderLinePanel());


        paymentBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String item = e.getItem().toString();
                try{
                    switch (item){
                        case "bKash":
                            new PanelHolderFrame().add(new BkashPanel());
                            System.out.println(item);
                            break;

                        case "Nagad":
                            new PanelHolderFrame().add(new NagadPanel());
                            System.out.println(item);
                            break;

                        case "Rocket":
                            new PanelHolderFrame().add(new RocketPanel());
                            System.out.println(item);
                            break;

                        case "uKash":
                            new PanelHolderFrame().add(new uKashPanel());
                            System.out.println(item);
                            break;
                        case "sure kash":
                            new PanelHolderFrame().add(new SureKashPanel());
                            System.out.println(item);
                            break;
                        default:
                            break;
                    }
                }catch(Exception ee){
                    ee.printStackTrace();
                }
            }
        });


        this.add(new AddingButtonPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new PanelHolderFrame();
    }

}
