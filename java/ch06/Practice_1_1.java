package ch06;

public class Practice_1_1 {
    public static void main(String[] args) {
        int num1= 20;
        int num2 = 7;
        add(num1,num2);
        subtract(num1,num2);
        multiply(num1,num2);
        divide(num1,num2);
    }
    public static void add(int a, int b){
        System.out.println(a+b);
    }
    public static void subtract(int a, int b){
        System.out.println(a-b);
    }
    public static void multiply(int a, int b){
        System.out.println(a*b);
    }
    public static void divide(int a, int b){
        System.out.println(a/b);
        System.out.println(a%b);
    }
}
