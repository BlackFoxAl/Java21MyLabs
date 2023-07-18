package com.java21.lesson4;

public class HalfDollars {
    public static void main(String[] arguments){
        int[] denver = {2_100_000, 2_900_000, 6_100_000};
        int[] philadelfia = new int[denver.length];
        int[] total = new int[denver.length];
        int average;
        philadelfia[0] = 2_100_000;
        philadelfia[1] = 1_800_000;
        philadelfia[2] = 4_800_000;

        total[0] = denver[0] + philadelfia[0];
        total[1] = denver[1] + philadelfia[1];
        total[2] = denver[2] + philadelfia[2];
        average = (total[0] + total[1] + total[2])/3;
        System.out.print("2016 production: ");
        System.out.format("%,d%n", total[0]);
        System.out.print("2017 production:");
        System.out.format("%,d%n", total[1]);
        System.out.print("2018 production:");
        System.out.format("%,d%n", total[2]);
        System.out.print("Average production:");
        System.out.format("%,d%n", average);

    }
}
