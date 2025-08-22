package ch05;

public class Practice_6_2 {
    public static void main(String[] args) {
        int n=1,sum=0;
        while(true)
        {
            sum+=n;
            if(sum>1000)
            {
                System.out.println("n: " + n);
                System.out.println("sum: " + sum);
                break;
            }
            n+=2;
        }  
    }
}
