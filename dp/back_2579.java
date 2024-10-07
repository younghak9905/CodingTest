package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_2579 {
	static int[] arr;
	static int[] D;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		D = new int[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		D[1]=arr[1];
		D[2]=arr[1]+arr[2];
		D[3]=Math.max(arr[1]+arr[3],arr[2]+arr[3]);
		D[4]=Math.max(arr[1]+arr[2]+arr[4],arr[1]+arr[3]+arr[4]);
		D[5]=Math.max(arr[5]+arr[4]+D[2]+D[1],Math.max(arr[5]+arr[3]+D[2],arr[5]+arr[3]+D[1]));


		for(int i=3;i<=N;i++)
		{
			D[i]=Math.max(D[i-1]+arr[i],D[i-2]+arr[i]);
		}
		System.out.println(D[N]);

	}
}
