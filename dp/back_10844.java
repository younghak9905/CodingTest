package dp;
import java.io.*;
import java.util.*;
public class back_10844 {
	static long mod = 1000000000;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long [][]dp = new long[N+1][10];
		for(int i=1;i<=9;i++)
		{
			dp[1][i] = 1; // 길이가 1인 경우는 각 숫자마다 1개씩
		}
		for(int i=2;i<=N;i++)
		{
		   for(int j=0;j<10;j++)
		   {
			   if(j==0)
			   {
				   dp[i][0] = dp[i-1][1]%mod;
			   }else if(j==9) {
				   dp[i][9] = dp[i - 1][8]%mod;
			   }
			   else{
				   dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod; // j가 0이 아닐 때는 j-1과 j+1에서 올 수 있음
			   }
		   }
		}
		long sum = 0;
		for(int i=0;i<10;i++)
		{
			sum += dp[N][i];
		}
		System.out.println(sum % mod);

	}
}
