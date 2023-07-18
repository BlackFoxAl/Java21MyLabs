package com.java21.lesson10;

import javax.swing.*;
import java.awt.*;

public class ProgressMonitor2 extends JFrame {
    JProgressBar current;
    JTextArea out;
    JButton find;
    JTextField numField;
    int num = 0;

    public ProgressMonitor2() {
        super("Progress Monitor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,125);
        setLayout(new BorderLayout());
        current = new JProgressBar(0,2000);
        current.setValue(0);
        current.setStringPainted(true);
        add(current, BorderLayout.CENTER);
        numField = new JTextField(num);
        add(numField,BorderLayout.SOUTH);
    }

    public void iterate() {
        while (num < 2000) {
            current.setValue(num);
            numField.setText("" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            num += 95;
        }
    }
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] arguments) {
        ProgressMonitor2.setLookAndFeel();
        ProgressMonitor2 frame = new ProgressMonitor2();
        frame.setVisible(true);
        frame.iterate();
    }

}
