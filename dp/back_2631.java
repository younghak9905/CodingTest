package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_2631 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []A = new int[N+1];
		int []D = new int[N+1];
		for(int i=1;i<=N;i++)
		{
			A[i]=Integer.parseInt(br.readLine());
		}
		D[1]=1;
		int max =0;
		for(int i=1;i<=N;i++)
		{
			D[i]=1;
			for(int j=1;j<i;j++)
			{
				if(A[j]<A[i] && D[i]<D[j]+1)
				{
					D[i]=D[j]+1;
				}
			}
			if(max<=D[i])
			{
				max=D[i];
			}

		}
		System.out.println(N-max);

	}
}
