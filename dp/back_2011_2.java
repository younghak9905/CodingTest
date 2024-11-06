package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_2011_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = s.length();
		int mod = 1000000;
		long[] dp = new long[N + 1];
		if (s.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=N;i++)
		{
			if(s.charAt(i-1)==0)  //1220
			{
				if(s.charAt(i-2)==2 || s.charAt(i-2)==1)
					dp[i]=dp[i-2]%mod;
				else
					break;
			}
			else{
				int result =Integer.parseInt(s.substring(i-2,i));
				if(result>9 && result<27)
					dp[i]=(dp[i-1]+dp[i-2])%mod;
				else
					dp[i]=dp[i-1]%mod;
			}
		}
		System.out.println(dp[N]);

	}
}
