package com.java21.lesson14;

import javax.swing.*;

public class MessageFrame2 extends JFrame {
    public MessageFrame2() {
        super();
        setSize(440,320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MessagePanel2 mPanel = new MessagePanel2();
        add(mPanel);
        setVisible(true);
    }
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.err.println("Look and feel error: " + exc.getMessage());
        }
    }
    public static void main(String[] arguments) {
        MessageFrame2.setLookAndFeel();
        new MessageFrame2();
    }
}
