package ch06;

public class Practice_1_2 {
    public static void main(String[] args) {
        
        int num1= 10;
        int num2 = 20;
        abs(num1,num2);
        abs(num2,num1);
    }

    public static void abs(int a, int b)
    {
        if(a>b)
            System.out.println(a-b);
        else
            System.out.println(b-a);
    }
}
