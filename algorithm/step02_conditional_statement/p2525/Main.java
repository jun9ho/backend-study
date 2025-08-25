package step02_conditional_statement.p2525;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());

        int time = Integer.parseInt(st.nextToken());

        m = m+time;
        if(m>=60)
        {
            h = h + (m/60);
            m = m%60;
            if(h>23)
            {
                h-=24;
            }
        }
        System.out.println(h + " " + m);

    }
}
