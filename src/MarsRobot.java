//package com.java21;
class MarsRobot {

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


}
