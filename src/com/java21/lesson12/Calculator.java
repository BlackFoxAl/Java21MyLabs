package com.java21.lesson12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Calculator extends JFrame implements FocusListener {
    JTextField value1, value2, sum;
    JLabel plus, equals;

    public Calculator() {
        super("Calculator");
        setSize(350,90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        setLayout(flow);
        // create components
        value1 = new JTextField("0",5);
        plus = new JLabel("+");
        value2 = new JTextField("0",5);
        equals = new JLabel("=");
        sum = new JTextField("0",5);
        // add listener
        value1.addFocusListener(this);
        value2.addFocusListener(this);
        // set up sum field
        sum.setEnabled(false);
        // add components
        add(value1);
        add(plus);
        add(value2);
        add(equals);
        add(sum);
        setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent event) {
        try {
            float total = Float.parseFloat(value1.getText()) +
                    Float.parseFloat(value2.getText());
            sum.setText("" + total);
        } catch (NumberFormatException nfe) {
            value1.setText("0");
            value2.setText("0");
            sum.setText("0");
        }
    }

    @Override
    public void focusLost(FocusEvent event) {
        focusGained(event);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.err.println(exc);
        }
    }

    public static void main(String[] arguments) {
        Calculator.setLookAndFeel();
        Calculator frame = new Calculator();
    }
}
