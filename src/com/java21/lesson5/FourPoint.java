package com.java21.lesson5;

import java.awt.*;

public class FourPoint extends Point {

    int z;
    int time;

    FourPoint(int x, int y, int inZ, int inTime) {
        super(x,y);
        this.z = inZ;
        this.time = inTime;
    }
    void printFourPoint() {
        System.out.println(x + " " + y + " " + z + " " + time);
    }

    public static void main(String[] arguments) {
        FourPoint fourPoint = new FourPoint(3,5,7,12);
        fourPoint.printFourPoint();
    }
}
