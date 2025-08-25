package ch06;

import java.text.DecimalFormat;

public class Practice_2_1 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");

        double radius = 3;
        System.out.println("Area: " + df.format(calculateArea(radius)));
        System.out.println("Circumference: " + df.format(calculateCircumference(radius)));

    }

    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
    public static double calculateCircumference(double radius){
        return 2 * radius * Math.PI;
    }
}
