package com.java21.lesson12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator2 extends JFrame implements ActionListener {
    JTextField one = new JTextField("0",5);
    JButton plusOrMinus = new JButton("+");
    JTextField two = new JTextField("0", 5);
    JButton equals = new JButton("=");
    JLabel result = new JLabel("");

    public Calculator2() {
        super("Add or subtract two number");
        setSize(400, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        plusOrMinus.addActionListener(this);
        equals.addActionListener(this);
        add(one);
        add(plusOrMinus);
        add(two);
        add(equals);
        add(result);
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
        Calculator2.setLookAndFeel();
        new Calculator2();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == equals) {
            try {
                int value1 = Integer.parseInt(one.getText());
                int value2 = Integer.parseInt((two.getText()));
                if (plusOrMinus.getText().equals("+")) {
                    result.setText("" + (value1 + value2));
                } else {
                    result.setText(("" + (value1 - value2)));
                }
            } catch (NumberFormatException nfe) {
                one.setText("0");
                two.setText("0");
                result.setText("0");
            }
        }
        if (event.getSource() == plusOrMinus) {
            if (plusOrMinus.getText().equals("+")) {
                plusOrMinus.setText("-");
            } else {
                plusOrMinus.setText("+");
            }
        }
    }
}
