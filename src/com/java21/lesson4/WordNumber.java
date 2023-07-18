package com.java21.lesson4;

public class WordNumber {
    public static void main(String[] arguments){
        if(arguments.length > 0){
            char firstChar = arguments[0].charAt(0);
            char secondChar = arguments[0].charAt(1);
            long number = 0;
            switch (firstChar){
                case 'o':
                number = 1l;
                break;
                case 't':;
                if(secondChar == 'w'){
                    number = 2l;
                }
                if(secondChar == 'h'){
                    number = 3l;
                }
                if(secondChar == 'e'){
                    number = 10l;
                }
                break;
                case 'f':
                    if(secondChar == 'o'){
                        number = 4l;
                    };
                    if(secondChar == 'i'){
                        number = 5l;
                    }
                    break;
                case 's':
                    if(secondChar == 'i'){
                        number = 6l;
                    };
                    if(secondChar == 'e'){
                        number = 7l;
                    }
                    break;
                case 'e':
                    number = 8l;
                    break;
                case 'n':
                    number = 9l;
                    break;
            }
            System.out.println(number);
        }
    }
}
