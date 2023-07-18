package com.java21.lesson16;

import java.io.File;
import java.io.FileInputStream;

public class ReadFile {
    public static void main(String[] args) {
        final String fileName = "file1.txt";
        try {
            File objFile = new File(fileName);
            if (objFile.exists() == false) {
                System.out.println("File does not exist!");
                System.exit(0);
            }
            String text;
            int val;
            FileInputStream fileIn = new FileInputStream(objFile);
            System.out.println("Content of the file is: ");
            while ((val = fileIn.read()) != -1) {
                System.out.print((char) val);
            }
            System.out.println();
            fileIn.close();
        } catch (Exception Ex) {
            System.out.println("Exception: " + Ex.toString());
        }
    }
}
