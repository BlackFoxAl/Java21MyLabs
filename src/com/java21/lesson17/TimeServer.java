package com.java21.lesson17;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer extends Thread {
    private ServerSocket sock;
    public TimeServer() {
        super();
        try {
            sock = new ServerSocket(4415);
            System.out.println("TimeServer running ...");
        } catch (IOException e) {
            System.out.println("Error: couldn't create socket");
            System.exit(1);
        }
    }
    @Override
    public void run() {
        Socket client;
        while (true) {
            if (sock == null) {
                return;
            }
            try {
                client = sock.accept();
                BufferedOutputStream bb = new BufferedOutputStream(client.getOutputStream());
                PrintWriter os = new PrintWriter(bb, false);
                String outLine;

                Date now = new Date();
                os.println(now);
                os.flush();

                os.close();
                client.close();
            } catch (IOException e) {
                System.out.println("Error: couldn't connect");
                System.exit(1);
            }
        }
    }
    public static void main(String[] arguments) {
        TimeServer server = new TimeServer();
        server.start();
    }
}
