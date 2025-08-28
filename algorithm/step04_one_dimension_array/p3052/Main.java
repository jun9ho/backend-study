package step04_one_dimension_array.p3052;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[42];
        Map<Integer,Boolean> map = new HashMap();

        for (int i = 0; i < 10; i++) {
            map.put(Integer.parseInt(br.readLine())%42,true);
        }
        System.out.println(map.size());

    }
}
