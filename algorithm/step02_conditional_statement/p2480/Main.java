package step02_conditional_statement.p2480;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if ((a == b) && (b == c)) {
            System.out.println(10000 + a * 1000);
        } else if ((a != b) && (b != c) && (c != a)) {
            System.out.println(Math.max(Math.max(a, b), c) * 100);
        } else {
            if (a == b) {
                System.out.println(a* 100+1000);
            } else if (b == c) {
                System.out.println(b* 100+1000);
            } else if (c == a) {
                System.out.println(c* 100+1000);
            }
        }
    }
}
