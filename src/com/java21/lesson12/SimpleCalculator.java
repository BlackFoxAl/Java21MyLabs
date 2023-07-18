package com.java21.lesson12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SetCalculator extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JButton btnPlus, btnMinus, btnMultiply, btnClear;
    JTextField txtField1, txtField2, txtField3;
    public SetCalculator() {
        setLayout(new GridLayout(5,2));
        setTitle("Simple calculator using Swing");
        label1 = new JLabel("Number 1 :",JLabel.LEFT);
        label2 = new JLabel("Number 2 :", JLabel.LEFT);
        label3 = new JLabel("Result :", JLabel.LEFT);
        btnPlus = new JButton("Add");
        btnMinus = new JButton("Subtract");
        btnMultiply = new JButton("Multiply");
        btnClear = new JButton("Clear");
        btnPlus.addActionListener(this);
        btnMinus.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnClear.addActionListener(this);
        txtField1 = new JTextField();
        txtField2 = new JTextField();
        txtField3 = new JTextField();
        add(label1,0);
        add(txtField1);
        add(label2);
        add(txtField2);
        add(label3);
        add(txtField3);
        add(btnPlus);
        add(btnMinus);
        add(btnMultiply);
        add(btnClear);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String opt = event.getActionCommand();
        int num1, num2, num = 0;
        num1 = Integer.parseInt(txtField1.getText());
        num2 = Integer.parseInt(txtField2.getText());
        if (opt.equals("Add")) {
            num = num1 + num2;
        } else if (opt.equals("Subtract")) {
            num = num1 - num2;
        } else if (opt.equals("Multiply")) {
            num = num1 * num2;
        } else if (opt.equals("Clear")) {
            txtField1.setText("");
            txtField2.setText("");
            txtField3.setText("");
        }
        txtField3.setText(Integer.toString(num));
    }
}
public class SimpleCalculator {
    public static void main(String[] arguments) {
        SetCalculator demo = new SetCalculator();
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.setVisible(true);
        demo.setSize(300,500);
    }
}
