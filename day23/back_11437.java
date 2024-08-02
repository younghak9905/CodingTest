package day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class back_11437 {
	static Reader in = new Reader();

	static ArrayList<Integer>[] tree;
	static int depth[];
	static int parent[];
	static boolean visited[];
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		int N = in.nextInt();
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<=N;i++)
		{
			tree[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<N-1;i++)
		{
			int a= in.nextInt();
			int b= in.nextInt();
			tree[a].add(b);
			tree[b].add(a);
		}
		int M = in.nextInt();

		depth = new int[N+1];
		parent= new int[N+1];
		depth[1] =0;
		parent[1]=0;

		BFS(1);

		for(int i=0;i<M;i++)
		{
			int c = in.nextInt();
			int d = in.nextInt();
			find(c,d);
		}
		System.out.println(sb);
	}

	static void BFS(int v)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v]=true;
		while(!queue.isEmpty())
		{
			int now = queue.poll();


			for(int i : tree[now])
			{
				if(visited[i]==false)
				{
					visited[i]=true;
					queue.add(i);
					parent[i]=now;
					depth[i]=depth[now]+1;
				}
			}
		}
	}



	public static void find(int a,int b)
	{
		if(depth[a]<depth[b])
		{
			int temp =a;
			a=b;
			b=temp;
		}
		while (depth[a]!=depth[b])
		{
			 a=parent[a];
		}
		while(a!=b)
		{
			a=parent[a];
			b=parent[b];
		}
		System.out.println(a);
	}

	static class Reader {
		final int SIZE = 1 << 13;
		byte[] buffer = new byte[SIZE];
		int index, size;

		int nextInt() throws Exception {
			int n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			do
				n = (n << 3) + (n << 1) + (c & 15);
			while (isNumber(c = read()));
			return n;
		}

		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}

		byte read() throws Exception {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}
