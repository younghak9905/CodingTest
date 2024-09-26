package GoriconOpenContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_32300 {

	static boolean visited[];
	static ArrayList<Integer>[]edges;

	static long count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long MOD = 1000000007;

		StringTokenizer st;
		edges = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		for(int i=1;i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges[u].add(v);
			edges[v].add(u);
		}
		for(int i=1; i<=N; i++)
		{
			visited = new boolean[N+1];
			BFS(i);
		}
		System.out.println(count%MOD);
	}

	static void BFS(int v)
	{
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(v);
		if(visited[v])
			return;
		visited[v]=true;
		while(!queue.isEmpty())
		{
			int linkedNode = queue.poll();
			
			for(int i : edges[linkedNode])
			{
				if(!visited[i])
				{
					visited[i]=true;
					queue.add(i);
				}
			}
		}

	}


}
