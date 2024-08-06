package day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1010 {
	static long D[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		D = new long[30][30];
		for(int i=0;i<30;i++)
		{
			D[i][1]=i;
			D[i][i]=1;

		}
		for(int i=2;i<30;i++)
		{
			for(int j=2;j<i;j++)
			{
				D[i][j]= D[i-1][j]+D[i-1][j-1];
			}
		}

		int T =Integer.parseInt(st.nextToken());
		for(int i=0;i<T;i++)
		{
			st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M =  Integer.parseInt(st.nextToken());
			sb.append(D[M][N]+"\n");
		}
		System.out.println(sb);




	}
}
