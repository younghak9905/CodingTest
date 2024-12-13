package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_12865_2 {
	static int[] D;
	static int[][] item;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		item = new int[N+1][2];
		for(int i=1;i<=N;i++)
		{	st = new StringTokenizer(br.readLine());
			item[i][0]=Integer.parseInt(st.nextToken());
			item[i][1]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++)
		{
			for(int j=K;j>=item[i][0];j--)
			{
				D[j] = Math.max(D[j], D[j-item[i][0]]+item[i][1]);
			}
		}
	}
}
