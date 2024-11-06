package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2229_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []A = new int[N+1];
		int []D = new int[N+1];
		for(int i=1;i<=N;i++)
		{
			A[i]=Integer.parseInt(st.nextToken());
		}
		D[1]=0;
		D[0]=0;
		for(int i=2;i<=N;i++)
		{
			int min = 10000;
			int max =0;

			for(int j=i;j>0;j--)
			{
				if(min>A[j])
				{
					min = A[j];
				}
				if(max<A[j])
				{
					max = A[j];
				}
				D[i] = Math.max(D[i],D[j-1]+max-min);
			}
		}
		System.out.print(D[N]);


	}
	}
// 5-2
//7-2
//5-2 7-1
//5-2 7-1