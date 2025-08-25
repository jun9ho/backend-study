package step02_conditional_statement.p14681;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());

        if(x>0)
        {
            if(y>0)
            {
                System.out.println("1");
            }
            else
            {
                System.out.println("4");
            }
        }
        else
        {
            if(y>0)
            {
                System.out.println("2");
            }
            else
            {
                System.out.println("3");
            }
        }

    }
}
