package step01_ioarithmetic.p1008;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        double a = Double.parseDouble(st.nextToken());
        double b= Double.parseDouble(st.nextToken());
        sb.append(a/b);
        System.out.print(sb);
    }
}
