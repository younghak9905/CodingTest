package day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class back_1948 {
	static Reader in = new Reader();
	static ArrayList<Node>[] A;
	static ArrayList<Node>[] B;
	public static void main(String[] args) throws Exception {
		int N = in.nextInt();
		int D[] = new int[N+1];


		int M = in.nextInt();
		A = new ArrayList[N+1];
		B = new ArrayList[N+1];
		for(int i=0;i<=N;i++)
		{
			A[i]=new ArrayList<Node>();
			B[i]=new ArrayList<Node>();
		}
		for(int i=0;i<M;i++)
		{
			int s = in.nextInt();
			int e = in.nextInt();
			int time = in.nextInt();
			A[s].add(new Node(e,time));
			B[e].add(new Node(s,time));
			D[e]++;
		}
		int start = in.nextInt();
		int end = in.nextInt();
		int []result  = new int[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);

		while(!queue.isEmpty())
		{
			int now = queue.poll();
			for(Node i : A[now])
			{
				D[i.targetNode]--;
				result[i.targetNode]=Math.max(result[i.targetNode],result[now]+i.time);
				if(D[i.targetNode]==0)
				{
					queue.offer(i.targetNode);
				}
			}
		}


		//역방향 인접 리스트 여러 경로 중 최대 값을 가졌던 경로들은 1분도 쉬지 않고 와야 한다.
		int resultCount = 0;
		boolean []visited = new boolean[N+1];
		Queue<Integer> queueRev = new LinkedList<Integer>();
		queueRev.offer(end);
		visited[end] = true;
		while(!queueRev.isEmpty())
		{
			int now = queueRev.poll();
			for(Node next : B[now])
			{
				if(result[now]==(result[next.targetNode]+next.time))
				{
					resultCount++;
					if(visited[next.targetNode]==false)
					{
						visited[next.targetNode]=true;
						queueRev.offer(next.targetNode);
					}
				}

			}
		}

		System.out.println(result[end]);
		System.out.println(resultCount);


	}
	static class Node{
		int targetNode;
		int time;
		Node(int targetNode, int time)
		{
			this.targetNode= targetNode;
			this.time= time;
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
