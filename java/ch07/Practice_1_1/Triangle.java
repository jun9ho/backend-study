package ch07.Practice_1_1;

public class Triangle {
    
    private int width;
    private int height;

    public Triangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height / 2.0;
    }
    
    public void changeHeight(int newHeight)
    {
        this.height = newHeight;
    }

    public void changeWidth(int newWidth)
    {
        this.width = newWidth;
    }
}
