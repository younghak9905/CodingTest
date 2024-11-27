package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++)
        {
            int N = Integer.parseInt(br.readLine());
            int [][]D = new int[2][N+1];
            int [][]A = new int[2][N+1];
            for(int i=0;i<2;i++)
            {   st = new StringTokenizer(br.readLine());
                for(int j=1;j<=N;j++)
                {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            D[0][0]=A[1][0]=0;
            D[0][1]=A[0][1];
            D[1][1]=A[1][1];
            for(int i=2;i<=N;i++)
            {
                D[0][i]= Math.max(D[1][i-1],D[1][i-2])+A[0][i];
                D[1][i]=Math.max(D[0][i-1],D[0][i-2])+A[1][i];
            }
            sb.append(Math.max(D[0][N],D[1][N])+"\n");

        }
        System.out.print(sb);
    }
}
