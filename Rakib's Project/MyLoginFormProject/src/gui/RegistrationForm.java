package gui;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {
    JLabel lblTitle, lblFirstName,
    lblLastName,
    lblUserName,
    lblGmail,
    lblPhone,
    lblPassword,
    lblConfirmPassword,
    lblGender,
    lblAccountNumber;

    JTextField textFirstName, textLastName,
    textUserName,
    textGmail,
    textPhone,
    textPassword,
    txtConfirmPassword,
    txtAccountNumber;

    ButtonGroup sex;
    JRadioButton maleYes,femaleYes;

    JButton buttonLogin,
    buttonRegistration;

    JPanel panelRegistration;

    RegistrationForm(){

        //firstly displaying JFrame or window
        setTitle("Registration");
        //setVisible(true);
        setBounds(0,0,600,700);
        //setResizable(false);

        lblTitle = new JLabel("Registration Form");
        lblTitle.setFont(new Font("Serif",Font.BOLD,24));
        lblTitle.setForeground(Color.white);
        lblTitle.setBounds(250,10,200,30);

        lblFirstName = new JLabel("First Name");
        lblFirstName.setFont(new Font("Serif",Font.BOLD,16));
        lblFirstName.setBounds(30,60,200,30);
        lblFirstName.setForeground(Color.white);
        textFirstName = new JTextField();
        textFirstName.setFont(new Font("Serif",Font.PLAIN,16));
        textFirstName.setBounds(200,60,300,30);

        lblLastName = new JLabel("Last Name");
        lblLastName.setFont(new Font("Serif",Font.BOLD,16));
        lblLastName.setBounds(30,95,200,30);
        lblLastName.setForeground(Color.white);
        textLastName = new JTextField();
        textLastName.setFont(new Font("Serif",Font.PLAIN,16));
        textLastName.setBounds(200,95,300,30);

        lblUserName = new JLabel("User Name");
        lblUserName.setFont(new Font("Serif",Font.BOLD,16));
        lblUserName.setBounds(30,130,200,30);
        lblUserName.setForeground(Color.white);
        textUserName = new JTextField();
        textUserName.setFont(new Font("Serif",Font.PLAIN,16));
        textUserName.setBounds(200,130,300,30);

        lblGmail = new JLabel("Gmail");
        lblGmail.setFont(new Font("Serif",Font.BOLD,16));
        lblGmail.setBounds(30,165,200,30);
        lblGmail.setForeground(Color.white);
        textGmail = new JTextField();
        textGmail.setFont(new Font("Serif",Font.PLAIN,16));
        textGmail.setBounds(200,165,300,30);

        lblPhone = new JLabel("Phone");
        lblPhone.setFont(new Font("Serif",Font.BOLD,16));
        lblPhone.setBounds(30,200,200,30);
        lblPhone.setForeground(Color.white);
        textPhone = new JTextField();
        textPhone.setFont(new Font("Serif",Font.PLAIN,16));
        textPhone.setBounds(200,200,300,30);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Serif",Font.BOLD,16));
        lblPassword.setBounds(30,235,200,30);
        lblPassword.setForeground(Color.white);
        textPassword = new JTextField();
        textPassword.setFont(new Font("Serif",Font.PLAIN,16));
        textPassword.setBounds(200,235,300,30);

        lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setFont(new Font("Serif",Font.BOLD,16));
        lblConfirmPassword.setBounds(30,270,200,30);
        lblConfirmPassword.setForeground(Color.white);
        txtConfirmPassword = new JTextField();
        txtConfirmPassword.setFont(new Font("Serif",Font.PLAIN,16));
        txtConfirmPassword.setBounds(200,270,300,30);


        lblAccountNumber = new JLabel("Account Number");
        lblAccountNumber.setFont(new Font("Serif",Font.BOLD,16));
        lblAccountNumber.setBounds(30,305,200,30);
        lblAccountNumber.setForeground(Color.white);
        txtAccountNumber = new JTextField();
        txtAccountNumber.setFont(new Font("Serif",Font.PLAIN,16));
        txtAccountNumber.setBounds(200,305,300,30);


        lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Serif",Font.BOLD,16));
        lblGender.setBounds(30,400,200,30);
        lblGender.setForeground(Color.white);

        maleYes = new JRadioButton("Male?",true);
        femaleYes = new JRadioButton("Female?",false);
        maleYes.setBounds(200,400,100,30);
        femaleYes.setBounds(350,400,100,30);
        sex = new ButtonGroup();
        sex.add(maleYes);
        sex.add(femaleYes);

        buttonRegistration = new JButton("Register");
        buttonRegistration.setFont(new Font("Serif",Font.BOLD,16));
        buttonRegistration.setBounds(200,470,300,30);

        buttonRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("org.postgresql.Driver");     //for postgresql jdbc driver class
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank_user","postgres","sh0hr@b");

                    String sql = "insert into public.bankuser_info values(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, textFirstName.getText());
                    pstmt.setString(2, textLastName.getText());
                    pstmt.setString(3,textUserName.getText());
                    pstmt.setString(4, textGmail.getText());
                    pstmt.setString(5, textPhone.getText());
                    pstmt.setString(6, textPassword.getText());
                    pstmt.setString(7, txtConfirmPassword.getText());
                    pstmt.setString(8, txtAccountNumber.getText());
                    String gender;
                    if(maleYes.isSelected()){
                        gender = "male";
                    }else{
                        gender = "female";
                    }
                    pstmt.setString(9,gender);

                    //for email validation and user name with update data here
                    EmailValidator emailValidator = new EmailValidator();
                    if(emailValidator.validate(textGmail.getText().trim())){
                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null," Registration Successfully");

                    }else{
                        JOptionPane.showMessageDialog(null,"Please enter email/ set unique user name");
                    }

                    con.close();

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Duplicate email not allowed","Enter valid mail",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonLogin = new JButton("Login");
        buttonLogin.setFont(new Font("Serif",Font.BOLD,16));
        buttonLogin.setBounds(200,505,300,30);
        buttonLogin.setEnabled(false);

        //every element add into window/ panel order on insert
        panelRegistration = new JPanel(null);

        panelRegistration.setBackground(Color.gray);
        panelRegistration.add(lblTitle);
        panelRegistration.add(lblFirstName);
        panelRegistration.add(textFirstName);
        panelRegistration.add(lblLastName);
        panelRegistration.add(textLastName);
        panelRegistration.add(lblUserName);
        panelRegistration.add(textUserName);
        panelRegistration.add(lblGmail);
        panelRegistration.add(textGmail);
        panelRegistration.add(lblPhone);
        panelRegistration.add(textPhone);
        panelRegistration.add(lblPassword);
        panelRegistration.add(lblConfirmPassword);
        panelRegistration.add(textPassword);
        panelRegistration.add(txtConfirmPassword);
        panelRegistration.add(lblAccountNumber);
        panelRegistration.add(txtAccountNumber);
        panelRegistration.add(lblGender);
        panelRegistration.add(maleYes);
        panelRegistration.add(femaleYes);
        panelRegistration.add(buttonRegistration);
        panelRegistration.add(buttonLogin);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panelRegistration);        //thinking //adding JPanel into JFrame through current class object(this)

        buttonRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonLogin.setEnabled(true);
            }
        });

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.singUp.setEnabled(false);
                 RegistrationForm.this.dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
