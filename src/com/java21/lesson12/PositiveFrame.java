package com.java21.lesson12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PositiveFrame extends JFrame implements FocusListener {
    JTextField[] value = new JTextField[3];
    public PositiveFrame() {
        super("Positive Frame");
        setSize(300,120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        for (int i = 0; i < 3; i++) {
            value[i] = new JTextField("0", 5);
            value[i].addFocusListener(this);
            add(value[i]);
        }
        setVisible(true);

    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.err.println(exc);
        }
    }

    public static void main(String[] arguments) {
        PositiveFrame.setLookAndFeel();
        new PositiveFrame();
    }


    @Override
    public void focusGained(FocusEvent event) {
        checkValue(event.getSource());
    }

    @Override
    public void focusLost(FocusEvent event) {
        checkValue(event.getSource());
    }
     void checkValue(Object source) {
        JTextField field = (JTextField) source;
        try {
            int val = Integer.parseInt(field.getText());
            if (val < 0) {
                val = val * -1;
                field.setText("" + val);
            }
        } catch (NumberFormatException nfe) {
            field.setText("0");
        }
     }
}
