package com.java21.lesson14;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EvenNumbersTask extends SwingWorker < List < Integer >, Integer > {
    private final int numbersToFind;
    private final JTextArea textArea;
    EvenNumbersTask(JTextArea textArea, int numbersToFind) {
        this.numbersToFind = numbersToFind;
        this.textArea = textArea;
    }
    @Override
    public List < Integer > doInBackground() {
        final List<Integer> result = new ArrayList<>();
        boolean interrupted = false;
        for (int i = 2; !interrupted && (i < numbersToFind); i += 2) {
            interrupted = doIntenseComputing();
            result.add(i);
            publish(i);
        }
        return result;
    }
    private boolean doIntenseComputing() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return true;
        }
        return false;
    }
    @Override
    protected void process(List < Integer > chunks) {
        for (int number: chunks) {
            textArea.append((number + "\n"));
        }
    }
}

