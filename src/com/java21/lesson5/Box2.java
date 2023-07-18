package com.java21.lesson5;

import java.awt.Point;

public class Box2 {
    int x1, x2, y1, y2 = 0;

    Box2(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1;
        this.y2 = y2;
    }
    Box2(Point topLeft, Point bottomRight){
        this(topLeft.x,topLeft.y,bottomRight.x,bottomRight.y);
    }
    Box2(Point topLeft, int weight, int height){
        this(topLeft.x,topLeft.y,(topLeft.x + weight),(topLeft.y + height));
    }

    void printBox(){
        System.out.print("Box: < " + x1 + ", " + y1);
        System.out.println(", " + x2 + ", " + y2 + " >");
    }

    public static void main(String[] arguments){
        Box2 rect;
        System.out.println("Calling buildBox with coordinates (25,25) (50,50)");
        rect = new Box2(25,25,50,50);
        rect.printBox();

        System.out.println("\nCalling buildBox with Points (10,10) (20,20)");
        rect = new Box2(new Point(10,10),new Point(20,20));
        rect.printBox();

        System.out.println("\nCalling buildBox with Points (10,10) w 50 h 50)");
        rect = new Box2(new Point(10,10),50,50);
        rect.printBox();
    }
}
