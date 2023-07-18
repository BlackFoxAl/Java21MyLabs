package com.java21.lesson11;

import javax.swing.*;
import java.awt.*;

public class AlphabetBorder extends JFrame {
    JButton north = new JButton("North");
    JButton south = new JButton("South");
    JButton east = new JButton("East");
    JButton west = new JButton("West");
    AlphabetPanel alpha = new AlphabetPanel();
    public AlphabetBorder() {
        super("AlphabetBorder");
        setSize(240,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add("North", north);
        add("South", south);
        add("East", east);
        add("West", west);
        add("Center", alpha);
        setVisible(true);
    }
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("avax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.err.println("Couldn't found system " + "look and feel: " + e);
        }
    }
    public static void main(String[] arguments) {
        AlphabetBorder.setLookAndFeel();
        AlphabetBorder frame = new AlphabetBorder();
    }
}
class AlphabetPanel extends JPanel {
    JButton a = new JButton("Alibi");
    JButton b = new JButton("Burglar");
    JButton c = new JButton("Corpse");
    JButton d = new JButton("Deadbeat");
    JButton e = new JButton("Evidence");
    JButton f = new JButton("Fugitive");
    AlphabetPanel() {
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
        setLayout(fl);
        add(a);
        add(b);
        add(c);
        add(d);
        add(e);
        add(f);

    }
}
