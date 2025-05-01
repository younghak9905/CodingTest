package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        long [][]D = new long[N-1][21];
        D[0][num[0]]=1;
        for(int i=1;i<N-1;i++)
        {
            for(int j=0;j<=20;j++)
            {
                if(j-num[i]>=0) D[i][j] += D[i-1][j-num[i]];
                if(j+num[i]<=20) D[i][j] += D[i-1][j+num[i]];
            }
        }
        System.out.println(D[N-2][num[N-1]]);
    }
}
