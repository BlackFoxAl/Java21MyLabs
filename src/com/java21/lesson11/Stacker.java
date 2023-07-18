package com.java21.lesson11;

import javax.swing.*;
import java.awt.*;

public class Stacker extends JFrame {
    public Stacker() {
        super("Stacker");
        setSize(430,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        // create a top panel
        JPanel commandPanel = new JPanel();
        BoxLayout horizontal = new BoxLayout(commandPanel,BoxLayout.X_AXIS);
        commandPanel.setLayout(horizontal);
        JButton subscribe = new JButton("Subscribe");
        JButton unsubscribe = new JButton("Unsubscribe");
        JButton refresh = new JButton("Refresh");
        JButton save = new JButton("Save");
        commandPanel.add(subscribe);
        commandPanel.add(unsubscribe);
        commandPanel.add(refresh);
        commandPanel.add(save);
        // create bottom panel
        JPanel textPanel = new JPanel();
        JTextArea text =  new JTextArea(4,70);
        textPanel.add(text);
        JScrollPane scrollPanel = new JScrollPane(textPanel);
        // put them together
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        add(commandPanel);
        add(scrollPanel);
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
        Stacker.setLookAndFeel();
        Stacker frame = new Stacker();
    }
}
