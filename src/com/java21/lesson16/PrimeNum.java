package com.java21.lesson16;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimeNum {
    public static boolean isPrime(int x) {
        if (x == 0 || x == 1) return false;
        int j = 2;
        while (x > j) {
            if (x % j == 0) return false;
            j++;
        }
        return true;
    }
    public static void main(String[] arg) throws IOException {
        File file = new File("prime.txt");
        if (file.exists() && file.isFile()) {
            System.out.println("File already exists");
        } else {
            if (file.createNewFile()) {
                System.out.println("Created successfully");
            }
        }
        PrintWriter printWriter = new PrintWriter(file);
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                printWriter.write(i + "\r\n");
            }
        }
        printWriter.close();
    }
}
