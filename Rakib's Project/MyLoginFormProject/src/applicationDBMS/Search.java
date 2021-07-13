package applicationDBMS;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
@SuppressWarnings("serial")
public class Search extends JFrame implements ActionListener {

    JLabel lb, lb1, lb2, lb3, lb4, lb5;
    JTextField tf1, tf2, tf3, tf4, tf5;
    JButton btn;

    Search() {

        super("Fetching Student Information");
        lb5 = new JLabel("Book's Name:");
        lb5.setBounds(20, 20, 100, 20);
        tf5 = new JTextField(20);
        tf5.setBounds(130, 20, 200, 20);
        btn = new JButton("Submit");
        btn.setBounds(50, 50, 100, 20);
        btn.addActionListener(this);
        lb = new JLabel("E-searching System in Library");
        lb.setBounds(30, 80, 450, 30);
        lb.setForeground(Color.blue);
        lb.setFont(new Font("Arial", Font.BOLD, 20));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        lb1 = new JLabel("Book's Name:");
        lb1.setBounds(20, 120, 100, 20);
        tf1 = new JTextField(50);
        tf1.setBounds(130, 120, 200, 20);
        lb2 = new JLabel("Writer:");
        lb2.setBounds(20, 150, 100, 20);
        tf2 = new JTextField(100);
        tf2.setBounds(130, 150, 200, 20);
        lb3 = new JLabel("Shelf no:");
        lb3.setBounds(20, 180, 100, 20);
        tf3 = new JTextField(50);
        tf3.setBounds(130, 180, 200, 20);
        lb4 = new JLabel("Available Piece:");
        lb4.setBounds(20, 210, 100, 20);
        tf4 = new JTextField(50);
        tf4.setBounds(130, 210, 100, 20);
        setLayout(null);

        add(lb5);
        add(tf5);
        add(btn);
        add(lb);
        add(lb1);
        add(tf1);
        add(lb2);
        add(tf2);
        add(lb3);
        add(tf3);
        add(lb4);
        add(tf4);

        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
    }

    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent e) {

        try {
            String str = tf5.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empp", "root", "1310606998");
                PreparedStatement st = con.prepareStatement("select * from empp.em where uname=?");
                st.setString(1, str);

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String s = rs.getString(1);
                    String s1 = rs.getString(2);
                    String s2 = rs.getString(3);
                    String s3 = rs.getString(4);

                    tf1.setText(s);
                    tf2.setText(s1);
                    tf3.setText(s2);
                    tf4.setText(s3);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry,This book is not available");
                }
            } catch (Exception e1) {

            }


        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String args[]) {
        new Search();
    }
}
