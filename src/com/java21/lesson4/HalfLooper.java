package com.java21.lesson4;

public class HalfLooper{
    public static void main(String[] arguments){
        int[] denver = {2_100_000, 2_900_000, 6_100_000};
        int[] philadelphia= {2_100_000, 1_800_000, 4_800_000};
        int[] total = new int[denver.length];
        int sum = 0;

        for(int i = 0; i < denver.length; i++){
            total[i] = denver[i] + philadelphia[i];
            sum += total[i];
            System.out.print(2016+i + " production: ");
            System.out.format("%,d%n", total[i]);
        }
        System.out.print("Average production:");
        System.out.format("%,d%n", sum / denver.length);
    }
}
