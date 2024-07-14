package day15;

import java.util.ArrayList;

public class back_1043 {
	static Reader in = new Reader();
	static int []trueP;

	static StringBuilder st;
	static int []parent;

	static ArrayList<Integer>[] party;

	public static void main(String[] args) throws Exception {
		int N = in.nextInt();
		int M = in.nextInt();
		int T = in.nextInt();
		trueP = new int[T];

		for(int i=0;i<T;i++)
		{
				trueP[i] =in.nextInt();
		}


		party = new ArrayList[M];
		for(int i=0;i<M;i++)
		{
			int party_size = in.nextInt();
			party[i]=new ArrayList<Integer>();
			for(int j=0;j<party_size;j++)
			{
				party[i].add(in.nextInt());
			}
		}
		parent = new int[N+1];
		for(int i=0;i<=N;i++)
		{
			parent[i] =i;
		}

		for(int i=0;i<M;i++)
		{
			int first = party[i].get(0);
			for(int j=1;j<party[i].size();j++)
			{
				union(first,party[i].get(j));
			}
		}

		int count =0;
		for(int i=0;i<M;i++)
		{	boolean isPossible = true;
			int parent = party[i].get(0);
			for(int j=0;j<trueP.length;j++)
			{
				if(find(trueP[j])==find(parent))
				{
					isPossible = false;
					break;
				}
			}
			if(isPossible) count++;
		}
		System.out.println(count);

	}


	public static void union(int a,int b)
	{	a=find(a);
		b=find(b);
		if(a!=b)
		{
			parent[b]=a;
		}

	}

	public static int find(int a)
	{
		if(parent[a]==a)
			return a;
		else{
			return parent[a]=find(parent[a]);
		}
	}

	public static boolean check(int a,int b)
	{
		a=find(a);
		b=find(b);
		if(a==b)
		{
			return true;
		}
		else {
			return false;
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


