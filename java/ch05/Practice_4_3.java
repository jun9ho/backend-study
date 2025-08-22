package ch05;

public class Practice_4_3 {
    public static void main(String[] args) {
        int n=1;
        int sum=0;
        while(n<=1000)
        {
            if((n%2==0)||(n%7==0))
            {
                System.out.println(n);
                sum+=n;
            }
            n++;
        }
        System.out.println(sum);
    }
}
