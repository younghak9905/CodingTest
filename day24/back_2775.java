package day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2775 {
	;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		long D[][] = new long[15][15];
		for(int i=0;i<15;i++)
		{
			D[i][1]=1;
			D[0][i]=i;
		}
		for(int i=1;i<15;i++)
		{
			for(int j=2;j<15;j++)
			{
				D[i][j]=D[i][j-1]+D[i-1][j];
			}
		}
		for(int i=0;i<N;i++)
		{
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(D[k][n]+"\n");
		}
		System.out.println(sb);
	}
}
