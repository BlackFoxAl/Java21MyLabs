package com.java21.lesson13;

import javax.swing.*;
import java.awt.*;

public class Rectangle extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0,0,255));
        g2d.fillRect(50,80,90,60);
    }
    public static void main(String[] arguments) {
        Rectangle rect = new Rectangle();
        JFrame frame = new JFrame("Rectangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360,300);
        frame.add(rect);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
