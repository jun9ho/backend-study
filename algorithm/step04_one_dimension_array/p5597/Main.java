package step04_one_dimension_array.p5597;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[30];
        for (int i = 0; i < 28; i++) {
            int k = Integer.parseInt(br.readLine());
            k--;
            arr[k] = true;
        }
        for (int i = 0; i < 30; i++) {
            if(arr[i]==false) System.out.println(i+1);
        }
    }
}