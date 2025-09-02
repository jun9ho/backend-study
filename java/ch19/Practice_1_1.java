package ch19;

public class Practice_1_1 {
    public static void main(String[] args) {

    }

}

class Point {
    private int xPos;
    private int yPos;

    public Point(int x, int y) {
        xPos = x;
        yPos = y;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this.xPos == ((Point) obj).xPos) && (this.yPos == ((Point) obj).yPos)) {
            return true;
        } else
            return false;
    }
}

class Rectangle {
    private Point upperLeft;
    private Point lowerRight;

    public Rectangle(int x1, int y1, int x2, int y2) {
        upperLeft = new Point(x1, y1);
        lowerRight = new Point(x2, y2);
    }

    @Override
    public boolean equals(Object obj) {
        if ((upperLeft.equals(((Rectangle) obj).upperLeft))
                && (lowerRight.equals(((Rectangle) obj).lowerRight))) {
            return true;
        } else {
            return false;
        }
    }
}