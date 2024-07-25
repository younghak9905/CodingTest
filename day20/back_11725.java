package day20;

import java.util.ArrayList;


public class back_11725 {
	static Reader in = new Reader();
	static ArrayList<Integer> tree[];
	static boolean visited[];

	static int parent[];
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int N = in.nextInt();
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		parent=new int[N+1];

		for(int i=0;i<=N;i++)
		{
			tree[i]=new ArrayList<>();
		}
		for(int i=1;i<N;i++)
		{
			int a = in.nextInt();
			int b= in.nextInt();
			tree[a].add(b);
			tree[b].add(a);

		}
		DFS(1);
		for(int i=2;i<=N;i++)
		{
			sb.append(parent[i]+"\n");
		}
		System.out.println(sb);
	}


	static void DFS(int v)
	{

		visited[v]=true;
		for(int i : tree[v])
		{
			if(visited[i]==false)
			{	parent[i]=v;
				DFS(i);
			}
		}
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
