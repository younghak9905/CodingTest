package day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1722 {
	static long D[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int F[] = new int[N+1];
		int S[] = new int[N+1];
		F[1]=1;
		for(int i=2;i<=N;i++)
		{
			F[i] = F[i-1]*i;
		}
		int a = Integer.parseInt(st.nextToken());
		int result[]= new int[N];
		boolean visited[] = new boolean[N+1];
		if(a==1)
		{
			long k = Integer.parseInt(st.nextToken());
			for(int i=1;i<=N;i++)
			{
				for(int j=1,cnt =1;j<=N;j++)
				{
					if(visited[j])
						continue;
					if(k<=cnt*F[N-1])
					{
						k-=((cnt-1)*F[N-1]);
						S[i] = j;
						visited[j] = true;
						break;
					}
					cnt++;
				}
			}
			for(int i=1;i<=N;i++)
			{
				System.out.println(S[i]+" ");
			}
		}else{
			long k =1;

			for(int i=1;i<=N;i++)
			{	st = new StringTokenizer(br.readLine());
				S[i] = Integer.parseInt(st.nextToken());
				long cnt = 0;
				for(int j=1;j<S[j];j++)
				{
					if(visited[j]==false) cnt++;
				}
				k+=cnt*F[N-1];
				visited[S[i]]= true;
			}
			System.out.println(k);

		}

	}
	public static int fac(int i)
	{	if(i<=1)
			return i;
		return i*fac(i-1);
	}
}
