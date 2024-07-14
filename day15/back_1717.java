package day15;


public class back_1717 {//유니온 파인드
	static Reader in = new Reader();
	static int []A;

	static StringBuilder st;

	public static void main(String[] args) throws Exception {
		int N = in.nextInt();
		int M = in.nextInt();
		st = new StringBuilder();
		A = new int[N+1];
		for(int i=0;i<=N;i++)
		{
			A[i]=i;
		}
		for(int i=0;i<M;i++)
		{
			int zero = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			if(zero==0)
			{
				union(a,b);
			}else if(zero==1)
			{
				check(a,b);
			}
		}
		System.out.print(st);
	}

	public static void union(int a,int b)
	{	a=find(a);
		b=find(b);
		if(a!=b)
		{
			A[b]=a;
		}

	}

	public static int find(int a)
	{
		if(A[a]==a)
			return a;
		else{
			return A[a]=find(A[a]);
		}
	}

	public static void check(int a,int b)
	{
		a=find(a);
		b=find(b);
		if(a==b)
		{
			st.append("YES\n");
		}
		else {
			st.append("NO\n");
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
