package ch05;

public class Practice_7_2 {
    public static void main(String[] args) {
        for(int i=1;i<10;i++)
        {
            for(int j=1;j<10;j++)
            {
                if(i+j==9)
                {
                    System.out.print((10*i+j + " "));
                    System.out.println(10*j+i);
                }
            }
        }
    }
}
