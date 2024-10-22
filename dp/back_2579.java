package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_2579 {
	static int[] arr;
	static int[] D;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		D = new int[N+1];

		for(int i=1;i<=N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}


		D[1]=arr[1];
		if(N>=2)
		{
			D[2]=arr[1]+arr[2];
		}

		for(int i=3;i<=N;i++)
		{
			D[i]=Math.max(D[i-2],D[i-3]+arr[i-1])+arr[i];
		}
		System.out.print(D[N]);

	}
}
