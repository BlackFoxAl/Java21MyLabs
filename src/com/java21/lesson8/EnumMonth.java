package com.java21.lesson8;

public class EnumMonth {

        enum Months { JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC }
        public static void main(String[] args) {
            System.out.println("The enum values:");
            System.out.println("\n");
            for (Months month : Months.values()) {
                System.out.print(month + " ");
            }
        }

}
