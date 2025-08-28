package step04_one_dimension_array.p2562;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1,cnt=-1;
        for(int i=0;i<9;i++){
            int a = Integer.parseInt(br.readLine());
            if(a>max){
                max =a;
                cnt=i+1;
            }
        }
        System.out.println(max);
        System.out.println(cnt);
    }
}