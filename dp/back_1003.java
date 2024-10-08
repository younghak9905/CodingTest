package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_1003 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int arr[][] = new int[41][2];
		arr[0][0]=1;
		arr[0][1]=0;
		arr[1][0]=0;
		arr[1][1]=1;

		for(int i=2;i<=40;i++)
		{
			arr[i][0]=arr[i-1][0]+arr[i-2][0];
			arr[i][1]=arr[i-1][1]+arr[i-2][1];
		}
		for(int i=0;i<T;i++)
		{
			int n = Integer.parseInt(br.readLine());
			sb.append(arr[n][0]+" "+arr[n][1]+"\n");
		}
		System.out.println(sb);
	}

}
