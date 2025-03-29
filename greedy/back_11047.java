package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		long []A = new long[N+1];
		int count=0;
		for(int i=1;i<=N;i++)
		{
			A[i] = Long.parseLong(br.readLine());
		}


		for(int j=N;j>0;j--)
		{
			if(A[j]<=K)
			{
				count+=K/A[j];
				K=K%A[j];
			}
		}
		System.out.println(count);

	}
}
