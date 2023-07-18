package com.java21.lesson3;

public class StringChecker {
    public static void main(String[] arguments){
        int accountBalance = 5005;
        double pi = Math.PI;
    //        String str = "You know nothing, Jon Snow";
    //        System.out.println("The string is: " + str);
    //        System.out.println("Length of this string: " + str.length());
    //        System.out.println("The character at position 7: " + str.charAt(7));
    //        System.out.println("The substring from 9 to 16: " + str.substring(9,16));
    //        System.out.println("The index of the first 'w': " + str.indexOf('w'));
    //        System.out.println("The index the substring \"Jon\": " + str.indexOf("Jon"));
    //        System.out.println("The string in uppercase: " + str.toUpperCase());

        System.out.format("Balance: $%,d%n",accountBalance);
        System.out.format("%.11f%n",pi);

    }
}
