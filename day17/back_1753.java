package day17;

import java.util.ArrayList;
import java.util.PriorityQueue;

import day16.back_2252;

public class back_1753 {// 다익스트라

	static Reader in = new Reader();
	static ArrayList<Node>[] A;
	static PriorityQueue<Node> q = new PriorityQueue<Node>();

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int V = in.nextInt();
		int E = in.nextInt();
		int K = in.nextInt();
		A= new ArrayList[V+1];
		int []D = new int[V+1];
		boolean []visited = new boolean[V+1];
		for(int i=1;i<=V;i++)
		{
			A[i]= new ArrayList<Node>();
			D[i]= Integer.MAX_VALUE;
		}

		for(int i=0;i<E;i++)
		{
			int u = in.nextInt();
			int v = in.nextInt();
			int w = in.nextInt();
			A[u].add(new Node(v,w));
		}
		D[K]=0;
		q.add(new Node(K,0));
		while (!q.isEmpty())
		{
			Node now = q.poll();
			int c_v = now.vertex;
			if(visited[c_v]) continue;
			visited[c_v] = true;
			for(int i=0;i<A[c_v].size();i++)
			{
				Node temp = A[c_v].get(i);
				int next = temp.vertex;
				int value = temp.value;
				if(D[next]>D[c_v]+value)
				{
					D[next]= D[c_v]+value;
					q.add(new Node(next,D[next]));
				}
			}

		}
		for(int i=1;i<=V;i++)
		{
			if(visited[i])
			{
				sb.append(D[i]+"\n");
			}
			else
			{
				sb.append("INF\n");
			}
		}
		System.out.print(sb);
	}
	static class Node implements Comparable<Node>{
		int vertex;
		int value;
		public Node(int vertex, int value)
		{
			this.vertex = vertex;
			this.value = value;
		}
		public int compareTo(Node d)
		{
			if(this.value > d.value) return 1;
			else return -1;
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
