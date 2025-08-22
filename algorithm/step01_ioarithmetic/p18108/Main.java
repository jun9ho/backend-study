package step01_ioarithmetic.p18108;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int year = Integer.parseInt(st.nextToken());
        sb.append(year-543);
        System.out.println(sb);

    }
}
