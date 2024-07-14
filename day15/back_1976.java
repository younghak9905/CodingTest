package day15;

public class back_1976 { // 유니온 파인드
	static Reader in = new Reader();
	static int []A;

	static int []parent;
	static int [][]city;


	public static void main(String[] args) throws Exception {
		int N = in.nextInt();
		int M = in.nextInt();
		city = new int[N+1][N+1];
		A= new int[M+1];
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=N;j++)
			{
				city[i][j]=in.nextInt();
			}
		}
		for(int i=1;i<=M;i++)
		{
			A[i]=in.nextInt();
		}
		parent = new int[N+1];
		for(int i=1;i<=N;i++)
		{
			parent[i]=i;
		}

		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=N;j++)
			{
				if(city[i][j]==1)
				{
					union(i,j);
				}
			}
		}
		int route = find(A[1]);
		for(int i=2;i<A.length;i++)
		{
			if(route!=find(A[i]))
			{
				System.out.print("NO");
				return;
			}
		}
		System.out.print("YES");


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
