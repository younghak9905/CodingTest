package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_2294_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = 100000;
		int[] coin = new int[N + 1];
		int[] D = new int[K + 1];
		Arrays.fill(D,max);
		for(int i=1;i<=N;i++)
		{
			int input =Integer.parseInt(br.readLine());
			coin[i]=input;
			D[input]=1;
		}
		Arrays.sort(coin);
		D[0]=1;

		for(int i=1;i<=K;i++)
		{
			for(int j=1;j<=N;j++)
			{
				if(i<coin[j]  || coin[j]>K) break;
				D[i] = Math.min(D[i],D[i-coin[j]]+D[coin[j]]);
			}
		}
		System.out.println(D[K]!=max?D[K]:-1);
	}
}
