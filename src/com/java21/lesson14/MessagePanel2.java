package com.java21.lesson14;

import javax.swing.*;
import java.awt.*;

public class MessagePanel2 extends JPanel {
    GridBagLayout gridbag = new GridBagLayout();
    public MessagePanel2() {
        super();
        GridBagConstraints constraints;
        setLayout(gridbag);

        JLabel toLabel = new JLabel("To: ");
        JTextField to = new JTextField();
        JLabel subjectLabel = new JLabel("Subject: ");
        JTextField subject = new JTextField();
        JLabel ccLabel = new JLabel("cc: ");
        JTextField cc = new JTextField();
        JLabel bccLabel = new JLabel("bcc");
        JTextField bcc = new JTextField();
        JLabel textLabel = new JLabel("Message: ");
        JTextArea text = new JTextArea(4,70);
        JScrollPane scrollPane = new JScrollPane(text);

        addComponent(toLabel,0,0,1,1,10,100,
                GridBagConstraints.NONE, GridBagConstraints.EAST);
        addComponent(to,1,0,9,1,90,100,
                GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
        addComponent(subjectLabel,0,1,1,1,10,100,
                GridBagConstraints.NONE, GridBagConstraints.EAST);
        addComponent(subject,1,1,9,1,90,100,
                GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
        addComponent(ccLabel,0,2,1,1,10,100,
                GridBagConstraints.NONE, GridBagConstraints.EAST);
        addComponent(cc,1,2,4,1,40,100,
                GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
        addComponent(bccLabel,5,2,1,1,10,100,
                GridBagConstraints.NONE, GridBagConstraints.EAST);
        addComponent(bcc,6,2,4,1,40,100,
                GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
        addComponent(textLabel,0,3,1,1,10,100,
                GridBagConstraints.NONE, GridBagConstraints.EAST);
        addComponent(scrollPane,1,3,5,1,90,100,
                GridBagConstraints.BOTH, GridBagConstraints.WEST);
    }

    private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight,
                              int weightx, int weighty, int fill, int anchor) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.fill = fill;
        constraints.anchor = anchor;
        gridbag.setConstraints(component,constraints);
        add(component);
    }
}
