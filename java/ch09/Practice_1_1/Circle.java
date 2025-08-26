package ch09.Practice_1_1;

public class Circle {

    Point p;
    int rad;
    public Circle() {
        p = new Point(0, 0);
        rad = 0;
    }

    public Circle(int x, int y, int r) {
        p = new Point(x, y);
        rad = r;
    }

    public void showCircleInfo() {
        p.showPointInfO();
        System.out.println("radius: " + rad);
        System.out.println("area: " + Math.PI * rad * rad);
    }

}
