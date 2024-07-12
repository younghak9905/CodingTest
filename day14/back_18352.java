package day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//그래프 표현, BFS 이용
public class back_18352 {
	static Reader in = new Reader();
	static ArrayList<Integer>[] A;
	static int visited[];
	public static void main(String[] args) throws Exception {
		StringBuilder st = new StringBuilder();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		int X = in.nextInt();
		A= new ArrayList[N+1];

		for(int i=0;i<=N;i++)
		{
			A[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++)
		{

			int s = in.nextInt();
			int e = in.nextInt();
			A[s].add(e);

		}
		visited = new int[N+1];
		for(int i=0;i<=N;i++)
		{
			visited[i]=-1;
		}

		BFS(X);

		for(int i=0;i<=N;i++)
		{
			if(visited[i]==K)
				result.add(i);
		}

		if(!result.isEmpty())
		{
			Collections.sort(result);
			for(Integer results : result)
			{
				st.append(results+"\n");
			}
			System.out.print(st);
		}
		else {
			System.out.print(-1);
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


	static void BFS(int v)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v]++;
		while(!queue.isEmpty())
		{
			int linkedNode = queue.poll();

			for(int i : A[linkedNode])
			{
				if(visited[i]==-1)
				{
					visited[i]=visited[linkedNode]+1;
					queue.add(i);
				}
			}
		}
	}
}

