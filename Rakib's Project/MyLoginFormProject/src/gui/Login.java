package gui;

import gui.LoginFrame;

import javax.swing.*;
import java.awt.*;

public class Login {
    public static void main(String[] args) {

        LoginFrame frame = new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(0,0,450,600);
        frame.setResizable(false);
        frame.setBackground(Color.RED);
    }
}
