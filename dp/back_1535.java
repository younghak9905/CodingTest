package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1535 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][]items = new int[N+1][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
		{
			items[i][0]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
		{
			items[i][1]=Integer.parseInt(st.nextToken());
		}
		int []D = new int[101];

		for(int i=1;i<=N;i++)
		{
			for(int j=100;j>items[i][0];j--)
			{
				D[j]=Math.max(D[j],D[j-items[i][0]]+items[i][1]);
			}
		}
		System.out.println(D[100]);
	}
}
