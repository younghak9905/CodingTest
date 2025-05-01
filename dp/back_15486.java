package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int [][]A = new int[2][N+2];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            A[0][i] = Integer.parseInt(st.nextToken());
            A[1][i] = Integer.parseInt(st.nextToken());
        }
        int []D = new int[N+2];
        int max = -1;
       for(int i=1;i<=N+1;i++){
           if(max<D[i])
           {
               max = D[i];
           }
           int nxt = i+A[0][i];
           if(nxt<=N+1)
           {
               D[nxt] = Math.max(D[nxt], max +A[1][i]);
           }
       }
        System.out.println(D[N+1]);
        //D[6] = D[4]+A[1][5]
        //D[5] = D[4]
        //D[4] = D[3] + A[1][4]
        //D[3] = D[0]+ A[1][1]


    }
}
