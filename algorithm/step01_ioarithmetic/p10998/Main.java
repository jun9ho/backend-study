package step01_ioarithmetic.p10998;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        int a = Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        sb.append(a*b);
        System.out.print(sb);

    }
}
