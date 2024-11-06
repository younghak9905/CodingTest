package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1890_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());


		StringTokenizer st;

		int [][]map = new int[N+1][N+1];
		long [][]DP = new long[N+1][N+1];
		for(int i=0;i<N;i++)
		{   st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		DP[0][0]=1;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(DP[i][j]==0) continue;
				if(i==N-1 && j==N-1) break;
				if(i+map[i][j]<N) DP[map[i][j]+i][j]+=DP[i][j];
				if(j+map[i][j]<N) DP[i][map[i][j]+j]+=DP[i][j];

			}
		}
		System.out.println(DP[N-1][N-1]);
	}
}
