package com.java21.lesson9;

import javax.swing.*;

public class PasswordFrame extends JFrame {
    PasswordInnerFrame pass;
    public PasswordFrame() {
        super("Ask Password");
        this.pass = new PasswordInnerFrame();
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pass.setVisible(true);

    }
    public static void main(String[] arguments) {
        PasswordFrame app = new PasswordFrame();
    }
    class PasswordInnerFrame extends JFrame {
        public PasswordInnerFrame() {
            super("Password");
            setSize(300,300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            JLabel usernameLabel = new JLabel("Username:");
            JTextField username = new JTextField(8);
            JLabel passwordLabel = new JLabel("Password:");
            JTextField password = new JTextField(8);
            panel.add(usernameLabel);
            panel.add(username);
            panel.add(passwordLabel);
            panel.add(password);
            add(panel);
            setVisible(false);

        }
    }
}
