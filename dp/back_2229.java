package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2229 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []A = new int[N+1];
		for(int i=1;i<=N;i++)
		{
			A[i]=Integer.parseInt(st.nextToken());
		}
		int []D = new int[N+1];

		D[1] =0;
		for(int i=1;i<=N;i++)
		{
			int min=10001;
			int max=0;
			for(int j=i;j>0;j--)
			{

				if(max<A[j])
				{
					max=A[j];
				}
				if(min>A[j])
				{
					min=A[j];
				}

				D[i]= Math.max(D[i],D[j-1]+max-min);
			}

		}
		System.out.println(D[N]);
	}
}
