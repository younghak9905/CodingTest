package day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class back_2252 {
	static Reader in = new Reader();
	static ArrayList<Integer>[] A;

	public static void main(String[] args) throws Exception {
		StringBuilder st = new StringBuilder();
		int N = in.nextInt();
		int M = in.nextInt();
		int []D = new int[N+1];

		A =new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			A[i]= new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			int s = in.nextInt();
			int e = in.nextInt();
			A[s].add(e);
			D[e]++;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1;i<=N;i++)
		{
			if(D[i]==0)
			{
				queue.offer(i);
			}
		}
		while (!queue.isEmpty())
		{
			int linkedNode = queue.poll();
			st.append(linkedNode+" ");
			for(int i : A[linkedNode])
			{
				D[i]--;
				if(D[i]==0)
				{
					queue.offer(i);
				}
			}
		}
		System.out.println(st);

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
