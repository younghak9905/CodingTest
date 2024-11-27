package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_9465_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++)
		{
			int N = Integer.parseInt(br.readLine());
			int [][]A = new int[2][N+1];
			for(int j=0;j<2;j++)
			{	st = new StringTokenizer(br.readLine());
				for(int k=1;k<=N;k++)
				{
					A[j][k]  = Integer.parseInt(st.nextToken());
				}
			}
			int [][]D = new int[2][N+1];
			D[0][0]=A[1][0]=0;
			D[0][1]=A[0][1];
			D[1][1]=A[1][1];
			for(int j=2;j<=N;j++)
			{
				D[0][j]=Math.max(D[1][j-1],D[1][j-2])+A[0][j];
				D[1][j]=Math.max(D[0][j-1],D[0][j-2])+A[1][j];
			}
			int result = Math.max(D[0][N],D[1][N]);
			sb.append(result).append("\n");

		}
		System.out.println(sb);
		}

	}

