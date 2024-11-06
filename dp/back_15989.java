package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class back_15989 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[][] D = new int[10001][4];
			D[1][1]=1;
			D[2][1]=1;
			D[2][2]=1;
			D[3][1]=1;
			D[3][2]=1;
			D[3][3]=1;
			for(int i=4;i<=10000;i++)
			{
				D[i][1]=D[i-1][1];
				D[i][2] = D[i-2][1]+D[i-2][2];
				D[i][3] = D[i-3][1]+D[i-3][2]+D[i-3][3];
			}
			StringBuilder sb = new StringBuilder();

			for(int i=0;i<T;i++)
			{
				int N = Integer.parseInt(br.readLine());
				sb.append(D[N][1]+D[N][2]+D[N][3]).append("\n");
			}
			System.out.print(sb);

	}
	}
