package ch09.Practice_1_1;

public class Point {
    int xPos, yPos;
    public Point(int x, int y)
    {
        xPos = x;
        yPos = y;
    }

    public void showPointInfO(){
        System.out.println("["+xPos+", "+yPos+"]");
    }
}
