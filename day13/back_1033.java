package day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class back_1033 {
	static Reader in = new Reader();
	static boolean visited[];
	static ArrayList<cNode>[] A;
	static long D[];
	static long lcm;
	public static void main(String[] args) throws Exception {
		int N = in.nextInt();
		A = new ArrayList[N];
		lcm = 1;
		visited  = new boolean[N];
		D= new long[N];
		for(int i=0;i<N;i++)
		{
			A[i] = new ArrayList<cNode>();
		}
		for(int i=0;i<N-1;i++)
		{
			int a=in.nextInt();
			int b=in.nextInt();
			int p=in.nextInt();
			int q=in.nextInt();
			A[a].add(new cNode(b,p,q));
			A[b].add(new cNode(a,p,q));
			lcm *=((p*q)/gcd(p,q)); //두 수의 곱을 최대 공약수로 나눈것
		}
		D[0]=lcm;
		DFS(0);
		long mgcd = D[0];
		for(int i=1;i<N;i++)
		{
			mgcd  = gcd(mgcd,D[i]);
		}
		for(int i=0;i<N;i++)
		{
			System.out.print(D[i]/mgcd+" ");
		}
	}

	public static long gcd(long a,long b)
	{
		if(b==0)
		{
			return a;
		}

		return gcd(b,a%b);
	}

	public static class cNode
	{
		int b;
		int p;
		int q;
		public cNode(int b,int p, int q)
		{	super();
			this.b=b;
			this.p=p;
			this.q=q;
		}
		public int getB()
		{
			return b;
		}
		public int getQ()
		{
			return q;
		}
		public int getP()
		{
			return p;
		}
	}

	public static void DFS(int v)
	{
		visited[v]=true;
		for(cNode i : A[v])
		{
			int next = i.getB();
			if(!visited[next])
			{
				D[next] = D[v] * i.getQ()/i.getP();
				DFS(next);
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
			while ((c = read()) <= 32);
			do n = (n << 3) + (n << 1) + (c & 15);
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
