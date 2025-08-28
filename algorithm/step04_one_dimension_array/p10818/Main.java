package step04_one_dimension_array.p10818;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 1_000_001, max = -1_000_001;

        for(int i=0;i<n;i++){
            int a = Integer.parseInt(st.nextToken());
            min = Math.min(a,min);
            max = Math.max(a,max);
        }
        System.out.println(min+" "+max);
    }
}