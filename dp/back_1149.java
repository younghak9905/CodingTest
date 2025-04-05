package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1149 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [][]house = new int[N+1][3];
		long [][]D = new long[N+1][3];
		for(int i=1;i<=N;i++)
		{	st = new StringTokenizer(br.readLine());

			for(int j=0;j<3;j++)
			{
				house[i][j] = Integer.parseInt(st.nextToken());
			}
;
		}

		D[1][0] = house[1][0];
		D[1][1]= house[1][1];
		D[1][2]= house[1][2];



		for(int i=2;i<=N;i++)
		{
			for(int j=0;j<3;j++)
			{
				D[i][j] = Math.min(D[i-1][(j+1)%3],D[i-1][(j+2)%3])+house[i][j];
			}

		}

		System.out.println(Math.min(Math.min(D[N][0],D[N][1]),D[N][2]));
	}
}
