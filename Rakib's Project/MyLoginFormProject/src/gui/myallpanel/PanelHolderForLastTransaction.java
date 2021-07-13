package gui.myallpanel;

import gui.transaction.*;

import javax.swing.*;
import java.awt.*;

public class PanelHolderForLastTransaction extends JFrame{
    String[] paymentItemComboBox = {"select","bKash","Nagad","Rocket","uKash","sure kash"};
    JPanel comboboxPanel;
    public PanelHolderForLastTransaction(){
        setLayout(null);
        setBounds(300,0,600,600);
        setForeground(Color.RED);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);

        comboboxPanel = new JPanel(null);
        comboboxPanel.setBounds(178,90,260,40);
        comboboxPanel.setBackground(Color.white);

        JComboBox<String> paymentBox = new JComboBox<>(paymentItemComboBox);
        paymentBox.setBounds(5,5,250,30);
        comboboxPanel.add(paymentBox);

        this.add(comboboxPanel);
        this.add(new TopPanel());
        this.add(new UnderLinePanel());


        paymentBox.addItemListener(e -> {
            String item = e.getItem().toString();
            try{
                switch (item){
                    case "bKash":
                        new LastTransactionFrameForbKash();
                        System.out.println(item);
                        break;

                    case "Nagad":
                        new LastTransactionFrameForNagad();
                        break;

                    case "Rocket":
                        new LastTransactionFrameForRocket();
                        break;

                    case "uKash":
                        new LastTransactionFrameForUKash();
                        break;
                    case "sure kash":
                        new LastTransactionFrameForsureKash();
                        break;
                    default:
                        break;
                }
            }catch(Exception ee){
                ee.printStackTrace();
            }
        });


        this.add(new AddingButtonPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new PanelHolderForLastTransaction();
    }

}
