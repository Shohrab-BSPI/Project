package gui.transaction;

import gui.myallpanel.BkashPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class LastTransactionFrameForbKash extends JFrame{
    JLabel titleBar;

    JPanel panelPaymentDashboard;

    public LastTransactionFrameForbKash(){
        setTitle("Last Transaction Info");
        setBounds(0,0,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);

        titleBar = new JLabel();
        titleBar.setText("Your bKash Last Transaction Info");
        titleBar.setFont(new Font("Serif",Font.BOLD,20));
        titleBar.setForeground(Color.red);
        titleBar.setBounds(60,20,350,30);
//        try{
//            Class.forName("org.postgresql.Driver");     //for postgresql jdbc driver class
//
//            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank_user","postgres","sh0hr@b");
//            //Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_info","postgres","sh0hr@b");
//
//            var query = "select to_mobile,transaction_id, issue_date, send_amount from public.bkash_transaction_info;";
//            var stmt = con.prepareStatement(query);
//            var resultSet = stmt.executeQuery();
//
//            while(resultSet.next()){
//                toMobile = resultSet.getString(1);
//                transaction_id = resultSet.getString(2);
//                issue_date = resultSet.getString(3);
//                amount = String.valueOf(resultSet.getInt(4));
//            }
//
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }


        //here get data from BkashPanel
        DefaultTableModel model = new DefaultTableModel(new String[][] { { BkashPanel.toMobile, BkashPanel.transaction_id, BkashPanel.issue_date, BkashPanel.lastAmount}}, new String[] { "To Mobile","Transaction ID","Date","Amount"} );

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
        new LastTransactionFrameForbKash();
    }
}
