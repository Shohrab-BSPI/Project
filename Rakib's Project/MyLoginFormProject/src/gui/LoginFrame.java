package gui;

import gui.myallpanel.DashboardMobileBanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel login = new JLabel("Login Here!");
    JLabel userLabel = new JLabel("Account No");
    JLabel passwordLabel = new JLabel("Password");
    JTextField txtAccountNumber = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JCheckBox showPassword = new JCheckBox("Show Password");
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton singUp = new JButton("Sign Up");




    public LoginFrame(){
            setLayoutManager();
            setLocationAndSize();
            addComponentsToContainer();
            addActionEvent();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Login Form");
            setBounds(0,0,600,700);
            setResizable(false);
            setVisible(true);
    }

    public void setLayoutManager(){
        container.setLayout(null);
    }


    public void setLocationAndSize(){
        login.setBounds(180,50,300,30);
        login.setFont(new Font("Serif",Font.BOLD,24));

        userLabel.setBounds(50,150,100,30);
        userLabel.setFont(new Font("Serif",Font.BOLD,16));

        passwordLabel.setBounds(50,200,100,30);
        passwordLabel.setFont(new Font("Serif",Font.BOLD,16));

        txtAccountNumber.setBounds(150,150,200,30);
        txtAccountNumber.setFont(new Font("Serif",Font.PLAIN,16));

        passwordField.setBounds(150,200,200,30);

        showPassword.setBounds(150,250,200,30);
        showPassword.setFont(new Font("Serif",Font.BOLD,16));

        loginButton.setBounds(150,350,90,30);
        loginButton.setFont(new Font("Serif",Font.BOLD,16));

        resetButton.setBounds(260,350,90,30);
        resetButton.setFont(new Font("Serif",Font.BOLD,16));

        singUp.setBounds(150,400,200,30);
        singUp.setFont(new Font("Serif",Font.BOLD,16));
    }

    public void addComponentsToContainer(){
        container.setBackground(Color.lightGray);
        container.add(login);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(txtAccountNumber);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(singUp);
    }

    public void addActionEvent(){
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        singUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationForm();
                LoginFrame.this.dispose();

            }
        });
    }


    //override actionPerformed() method
    @Override
    public void actionPerformed(ActionEvent e){
        String sql = "select user_name, password from public.bankuser_info where account_no=? and password=?";
        try{
            Class.forName("org.postgresql.Driver");     //for postgresql jdbc driver class
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank_user","postgres","sh0hr@b");

            PreparedStatement myStatement = con.prepareStatement(sql);
            myStatement.setString(1, txtAccountNumber.getText());
            myStatement.setString(2, new String(passwordField.getPassword()));

            ResultSet resultSet = myStatement.executeQuery();

            if(resultSet.next()){
                JOptionPane.showMessageDialog(this, "WEL-COME","Successful login",JOptionPane.PLAIN_MESSAGE);
                new DashboardMobileBanking();
                LoginFrame.this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "user or password invalid","UnSuccessful login",JOptionPane.ERROR_MESSAGE);

            }

            con.close();
        }catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception);
        }

        //Coding for RESET button
        if(e.getSource() == resetButton){
            txtAccountNumber.setText("");
            passwordField.setText("");
        }

        //Coding part for showPassword JCheckBox
        if(e.getSource() == showPassword){
            if(showPassword.isSelected()){
                passwordField.setEchoChar((char)0);
            }else{
                passwordField.setEchoChar('*');
            }
        }
    }

}
