package graph;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class back_11725 {
	static int []A;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	static int []parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		parent = new int[N+1];
		StringTokenizer st;
		for(int i=1;i<=N;i++)
		{
			list[i] = new ArrayList<>();
		}
		for(int i=2;i<=N;i++)
		{
			st= new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(u==1 || v==1)
			{
				A[i] = u==1? v : u;
				list[1].add(A[i]);
				parent[A[i]] = 1;
			}
			else
			{
				list[u].add(v);
				list[v].add(u);
			}
		}

		for(int i=2;i<=N;i++)
		{
			recur(A[i]);
		}
		for(int i=2;i<=N;i++)
		{
			sb.append(parent[i]).append("\n");

		}
		System.out.print(sb);

	}
	static void recur(int v)
	{
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		while(!queue.isEmpty())
		{
			int idx = queue.poll();
			if(list[idx]==null || list[idx].size()==0)
				continue;

			for(int next : list[idx])
			{
				if(!visited[next])
				{
					parent[next] = idx;
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}


}
