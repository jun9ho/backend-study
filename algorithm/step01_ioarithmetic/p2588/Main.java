package step01_ioarithmetic.p2588;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(A * (B % 10));
        System.out.println(A * (B / 10 % 10));
        System.out.println(A * (B / 100));
        System.out.println(A * B);
    }
}
