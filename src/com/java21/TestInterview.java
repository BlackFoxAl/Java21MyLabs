package com.java21;

public class TestInterview {
    static String[][] AREA_DIV = {
            {"3", "Fizz"},
            {"5","Buzz"}
    };
    public static void main(String[] arguments) {
        int lowerBound = 0;
        int upperBound = 20;
        String result = "";

        TestInterview inter = new TestInterview();
        for (int i = lowerBound; i <= upperBound; i++) {

            System.out.println(i + " " + inter.returnStr());
        }
    }
    boolean checkNumberDiv(int number, int divided) {

        if ((number % divided) == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    String returnStr() {

        return "";
    }
}
