package gui.myallpanel;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class uKashPanel extends JPanel {
    public static int totalAmountOfUkash = 100000;
    JLabel lblBkashTitle,lblMobileNumber, lblPinNumber, lblBkashIssueDate,lblTransactionID,lblAmount;
    public static JTextField txtMobileNumber,txtPinNumber,txtTransactionID,txtAmount;
    public static JDateChooser bKashIssueDate;
    public static String toMobile="", transaction_id="", issue_date="",lastAmount="";
    public uKashPanel(){
        setLayout(null);
        setBackground(Color.cyan);
        setBounds(0,152,600,300);


        lblBkashTitle = new JLabel("uKash");
        lblBkashTitle.setFont(new Font("Serif",Font.BOLD,20));
        lblBkashTitle.setBounds(260,8,300,30);


        lblMobileNumber = new JLabel("To Mobile Number");
        lblMobileNumber.setFont(new Font("Serif",Font.BOLD,16));
        lblMobileNumber.setBounds(30,60,200,30);

        txtMobileNumber = new JTextField();
        txtMobileNumber.setFont(new Font("Serif",Font.BOLD,16));
        txtMobileNumber.setBounds(180,60,250,30);

        lblPinNumber = new JLabel("Pin Number");
        lblPinNumber.setFont(new Font("Serif",Font.BOLD,16));
        lblPinNumber.setBounds(30,100,200,30);

        txtPinNumber = new JTextField();
        txtPinNumber.setFont(new Font("Serif",Font.BOLD,16));
        txtPinNumber.setBounds(180,100,250,30);

        lblBkashIssueDate = new JLabel("Issue Date");
        lblBkashIssueDate.setFont(new Font("Serif",Font.BOLD,16));
        lblBkashIssueDate.setBounds(30,140,200,30);

        bKashIssueDate = new JDateChooser();
        bKashIssueDate.getCalendarButton();
        bKashIssueDate.setBounds(180,140,250,30);

        lblTransactionID = new JLabel("Transaction ID");
        lblTransactionID.setFont(new Font("Serif",Font.BOLD,16));
        lblTransactionID.setBounds(30,180,200,30);

        txtTransactionID = new JTextField();
        txtTransactionID.setFont(new Font("Serif",Font.BOLD,16));
        txtTransactionID.setBounds(180,180,250,30);

        lblAmount = new JLabel("Amount");
        lblAmount.setFont(new Font("Serif",Font.BOLD,16));
        lblAmount.setBounds(30,220,200,30);

        txtAmount = new JTextField();
        txtAmount.setFont(new Font("Serif",Font.BOLD,16));
        txtAmount.setBounds(180,220,250,30);

        add(lblAmount);
        add(txtAmount);
        add(lblBkashTitle);
        add(lblMobileNumber);
        add(txtMobileNumber);
        add(lblPinNumber);
        add(txtPinNumber);
        add(lblBkashIssueDate);
        add(bKashIssueDate);
        add(lblTransactionID);
        add(txtTransactionID);

        AddingButtonPanel.paymentMethodAddingButton.addActionListener(e -> {
            try{
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank_user","postgres","sh0hr@b");

                String query = "insert into public.ukash_transaction_info values(?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1,lblBkashTitle.getText());
                stmt.setString(2, txtMobileNumber.getText());
                stmt.setString(3, bKashIssueDate.getDate().toString());
                stmt.setString(4, txtTransactionID.getText());

                int amount = Integer.parseInt(txtAmount.getText());
                if ((amount < 50000 && amount >= 500)) {
                    stmt.setInt(5, Integer.parseInt(txtAmount.getText()));
                    totalAmountOfUkash = totalAmountOfUkash - amount;
                } else {
                    JOptionPane.showMessageDialog(null, "You can't transaction less 500 and big 50000", "Enter valid Mobile", JOptionPane.ERROR_MESSAGE);
                }

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null," uKash Transaction Successfully");


                toMobile= uKashPanel.txtMobileNumber.getText();
                transaction_id=uKashPanel.txtTransactionID.getText();
                issue_date=uKashPanel.bKashIssueDate.getDate().toString();
                lastAmount= String.valueOf(Integer.parseInt(uKashPanel.txtAmount.getText()));

                txtMobileNumber.setText("");
                txtTransactionID.setText("");
                txtAmount.setText("");

            } catch(Exception exception){
                JOptionPane.showMessageDialog(null, "Duplicate Transaction ID not allowed","Enter valid mail",JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
