package applicationDBMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author (Andrew Napier, Sikander Singh)
 * @version (December 18th, 2012)
 */
public class MonthlyData extends JFrame
{
    private JLabel title, stitle, l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    private JLabel l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29;
    private JLabel Usage,Estimated,solu1,solu2,total2;
    private JPanel  panel1, panel2, panel3, panel4, panel5, panel6, panel7;
    String[] deviceStrings = { "Blackberry", "Other", "Internetstick"};
    String[] date = { "Day", "Week", "Month"};
    public double email2 = 0;
    public double email1;
    static final int email50 = 50;
    static final int email100 = 100;
    static final int email150 = 150;
    static final int email200 = 200;
    static final int email250 = 250;
    static final int email300 = 300;
    public JSlider Email = new JSlider(0,300,0);
    public JSlider Web = new JSlider(0,500,0);
    public JSlider IM = new JSlider(0,500,0);
    public JSlider Video = new JSlider(0,300,0);
    public JSlider Song = new JSlider(0,200,0);
    public  JSlider App_G = new JSlider(0,100,0);
    public String currentdate;
    public double emailvalue;
    public MonthlyData ()
    {
        super ("MonthlyData");
        setSize (1000,1100);
        ////////////////////////////////////////////////////// panel1
        panel1 = new JPanel ();
        panel1.setLayout (new GridLayout(1,1));
        panel1.setVisible(true);
        panel1.setBackground (Color.black);
        title = new JLabel ("                                     WANNA KNOW HOW MUCH DATA",JLabel.LEFT);
        title.setForeground(Color.white);
        title.setFont (new Font("Times New Roman",Font.BOLD,25));
        l1 = new JLabel ("");
        l2 = new JLabel ("");
        /////////////////////////////////////////////// panel2
        panel2 = new JPanel ();
        panel2.setLayout (new GridLayout(1,1));
        panel2.setVisible(true);
        panel2.setBackground (Color.gray);
        stitle = new JLabel ("           PICK A PHONE OR INTERNET STICK AND THEN DRAG THE .",JLabel.LEFT);
        stitle.setForeground(Color.black);
        stitle.setFont (new Font("Times New Roman",Font.BOLD,14));
        //////////////////////////////////////////////// panel3
        panel3 = new JPanel ();
        panel3.setLayout (new FlowLayout());
        panel3.setVisible(true);
        panel3.setBackground (Color.white);
        l3 = new JLabel ("Select Your Device:",JLabel.RIGHT);
        l3.setForeground(Color.red);
        JComboBox devicelist = new JComboBox (deviceStrings);
        l4 = new JLabel ("Tell us how much of what's listed here you think you'll use:");
        ///////////////////////////////////////////////// panel4
        panel4 = new JPanel ();
        panel4.setLayout (new GridLayout(6,7));
        panel4.setVisible(true);
        panel4.setBackground (Color.white);
        l5 = new JLabel ("Email");
        l6 = new JLabel ("WebPage");
        l7 = new JLabel ("Instant Message");
        l8 = new JLabel ("Streaming Video");
        l9 = new JLabel ("Song");
        l10 = new JLabel ("Application or Game");
        l11 = new JLabel (""+" Emails");
        final JComboBox date1 = new JComboBox (date);
        date1.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) date1.getSelectedItem();//get the selected item
                switch (s) {//check for a match
                    case "Day":
                        emailvalue = 30;
                        break;
                    case "Week":
                        emailvalue = 4;
                        break;
                    case "Month":
                        emailvalue = 1;
                        System.out.println("Month selected, emailvalue:" + emailvalue);
                        break;
                }
            }
        });

        l12 = new JLabel ("   0.002 MB");
        l13 = new JLabel (""+email2+" MB");
        double web1 = 0;
        l14 = new JLabel (""+web1+" WebPages");
        JComboBox date2 = new JComboBox (date);
        l15 = new JLabel ("  0.07 MB");
        double web2 = 0;
        l16 = new JLabel (""+web2+" MB");
        double IM1 = 0;
        l17 = new JLabel (""+IM1+" IMs");
        JComboBox date3 = new JComboBox (date);
        l18 = new JLabel ("  0.005 MB");
        double IM2 = 0;
        l19 = new JLabel (""+IM2+" MB");
        double video1 = 0;
        l20 = new JLabel (""+video1+" Minutes");
        JComboBox date4 = new JComboBox (date);
        l21 = new JLabel ("   1 MB");
        double video2 = 0;
        l22 = new JLabel (""+video2+" MB");
        double song1 = 0;
        l23 = new JLabel (""+song1+" MP3's");
        JComboBox date5 = new JComboBox (date);
        l24 = new JLabel ("    4 MB");
        double song2 = 0;
        l25 = new JLabel (""+song2+" MB");
        double app1 = 0;
        l26 = new JLabel (""+app1+" App/Games");
        JComboBox date6 = new JComboBox (date);
        l27 = new JLabel ("   0.44 MB");
        double app2 = 0;
        l28 = new JLabel (""+app2+" MB");
        //////////////////////////////////////////////// panel5
        panel5 = new JPanel ();
        panel5.setLayout (new GridLayout(1,1));
        panel5.setVisible(true);
        panel5.setBackground (Color.white);
        solu1 = new JLabel ("WE THINK YOUR MONTHLY DATA USAGE WILL BE:");
        solu1.setForeground (Color.red);
        solu1.setFont (new Font("Times New Roman",Font.BOLD,20));
        double total = 0;
        total2 = new JLabel (""+total+" MB");
        total2.setForeground (Color.red);
        total2.setFont (new Font("Times New Roman",Font.BOLD,20));
        /////////////////////////////////////////// panel6
        panel6 = new JPanel ();
        panel6.setLayout (new GridLayout (1,1));
        panel6.setVisible (true);
        panel6.setBackground (Color.white);
        Usage = new JLabel ("Usage per unit");
        Usage.setForeground (Color.red);
        Estimated = new JLabel ("     Estimated total");
        Estimated.setForeground (Color.red);
        ////////////////////////////////////////////// panel7
        panel7 = new JPanel ();
        panel7.setLayout (new GridLayout (1,1));
        panel7.setVisible (true);
        panel7.setBackground (Color.white);
        solu2 = new JLabel ("Data usage varies by device and other factors and the .");
        solu2.setForeground (Color.black);
        /////////////////////////////////////////////////// Implements
        Container container = getContentPane ();
        container.setLayout (null);      //changed
        container.setBackground (Color.white);

        container.add (panel1).setBounds (0,0,1000,120);        //panel1
        panel1.add (title).setSize(500,500);

        container.add (panel2).setBounds (0,100,1000,120);      //panel2
        panel2.add (stitle);

        container.add (panel3).setBounds (0,220,1000,100);      //panel3
        panel3.add (l3);
        panel3.add (devicelist);
        panel3.add (l4);

        container.add (panel4).setBounds (0,340,1000,150);      //panel4
        Email.addChangeListener(new SliderHandler());
        Web.addChangeListener(new SliderHandler());
        IM.addChangeListener(new SliderHandler());
        Video.addChangeListener(new SliderHandler());
        Song.addChangeListener(new SliderHandler());
        App_G.addChangeListener(new SliderHandler());

        panel4.add (l5);
        panel4.add (Email);
        panel4.add (l11);
        panel4.add (date1);
        panel4.add (l12);
        panel4.add (l13);
        panel4.add (l6);
        panel4.add (Web);
        panel4.add (l14);
        panel4.add (date2);
        panel4.add (l15);
        panel4.add (l16);
        panel4.add (l7);
        panel4.add (IM);
        panel4.add (l17);
        panel4.add (date3);
        panel4.add (l18);
        panel4.add (l19);
        panel4.add (l8);
        panel4.add (Video);
        panel4.add (l20);
        panel4.add (date4);
        panel4.add (l21);
        panel4.add (l22);
        panel4.add (l9);
        panel4.add (Song);
        panel4.add (l23);
        panel4.add (date5);
        panel4.add (l24);
        panel4.add (l25);
        panel4.add (l10);
        panel4.add (App_G);
        panel4.add (l26);
        panel4.add (date6);
        panel4.add (l27);
        panel4.add (l28);
        container.add (panel5).setBounds (210,540,1000,50);    // panel5
        panel5.add (solu1);
        panel5.add (total2);
        container.add (panel6).setBounds (670,220,200,220);      // panel6
        panel6.add (Usage);
        panel6.add (Estimated);

        container.add (panel7).setBounds (210,580,530,50);    // panel7
        panel7.add (solu2);

        Email.setOpaque(false);
        Web.setOpaque(false);
        IM.setOpaque(false);
        Video.setOpaque(false);
        Song.setOpaque(false);
        App_G.setOpaque(false);
        setVisible (true);
    }

    public static void main (String[] args)
    {
        MonthlyData application = new MonthlyData ();
    }

    public class SliderHandler implements ChangeListener
    {
        public void stateChanged(ChangeEvent e)
        {
            if (e.getSource().equals(Email))
            {
                l11.setText(""+Email.getValue());
                email2= (Email.getValue() * 0.002);
                l13.setText(email2 + "MB");
            }
            if (e.getSource().equals(Web))
            {
                l14.setText(""+Web.getValue());
            }
            if (e.getSource().equals(IM))
            {
                l17.setText(""+IM.getValue());
            }
            if (e.getSource().equals(Video))
            {
                l20.setText(""+Video.getValue());
            }
            if (e.getSource().equals(Song))
            {
                l23.setText(""+Song.getValue());
            }
            if (e.getSource().equals(App_G))
            {
                l26.setText(""+App_G.getValue());
            }
        }
    }

    public void paint (Graphics g)
    {
        super.paint(g);
    }
}
