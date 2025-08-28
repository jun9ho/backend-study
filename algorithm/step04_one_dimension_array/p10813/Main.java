package step04_one_dimension_array.p10813;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp = arr[a-1];
            arr[a-1] = arr[b-1];
            arr[b-1] = tmp; 
        }

        for(int i=0;i<n;i++){
            System.out.print((arr[i]+1)+" ");
        }
    }
}
