package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1932 {
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N  = Integer.parseInt(br.readLine());
		int [][]A = new int[N+1][N+1];
		for(int i=1;i<=N;i++)
		{	st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++)
			{
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int [][]D = new int[N+1][N+1];
		D[0][0]=0;
		D[1][1]=A[1][1];

		int max =0;
		if(N==1)
		{
			System.out.println(A[1][1]);
			return;
		}
			for(int i=2;i<=N;i++)
			{
				for(int j=1;j<=i;j++)
				{
					if(j==1 || j==i)
					{
						if(j==1)
							D[i][1]=D[i-1][1]+A[i][1];
						else
							D[i][i]=D[i-1][i-1]+A[i][i];
					}else{
						D[i][j] =A[i][j]+ Math.max(D[i-1][j],D[i-1][j-1]);
					}
					max = Math.max(D[i][j],max);
				}

			}
			System.out.println(max);
	}
}
