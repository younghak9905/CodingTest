package dp;

import java.io.BufferedReader;

public class back_11057 {
    static int MOD = 10007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][]dp = new int[N + 1][10];


        for(int i=0;i<=9;i++)
        {
            dp[1][i] = 1; // 1자리수는 각 숫자마다 1가지 경우
        }
        long sum=0;
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=9;j++)
            {
                dp[i][j] = dp[i][j-1]%MOD+dp[i-1][j]%MOD;
                sum+= dp[i][j]%MOD;
            }

        }
        System.out.println((sum+1) % MOD);
    }
}
