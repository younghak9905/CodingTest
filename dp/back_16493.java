package dp;

import java.io.*;
import java.util.StringTokenizer;

public class back_16493 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][]arr = new int[M+1][2];
		for(int i=1;i<=M;i++)
		{
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 시간
			arr[i][1] = Integer.parseInt(st.nextToken()); // 점수
		}
		int []DP = new int[N+1];
		for(int i=1;i<=M;i++)
		{
			for(int j=N;j>=arr[i][0];j--)
			{
				DP[j] = Math.max(DP[j], DP[j-arr[i][0]] + arr[i][1]);
			}
		}
		System.out.println(DP[N]);
	}
}
