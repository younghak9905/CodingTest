package day17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class back_1854 {
	static Reader in = new Reader();
	static ArrayList<Node>[] A;
	static PriorityQueue<Node> q = new PriorityQueue<Node>();

	static final int INF = 100000000;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		int [][]W= new int[1001][1001];

		PriorityQueue<Integer> D[]=new PriorityQueue[N+1];
		Comparator<Integer> cp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1,Integer o2) {
				return o1 < o2 ? 1 : -1;
			}
		};
		for(int i=1;i<=N;i++)
		{
			D[i]= new PriorityQueue<Integer>(K,cp);
		}
		for(int i=0;i<M;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			W[a][b]=c;

		}


		q.add(new Node(1,0));
		D[1].add(0);
		while (!q.isEmpty())
		{
			Node now = q.poll();
			for(int next=1;next<=N;next++)
			{
				if(W[now.vertex][next]!=0)
				{
					int cost =now.value + W[now.vertex][next];
					if(D[next].size()<K)
					{
						D[next].add(cost);
						q.add(new Node(next,cost));
					}
					else if(D[next].peek()> cost)
					{
						D[next].poll();
						D[next].add(cost);
						q.add(new Node(next,cost));

					}
				}


			}

		}
		for(int i=1;i<=N;i++)
		{
			if(D[i].size()==K)
			{
				sb.append(D[i].peek()+"\n");
			}
			else {
				sb.append(-1 +"\n");
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
			return this.value<d.value?-1:1;
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
