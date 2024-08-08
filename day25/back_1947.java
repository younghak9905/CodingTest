package day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1947 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long MOD = 1000000000;

		long D[] = new long[1000001];
		D[1]=0;
		D[2]=1;
		for(int i=3;i<=N;i++)
		{
			D[i] = (i-1)*(D[i-1]+D[i-2])%MOD;
		}
		System.out.println(D[N]);

	}
}
