package ch07.Practice_1_1;

public class Main {
    
    public static void main(String[] args) {
        
        Triangle triangle = new Triangle(10, 20);
        System.out.println(triangle.getArea());
        triangle.changeHeight(30);
        triangle.changeWidth(40);
        System.out.println(triangle.getArea());
    }
}
