package com.java21.lesson10;

import javax.swing.*;

public class TabPanels extends JFrame {
    public TabPanels() {
        super("Tab Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(480,218);
        JPanel mainSetting = new JPanel();
        JPanel advancedSetting = new JPanel();
        JPanel privacySetting = new JPanel();
        JPanel emailSetting = new JPanel();
        JPanel securitySetting = new JPanel();
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Main", mainSetting);
        tabs.addTab("Advanced", advancedSetting);
        tabs.addTab("privacy", privacySetting);
        tabs.addTab("E-mail", emailSetting);
        tabs.addTab("Security", securitySetting);
        add(tabs);
        setVisible(true);

    }
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Couldn't use the system " + "look and feel: " +e);
        }
    }
    public static void main(String[] arguments) {
        TabPanels frame = new TabPanels();
    }
}
