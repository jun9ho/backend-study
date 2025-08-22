package ch05;

public class Practice_7_1 {
    public static void main(String[] args) {
        for(int i=2;i<=8;i+=2)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }
}
