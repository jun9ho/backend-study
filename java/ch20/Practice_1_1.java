package ch20;

import java.util.Random;
import java.util.Scanner;

public class Practice_1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int A = sc.nextInt();
        
        int Z = sc.nextInt();

        int max = Math.max(A,Z);
        int min = 
        Math.min(A,Z);
        Random rand = new Random();
        for(int i=0;i<10;i++){
            int rn = min + rand.nextInt(max-min+1);
            System.out.println(rn);
        }

    }
}
