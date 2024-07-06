package day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1260 {
	static ArrayList<Integer>[] A;

	static boolean []visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		A= new ArrayList[N+1];
		visited = new boolean[N+1];

		for(int i=1;i<=N;i++)
		{
			A[i]=new ArrayList<Integer>();
		}

		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		for(int i=1;i<=N;i++)  //노드 번호가 작은 것을 먼저 방문하기 위해 정렬
		{
			Collections.sort(A[i]);
		}
		DFS(V);
		System.out.println();
		visited=new boolean[N+1];
		BFS(V);
		System.out.println();
	}

	static void DFS(int v)
	{

		if(visited[v])
			return;
		System.out.print(v+" ");
		visited[v]=true;
		for(int i : A[v])
		{
			if(visited[i]==false)
			{
				DFS(i);
			}
		}
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
			System.out.print(linkedNode+" ");
			for(int i : A[linkedNode])
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
