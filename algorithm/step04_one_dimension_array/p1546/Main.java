package step04_one_dimension_array.p1546;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = -1;
        double[] ary = new double[n];
        for (int i = 0; i < n; i++) {
            double a = Double.parseDouble(st.nextToken());
            max = Math.max(max, a);
            ary[i]=a;
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (ary[i]/max*100);
        }
        System.out.println(sum/n);

    }
}
