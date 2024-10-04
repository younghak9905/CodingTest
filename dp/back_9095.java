package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_9095 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[12];
		arr[1]=1;
		arr[2]=2;
		arr[3]=4;//1+1+1, 1+2, 2+1, 3

		for(int j=4;j<=11;j++)
		{
			arr[j] = arr[j-1]+arr[j-2]+arr[j-3];
		}
		for(int i=0;i<N;i++)
		{
			int n = Integer.parseInt(br.readLine());
			sb.append(arr[n]+"\n");
		}
		System.out.println(sb);
	}
}
