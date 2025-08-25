package step03_loop.p25314;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());

        for(int i=0;i<a/4;i++)
        {  
            System.out.print("long ");
        }
        System.out.print("int");
    }
}