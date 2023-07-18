package com.java21.lesson13;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends JFrame {
    public Circle(String argR, String argX, String argY, String argColor) {
        super("Circle");
        setSize(350,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CirclePanel cp = new CirclePanel(argR, argX, argY, argColor);
        add(cp);
        setVisible(true);
    }
    public static void main(String[] arguments) {
        if (arguments.length < 3) {
            System.out.println("Usage: java Circle radius x y color");
        } else {
            new Circle(arguments[0], arguments[1], arguments[2], arguments[3]);
        }
    }
}
class CirclePanel extends JPanel {
    int x,y, radius;
    Color color;
    public CirclePanel(String inRadius, String inX, String inY, String inColor) {
        super();
        if (inRadius == null)
            radius = 100;
        if (inX == null)
            x = 110;
        if (inY == null)
            y = 110;
        if (inColor == null)
            color = Color.blue;
        try {
            radius = Integer.parseInt(inRadius);
            x = Integer.parseInt(inX);
            y = Integer.parseInt(inY);
            color = Color.decode(inColor);
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics comp) {
        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(Color.WHITE);
        comp2D.fillRect(0,0,getSize().width,getSize().height);
        comp2D.setColor(color);
        Ellipse2D.Float circle = new Ellipse2D.Float(x, y, radius, radius);
        comp2D.fill(circle);
    }
}
