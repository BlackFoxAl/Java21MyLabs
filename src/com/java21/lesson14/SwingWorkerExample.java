package com.java21.lesson14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SwingWorkerExample extends JFrame {
    private JTextArea textArea;
    public SwingWorkerExample() {
        super("Java SwingWorker Example");
        init();
    }
    private void init() {
        setSize(400,400);
        setLayout(new GridLayout(1,5));
        textArea = new JTextArea();
        add(textArea);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
    public static void main(String[] arguments) throws Exception {
        SwingWorkerExample ui = new SwingWorkerExample();
        EventQueue.invokeLater(()-> {
            ui.setVisible(true);
        });
        int n = 1000;
        EvenNumbersTask task = new EvenNumbersTask(ui.textArea, n);
        task.execute();
        System.out.println(task.get());
    }
}
