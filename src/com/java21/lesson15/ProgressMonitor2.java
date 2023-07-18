package com.java21.lesson15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProgressMonitor2 extends JFrame {
    JProgressBar current;
    int num = 0;
    boolean done = false;
    public ProgressMonitor2() {
        super("Progress Monitor 2");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                // user has trying to close window
                if (done) {
                    // allow it
                    dispose();
                    System.exit(0);
                }
            }
        });
        setSize(400,100);
        setLayout(new FlowLayout());
        current = new JProgressBar(0,2000);
        current.setValue(0);
        current.setStringPainted(true);
        current.setPreferredSize(new Dimension(360,48));
        add(current);
        setVisible(true);
        iterate();
    }
    public final void iterate() {
        while (num < 2000) {
            current.setValue(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            num += 95;
        }
        done = true;
    }
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.err.println(exc);
        }
    }
    public static void main(String[] arguments) {
        ProgressMonitor2.setLookAndFeel();
        new ProgressMonitor2();
    }
}
