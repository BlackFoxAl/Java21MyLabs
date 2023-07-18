package com.java21.lesson3;

public class Birthday {
    public static void main(String[] arguments){
        String birthday = "03/11/1974";
        String day, month, year;
        day = birthday.substring(0,birthday.indexOf('/'));
        month = birthday.substring(birthday.indexOf('/')+1, birthday.lastIndexOf('/'));
        year = birthday.substring((birthday.lastIndexOf('/')+1));
        System.out.println(day);
        System.out.println(month);
        System.out.println(year);

    }
}
