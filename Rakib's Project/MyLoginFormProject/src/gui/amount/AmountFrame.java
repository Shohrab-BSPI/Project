package gui.amount;

import gui.myallpanel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class AmountFrame extends JFrame{
    JPanel comboboxPanel;
    public AmountFrame(){
        setLayout(null);
        setBounds(300,0,600,600);
        setForeground(Color.RED);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);

        comboboxPanel = new JPanel(null);
        comboboxPanel.setBounds(178,190,260,40);
        comboboxPanel.setBackground(Color.white);

        String[] paymentItemComboBox = {"select","bKash","Nagad","Rocket","uKash","sure kash"};
        JComboBox paymentBox = new JComboBox(paymentItemComboBox);
        paymentBox.setBounds(5,5,250,30);



        comboboxPanel.add(paymentBox);

        this.add(comboboxPanel);
        this.add(new TopPanelForAmount());


        paymentBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String item = e.getItem().toString();
                try{
                    switch (item){
                        case "bKash":
                            String amountBkash = ""+BkashPanel.totalAmountOfbKash;
                            JOptionPane.showMessageDialog(null,"Your bKash Total amount : "+amountBkash+" tk");
                            new AmountFrame().dispose();
                            break;

                        case "Nagad":
                            String amountNagad = ""+NagadPanel.totalAmountOfNagad;
                            JOptionPane.showMessageDialog(null,"Your Nagad Total amount : "+amountNagad+" tk");
                            new AmountFrame().dispose();
                            break;

                        case "Rocket":
                            String amountRocket = ""+RocketPanel.totalAmountOfRocket;
                            JOptionPane.showMessageDialog(null,"Your Rocket Total amount : "+amountRocket+" tk");
                            new AmountFrame().dispose();
                            break;

                        case "uKash":
                            String amountUkash = ""+uKashPanel.totalAmountOfUkash;
                            JOptionPane.showMessageDialog(null,"Your uKash Total amount : "+amountUkash+" tk");
                            new AmountFrame().dispose();
                            break;

                        case "sure kash":
                            String amountSureKash = ""+SureKashPanel.totalAmountOfSureKash;
                            JOptionPane.showMessageDialog(null,"Your sure kash Total amount : "+amountSureKash+" tk");
                            new AmountFrame().dispose();
                            break;
                        default:
                            break;
                    }
                }catch(Exception ee){
                    ee.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AmountFrame();
    }

}
