package com.java21.lesson11;

import javax.swing.*;
import java.awt.*;

public class Bunch extends JFrame {
    public Bunch() {
        super("Bunch");
        setSize(260,260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        JPanel panel = new JPanel();
        GridLayout family = new GridLayout(3,3,10,10);
        panel.setLayout(family);
        JButton marcia = new JButton("Marcia");
        JButton carol = new JButton("Carol");
        JButton greg = new JButton("Greg");
        JButton jan = new JButton("Jan");
        JButton alice = new JButton("Alice");
        JButton piter = new JButton("Piter");
        JButton sindy = new JButton("Sindy");
        JButton mike = new JButton("Mike");
        JButton bobby = new JButton("Bobby");
        panel.add(marcia);
        panel.add(carol);
        panel.add(greg);
        panel.add(jan);
        panel.add(alice);
        panel.add(piter);
        panel.add(sindy);
        panel.add(mike);
        panel.add(bobby);
        add(panel);
        setVisible(true);
    }

    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.err.println(exc);
        }
    }

    public static void main(String[] arguments) {
        Bunch.setLookAndFeel();
        Bunch frame = new Bunch();
    }

}
