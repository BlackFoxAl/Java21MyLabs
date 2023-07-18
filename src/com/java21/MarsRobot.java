package com.java21;

public class MarsRobot {
    String status;
    int speed;
    float temperature;

    void checkTemperature() {
        if (temperature < -80) {
            status = "Return home";
            speed = 5;
        }
    }

    void showAttribute() {
        System.out.println("Status: " + status);
        System.out.println("Speed: " + speed);
        System.out.println("Temperature " + temperature);
    }

    public static void main(String[] arguments) {

        MarsRobot spirit = new MarsRobot();
        spirit.status = "exploring";
        spirit.speed = 2;
        spirit.temperature = -60;

        spirit.showAttribute();
        System.out.println("Increasing speed to 3.");
        spirit.speed = 3;
        spirit.showAttribute();
        System.out.println("Changing temperature to -90.");
        spirit.temperature = -90;
        spirit.showAttribute();
        System.out.println("Checking temperature.");
        spirit.checkTemperature();
        spirit.showAttribute();

        MarsRobot opportunity = new MarsRobot();
        opportunity.status = "exploring";
        opportunity.speed = 3;
        opportunity.temperature = -30;
        opportunity.showAttribute();


    }
}
