package com.java21.lesson5;

public class MarsRobot {
    String status;
    int speed;
    float temperature;
    MarsRobot(String inStatus, int inSpeed, float inTemperature){
        status = inStatus;
        speed = inSpeed;
        temperature = inTemperature;
    }

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

        MarsRobot spirit = new MarsRobot("exploring",2,-60);
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

        MarsRobot opportunity = new MarsRobot("exploring",3,-30);
        opportunity.showAttribute();


    }
}
