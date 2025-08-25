package step02_conditional_statement.p2753;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int year = Integer.parseInt(st.nextToken());
        if((year%4==0)&&(year%100!=0)||(year%400==0))
        {
            System.out.println("1");    
        }
        else
        {
            System.out.println("0");
        }
    }
}
