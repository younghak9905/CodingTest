package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2293 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int []coin = new int[N+1];
		int []D = new int[K+1];
		for(int i=1;i<=N;i++)
		{
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		D[0]=1;

		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=K;j++)
			{
				if(j>=coin[i])
				{
					D[j]=D[j]+D[j-coin[i]];  //
				}
			}
		}

		System.out.println(D[K]);
	}
}
