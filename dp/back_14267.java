package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_14267 {
	static int []A;
	static  ArrayList<Integer>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		A = new int[N+1];

		for(int i=1;i<=N;i++)
		{
			list[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
		{
			int parent = Integer.parseInt(st.nextToken());

			if(parent != -1)
			{
				list[parent].add(i);

			}
		}

		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int child = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());

			A[child] += score;
		}
		dfs(1);
		for(int i=1;i<=N;i++)
		{
			sb.append(A[i]).append(" ");
		}
		System.out.println(sb);

	}

	//dfs
	static void dfs(int v)
	{
		for(int nxt : list[v])
		{
			A[nxt] += A[v];
			dfs(nxt);
		}

	}


}
