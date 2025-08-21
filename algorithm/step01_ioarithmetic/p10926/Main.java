package step01_ioarithmetic.p10926;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        String a = st.nextToken();
        sb.append(a+"??!");
        System.out.print(sb);
        
    }
}
