package gui.transaction;

import gui.myallpanel.BkashPanel;
import gui.myallpanel.SureKashPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LastTransactionFrameForsureKash extends JFrame{
    JLabel titleBar;

    JPanel panelPaymentDashboard;

    public LastTransactionFrameForsureKash(){
        setTitle("Last Transaction Info");
        setBounds(0,0,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);

        titleBar = new JLabel();
        titleBar.setText("Your Sure Kash Last Transaction Info");
        titleBar.setFont(new Font("Serif",Font.BOLD,20));
        titleBar.setForeground(Color.red);
        titleBar.setBounds(60,20,350,30);

        DefaultTableModel model = new DefaultTableModel(new String[][] { { SureKashPanel.toMobile, SureKashPanel.transaction_id, SureKashPanel.issue_date, SureKashPanel.lastAmount}}, new String[] { "To Mobile","Transaction ID","Date","Amount"} );

        JTable t = new JTable(model);
        JScrollPane scroll = new JScrollPane(t);
        scroll.setBounds( 30, 100, 420, 150 ); // x, y, width, height

        //create panel and set background color
        panelPaymentDashboard = new JPanel(null);
        panelPaymentDashboard.setBackground(Color.cyan);
        panelPaymentDashboard.setBounds(0,0,500,400);

        //adding element into JPanel
        panelPaymentDashboard.add(titleBar);
        panelPaymentDashboard.add(scroll);

        //Add element into JFrame
        this.add(panelPaymentDashboard);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LastTransactionFrameForsureKash();
    }
}
