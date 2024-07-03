package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		long []A=new long[N];
		for(int i=0;i<N;i++)
		{
			A[i]=Long.parseLong(br.readLine());
		}
		int j=N-1;
		long count=0;
		while(j>=0)
		{
			if(A[j]<=K)
			{
				count+=K/A[j];
				K=K%A[j];
			}

			j--;
		}
		System.out.print(count);

	}
}
