package GoriconOpenContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_32304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N=3;
        int M=6;
        String query;
        int maxQuotient = 100;
        for(int i=1;i<=maxQuotient;i++)
        {   st= new StringTokenizer(br.readLine());
            query=st.nextToken();
          if(query.equals("?"))
          {
              int x = Integer.parseInt(st.nextToken());
              int response = (N % X);
              System.out.println(response);
              System.out.flush();

          }
            else if(query.equals("!"))
          {
              int a = Integer.parseInt(st.nextToken());
              int b = Integer.parseInt(st.nextToken());
              System.out.println("! "+a+" "+b);
              sb.append(a).append(" ").append(b).append("\n");
          }

        }
        System.out.println(2%M);
    }
}
