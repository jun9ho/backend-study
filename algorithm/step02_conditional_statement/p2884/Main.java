package step02_conditional_statement.p2884;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(m<45)
        {
            m=m+15;
            h=h-1;
            if(h<0)h=23;
        }
        else
        {
            m=m-45;
        }
        System.out.println(h + " " + m);

    }
}
