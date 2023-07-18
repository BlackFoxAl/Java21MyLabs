package com.java21.lesson5;

public class Avereger {
    public static void main(String[] arguments){
        int sum = 0;
        if(arguments.length > 0) {
            for (int i = 0; i < arguments.length; i++) {
                sum += Integer.parseInt(arguments[i]);
            }
            System.out.println("SUM: " + sum);
            System.out.println(("Average: " + (float) sum / arguments.length));
        }
    }
}
