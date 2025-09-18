package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11052 {
    public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int card[] = new int[N+1];
        int []D = new int[N+1];
        for(int i=1;i<=N;i++)
        {
            card[i] = Integer.parseInt(st.nextToken());

        }
        D[1] = card[1];

        for(int i=1;i<=N;i++)
        {
            for(int j=0;j<=i;j++)
            {
                    D[i] = Math.max(D[i],D[i-j]+card[j]);
            }

        }
        System.out.println(D[N]);
    }
}
