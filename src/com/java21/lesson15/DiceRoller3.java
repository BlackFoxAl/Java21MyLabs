package com.java21.lesson15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

public class DiceRoller3 extends JFrame {
    // the table for dice-roll results
    JTextField[] total = new JTextField[16];

    // the roll buttons
    JButton roll;

    // the number of times to roll
    JTextField quantity;

    // the Swing worker
     class DiceWorker extends SwingWorker {
        int timesToRoll;
        // set up the Swing worker
        DiceWorker(int timesToRoll) {
            super();
            this.timesToRoll = timesToRoll;
        }

        // define the task the worker performs
        @Override
        protected int[] doInBackground() {
            int[] result = new int[16];
            for (int i = 0; i < this.timesToRoll; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += Math.floor(Math.random() * 6);
                }
                result[sum] = result[sum] + 1;
            }
            // transit the result
            return result;
        }
    }
    DiceRoller3.DiceWorker worker;

    public DiceRoller3() {
        super("DiceRoller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850,145);

        //set up top row
        JPanel topPane = new JPanel();
        GridLayout paneGrid = new GridLayout(1,16);
        topPane.setLayout(paneGrid);
        for (int i = 0; i < 16; i++) {

            // create textfield and label
            total[i] = new JTextField("0",4);
            JLabel label = new JLabel((i + 3) + ": ");

            // create this cell in the grid
            JPanel cell = new JPanel();
            cell.add(label);
            cell.add(total[i]);

            // add this cell to the top row
            topPane.add(cell);
        }

        // set up bottom row
        JPanel bottomPane = new JPanel();
        JLabel quantityLabel = new JLabel("Times to Roll: ");
        quantity = new JTextField("0",5);
        roll = new JButton("Roll");

        // respond when the worker's task is complete
        PropertyChangeListener prop = (event) -> {
            try {
                // get the worker's dice-roll results
                int[] result = (int[]) worker.get();
                // store results in the text fields
                for (int i = 0; i < result.length; i++) {
                    total[i].setText("" + result[i]);
                }
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }
        };

        ActionListener act = (event) -> {
            int timesToRoll;
            try {
                // turn off button
                timesToRoll = Integer.parseInt(quantity.getText());
                roll.setEnabled(false);
                // set up the worker that will roll the dice
                worker = new DiceWorker(timesToRoll);
                //  add a listener that monitors the worker
                worker.addPropertyChangeListener(prop);
                // start the worker
                worker.execute();
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
                nfe.printStackTrace();
            }
        };

        roll.addActionListener(act);
        bottomPane.add(quantityLabel);
        bottomPane.add(quantity);
        bottomPane.add(roll);

        //set up frame
        GridLayout frameGrid = new GridLayout(2,1);
        setLayout(frameGrid);
        add(topPane);
        add(bottomPane);

        setVisible(true);
    }
    // respond when the "Roll" button is clicked



    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            // ignore error
        }
    }
    public static void main(String[] arguments) {
        DiceRoller3.setLookAndFeel();
        DiceRoller3 app = new DiceRoller3();
    }
}
