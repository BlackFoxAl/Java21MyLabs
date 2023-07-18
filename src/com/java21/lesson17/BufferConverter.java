package com.java21.lesson17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class BufferConverter {
    public static void main(String[] arguments) {
        try {
            // read byte data into a byte buffer
            String data = "friends.dat";
            FileInputStream inData = new FileInputStream(data);
            FileChannel inChanel = inData.getChannel();
            long inSize = inChanel.size();
            ByteBuffer source = ByteBuffer.allocate((int) inSize);
            inChanel.read(source,0);
            source.position(0);
            System.out.println("Original byte data:");
            for (int i = 0; source.remaining() > 0; i++) {
                System.out.print(source.get() + " ");
            }
            // convert data into character data
            source.position(0);
            Charset ascii = Charset.forName("US-ASCII");
            CharsetDecoder toAscii = ascii.newDecoder();
            CharBuffer destination = toAscii.decode(source);
            destination.position(0);
            System.out.println("\nNew character data:");
            for (int i = 0; destination.remaining() > 0; i++) {
                System.out.print(destination.get());
            }
            System.out.println();
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
