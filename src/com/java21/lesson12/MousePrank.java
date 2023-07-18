package com.java21.lesson12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MousePrank extends JFrame implements ActionListener {
    public MousePrank() {
        super("Message");
        setSize(420,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout border = new BorderLayout();
        setLayout(border);
        JLabel msg = new JLabel("Click OK to close program");
        add(BorderLayout.NORTH, msg);
        PrankPanel prank = new PrankPanel();
        prank.ok.addActionListener(this);
        add(BorderLayout.CENTER, prank);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    @Override
    public Insets getInsets() {
        return new Insets(40,10,10,10);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.err.println(exc);
        }
    }

    public static void main(String[] arguments) {
        MousePrank.setLookAndFeel();
        new MousePrank();
    }
}

class PrankPanel extends JPanel implements MouseMotionListener {
    JButton ok = new JButton("Ok");
    int buttonX, buttonY, mouseX, mouseY;
    int width, height;
    PrankPanel() {
        super();
        setLayout(null);
        addMouseMotionListener(this);
        buttonX = 110;
        buttonX = 110;
        ok.setBounds(new Rectangle(buttonX,buttonY,70,20));
        add(ok);
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        mouseX = event.getX();
        mouseY = event.getY();
        width = (int) getSize().getWidth();
        height = (int) getSize().getHeight();
       if (Math.abs((mouseX + 35) - buttonX) < 50) {
            buttonX = moveButton(mouseX, mouseY, width);
            repaint();
        }
        if (Math.abs((mouseY + 10) - buttonY) < 50) {
            buttonY = moveButton(mouseX, mouseY, height);
            repaint();
        }

    }

    @Override
    public void mouseDragged(MouseEvent event) {
        // ignore this event
    }


    private int moveButton(int mouseAt, int buttonAt, int bord) {
        if (buttonAt < mouseAt) {
            buttonAt--;
        } else {
            buttonAt++;
        }
        if (buttonAt > bord - 20) {
            buttonAt = 10;
        }
        if (buttonAt < 0) {
            buttonAt = bord - 80;
        }
        return buttonAt;
    }

    @Override
    protected void paintComponent(Graphics comp) {
        super.paintComponent(comp);
        ok.setBounds(buttonX, buttonY, 70, 20);
    }
}
