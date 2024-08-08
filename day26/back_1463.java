package day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1463 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		long D[] = new long[N+1];
		D[1]=0;
		for(int i=2;i<=N;i++)
		{
			D[i]=D[i-1]+1;
			if(i%2==0) D[i]=Math.min(D[i],D[i/2]+1);
			if(i%3==0) D[i]=Math.min(D[i],D[i/3]+1);
		}
		System.out.println(D[N]);

	}

}
