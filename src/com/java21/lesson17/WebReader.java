package com.java21.lesson17;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebReader extends JFrame {
    JTextArea box = new JTextArea("Getting data ...");
    public WebReader() {
        super("Get File Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        JScrollPane pane = new JScrollPane(box);
        add(pane);
        setVisible(true);
    }
    void getData(String address) throws MalformedURLException {
        setTitle(address);
        URL page =  new URL(address);
        StringBuilder text = new StringBuilder();
        try {
            HttpURLConnection conn = (HttpURLConnection) page.openConnection();
            conn.connect();

            String key;
            String header;
            int i = 0;
            do {
                key = conn.getHeaderFieldKey(i);
                header = conn.getHeaderField(i);
                if (key == null) {
                    key = "";
                } else {
                    key = key + ": ";
                }
                if (header != null) {
                    text.append(key);
                    text.append(header);
                    text.append("\n");
                }
                i++;
            } while (header != null);
            text.append("\n");


            InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
            BufferedReader buff =  new BufferedReader(in);
            box.setText("Getting data ...");
            String line;
            do {
                line = buff.readLine();
                text.append(line);
                text.append("\n");
            } while (line != null);
            box.setText(text.toString());
        } catch (IOException ioe) {
            System.out.println("IO Error: " + ioe.getMessage());
        }
    }
    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("Usage: java WebReader url");
            System.exit(1);
        }
        try {
            WebReader app = new WebReader();
            app.getData(arguments[0]);
        } catch (MalformedURLException mue) {
            System.out.println("Bad URL: " + arguments[0]);
        }
    }
}
