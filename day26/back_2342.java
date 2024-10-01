package day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_2342 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=0;
		ArrayList<Integer> list = new ArrayList<>();

		 int mp[][] = {
			 {0,2,2,2,2},
			 {2,1,3,4,3},
			 {2,3,1,3,4},
			 {2,4,3,1,3},
			 {2,3,4,3,1}
		 };
		 int dp[][][]=new int[100001][5][5];
		 int s=1;

		 for(int i=0;i<5;i++)
		 	for(int j=0;j<5;j++)
				 for(int k=0;k<100001;k++)
					 dp[k][i][j]=100001*4;
		 dp[0][0][0]=0;
		while (true)
		{
			N=Integer.parseInt(st.nextToken());
			if(N==0)
				break;
			for(int i=0;i<5;i++)
			{
				if(N==i)
					continue;// 두발이 같은 자리에 있을 수 없다.
				for(int j=0;j<5;j++)
				{
					dp[s][i][N]=Math.min(dp[s-1][i][j]+mp[j][N],dp[s][i][N]);
				}
			}
			for(int j=0;j<5;j++)
			{
				if(N==j)
					continue;// 두발이 같은 자리에 있을 수 없다.
				for(int i=0;i<5;i++)
				{
					dp[s][N][j]=Math.min(dp[s-1][i][j]+mp[i][N],dp[s][N][j]);
				}
			}
			s++;
		}
		s--;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				min=Math.min(min,dp[s][i][j]);
			}
		}
		System.out.println(min);
	}
}
