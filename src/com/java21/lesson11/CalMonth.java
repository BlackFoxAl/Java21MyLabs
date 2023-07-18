package com.java21.lesson11;

import javax.swing.*;
import java.awt.*;

public class CalMonth extends JFrame {
    JLabel[] days;
    JLabel[] dayTitles;
    JLabel monthTitle;
    public CalMonth() {
        super("November 2023");
        this.monthTitle = new JLabel("Novenber 2023");
        this.dayTitles = new JLabel[7];
        this.days = new JLabel[30];
        setSize(260,260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(flow);
        titlePanel.add(monthTitle);
        add(titlePanel);
        JPanel monthPanel = new JPanel();
        GridLayout calLayout = new GridLayout(6,7);
        monthPanel.setLayout(calLayout);
        String[] dayNames = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        for (int i = 0; i < 7; i++) {
            dayTitles[i] = new JLabel(dayNames[i]);
            monthPanel.add(dayTitles[i]);
        }
        for (int i = 0; i < days.length; i++) {
            days[i] = new JLabel("" + (i+1));
            monthPanel.add(days[i]);
        }
        add(monthPanel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.err.println("Couldn't use the system " + "look and feel: " + e);
        }
    }

    public static void main(String[] arguments) {
        CalMonth.setLookAndFeel();
        CalMonth frame = new CalMonth();
    }
}
