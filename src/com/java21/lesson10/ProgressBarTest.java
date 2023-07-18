package com.java21.lesson10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProgressBarTest {

    public static void main(String[] arguments) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ProgressBarFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class ProgressBarFrame extends JFrame {
    private JButton startButton;
    private JProgressBar progressBar;
    private JCheckBox checkBox;
    private JTextArea textArea;
    private SimulatedActivity activity;
    public  static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 200;
    public  ProgressBarFrame() {
        setTitle("ProgressBarTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        textArea = new JTextArea();
        final int MAX = 1000;
        JPanel panel = new JPanel();
        startButton = new JButton("Start");
        progressBar = new JProgressBar(0,MAX);
        progressBar.setStringPainted(true);
        panel.add(startButton);
        panel.add(progressBar);

        checkBox = new JCheckBox("indeterminate");
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                progressBar.setIndeterminate(checkBox.isSelected());
                progressBar.setStringPainted(!progressBar.isIndeterminate());
            }
        });
        panel.add(checkBox);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                startButton.setEnabled(false);
                activity = new SimulatedActivity(MAX);
                activity.execute();
            }
        });
    }
    class SimulatedActivity extends SwingWorker < Void, Integer > {
        private int current;
        private int target;
        public SimulatedActivity(int t) {
            current = 0;
            target = t;
        }

        @Override
        protected Void doInBackground() throws Exception {
            try {
                while (current < target) {
                    Thread.sleep(100);
                    current++;
                    publish(current);
                }
            } catch (InterruptedException e) {}
            return null;
        }
        protected void process(List < Integer > chunks) {
            for (Integer chunk : chunks) {
                textArea.append(chunk + "\n");
                progressBar.setValue(chunk);
            }
        }
        protected void done() {
            startButton.setEnabled(true);
        }

    }
}
