package ch06;

public class Practice_3_1 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(squared(n));
    }   
    public static int squared(int n)
    {
        if(n==1) return 2;
        return 2 * squared(n-1);
    } 
}
