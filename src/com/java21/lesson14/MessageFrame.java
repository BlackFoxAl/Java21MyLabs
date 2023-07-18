package com.java21.lesson14;

import javax.swing.*;

public class MessageFrame extends JFrame {
    public MessageFrame() {
        super();
        setSize(380,120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MessagePanel mPanel = new MessagePanel();
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
        MessageFrame.setLookAndFeel();
        new MessageFrame();
    }
}
