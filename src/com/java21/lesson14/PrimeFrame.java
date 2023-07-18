package com.java21.lesson14;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;

public class PrimeFrame extends JFrame implements PropertyChangeListener {
    PrimeWorker worker;
    JTextArea primeText;
    // create frame
    public PrimeFrame() {
        super("Prime Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        primeText = new JTextArea(10,40);
        primeText.setLineWrap(true);
        JScrollPane pane = new JScrollPane(primeText);
        add(pane);
        pack();
        setVisible(true);

    }
    // add empty insets around the frame
    @Override
    public Insets getInsets() {
        // add insets to the top, left, bottom and right
        return new Insets(40,20,20,20);
    }

    // start the SwingWorker
    public void run() {
        primeText.setText("Running in background...");
        worker = new PrimeWorker();
        worker.addPropertyChangeListener(this);
        worker.execute();
    }

    // receive a signal the worker is done

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        try {
            StringBuilder output = new StringBuilder();
            int[] primes = (int[]) worker.get();
            for (int i = 0; i < primes.length; i++) {
                output.append(primes[i]).append(" ");
            }
            // add the list of primes to the text area
            primeText.setText(output.toString());
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public static void main(String[] arguments) {
        PrimeFrame app = new PrimeFrame();
        app.run();
    }
}
