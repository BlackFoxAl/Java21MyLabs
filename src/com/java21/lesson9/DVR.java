package com.java21.lesson9;

import javax.swing.*;

public class DVR extends JFrame {
    //play, stop/eject, rewind, fast-forward, pause
    JButton play = new JButton("Play");
    JButton stopEject = new JButton("Stop/Eject");
    JButton rewind = new JButton("Rewind");
    JButton fastForward = new JButton("Fast-Forward");
    JButton pause = new JButton("Pause");

    public DVR() {
        super("DVR Buttons");
        setSize(540,80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(play);
        panel.add(stopEject);
        panel.add(rewind);
        panel.add(fastForward);
        panel.add(pause);
        add(panel);
        setVisible(true);

    }
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
    public static void main(String[] arguments) {
        DVR.setLookAndFeel();
        DVR newDvr = new DVR();
    }
}
