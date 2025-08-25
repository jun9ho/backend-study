package step02_conditional_statement.p9498;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int score = Integer.parseInt(st.nextToken());
        if(score<60){
            System.out.println("F");
        } else if(score<70){
            System.out.println("D");
        } else if(score<80){
            System.out.println("C");
        } else if(score<90){
            System.out.println("B");
        } else {
            System.out.println("A");
        }
    }
}
