package GoriconOpenContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_32301 {
	static ArrayList<Integer>[]edges;
	static int count = 0;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		edges = new ArrayList[3*N+1];
		for (int i = 1; i <= 3*N; i++) {
			edges[i] = new ArrayList<>();
		}


		int target = 3*M;
		int A[] = new int[target+1];
		for(int i =1; i <=target; i++) {
			A[i] = i;
		}
		A[1] = 0;
		for(int i=2;i<=target;i++)
		{
			if(A[i]==0)
				continue;
			for(int j=i,k=1;j<=target;j=i*++k)
			{
				if(j==i) {
					continue;
				}
				A[j]=0;
			}
		}

		int count =0;
		if(A[M]==0 || M>2*N)
		{
			System.out.println("NO");
		}else {

			for(int i=1;i<=3*N;i=i*3+1)
			{
				setEdges(i, i+1);
				setEdges(i, i+2);
				setEdges(i, i+3);
			}
			if(N>=2)
			{	if(N%2==1)
				{
					N=N-1;
				}
				if(N%2==0)
				{
					for(int i=1;i<=3*N;i=i+6)
					{
						for(int j=i;j<=i+2;j++)
						{
							setEdges(j,3*i+1);
							setEdges(j,3*i+2);
							setEdges(j,3*i+3);

						}

					}
				}

			}



			System.out.println("YES\n"+sb);
		}



	}
	static void setEdges(int u, int v)
	{
		sb.append(u).append(" ").append(v).append("\n");
		count++;
	}
}
