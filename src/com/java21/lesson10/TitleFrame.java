package com.java21.lesson10;

import javax.swing.*;

public class TitleFrame extends JFrame {
    public TitleFrame() {
        super("TitleFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(300,200);
        setVisible(true);
        String response = JOptionPane.showInputDialog(null, "Enter a Title your frame");
        setTitle(response);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Couldn't use the system" + "look and feel: " + e);
        }
    }
    public static void main(String[] arguments) {
        TitleFrame frame = new TitleFrame();
    }
}

