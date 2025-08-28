package step04_one_dimension_array.p10811;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //배열을 만들어
        //그안에서 배열을 추출해서 reverse를해 list.sublist()
        List list = new ArrayList();
        for(int i=0;i<n;i++)
        {
            list.add(i);
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List subList = list.subList(a-1,b);
            Collections.reverse(subList);
        }
        for(int i=0;i<list.size();i++){
            System.out.print(((int)list.get(i)+1)+" ");
        }

    }
}
