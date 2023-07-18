package com.java21;

public class Weather {
    public static void main(String[] arguments){

        float fah = 86;
        System.out.println(fah + " degrees Fahrenheit is ...");
        fah = fah -32;
        fah = fah / 9;
        fah = fah * 5;
        System.out.println(fah + " degrees Celsius/n");

        float cel = 33;
        System.out.println(cel + " degrees Celsius is ...");
//        cel = cel * 9;
//        cel = cel / 5;
//        cel = cel + 32;
        cel = cel * 9 / 5 +32;
        System.out.println(cel + " degrees Fahrenheit");

        int x = 42;
        int y = x++;
        int z = ++x;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);


    }
}
