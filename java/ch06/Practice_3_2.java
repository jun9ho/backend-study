package ch06;

public class Practice_3_2 {
    public static void main(String[] args) {
        int n = 150;
        binary(n);
    }
    public static void binary(int n)
    {
        if(n==1) {
            System.out.print("1");
            return;
        }
        binary(n/2);
        System.out.print(n%2);
    }
}
