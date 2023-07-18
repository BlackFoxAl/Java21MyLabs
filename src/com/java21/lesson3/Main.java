package com.java21.lesson3;

class Main {
    public static void main(String[] args) {
        int var1 = 5;
        double var2 = 5.65;

        Integer obj1 = var1;

        Double obj2 = var2;
        if(obj1 instanceof Integer) {
            System.out.println("An object of Integer is created.");
        }
        if(obj2 instanceof Double) {
            System.out.println("An object of Double is created.");
        }
    }
}