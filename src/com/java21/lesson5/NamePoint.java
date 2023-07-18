package com.java21.lesson5;

import java.awt.Point;

public class NamePoint extends Point {
    String name;
    NamePoint(int x, int y, String name) {
        super(x,y);
        this.name = name;
    }

    public static void main(String[] arguments) {
        NamePoint np = new NamePoint(5,5,"SmallPoint");
        System.out.println("X: " + np.x);
        System.out.println("Y: " + np.y);
        System.out.println("Name: " + np.name);
    }
}
