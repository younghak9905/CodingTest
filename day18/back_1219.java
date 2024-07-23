package day18;
public class back_1219 {
	static Edge edges[];
	static long distance[];
	static Reader in = new Reader();
	static long money[];

	public static void main(String[] args) throws Exception {
		int N = in.nextInt();
		int s = in.nextInt();
		int e = in.nextInt();
		int M = in.nextInt();
		distance = new long[N];
		money = new long[N];
		edges = new Edge[M];
		for(int i=0;i<M;i++)
		{
			int A = in.nextInt();
			int B = in.nextInt();
			int C = in.nextInt();
			edges[i]=new Edge(A,B,C);
		}
		for(int i=0;i<N;i++)
		{
			distance[i]=Long.MIN_VALUE;
		}
		for(int i=0;i<N;i++)
		{
			money[i]= in.nextInt();
		}
		distance[s]=money[s];
		for(int i=0;i<=N+100;i++)
		{
			for(int j=0;j<M;j++)
			{	Edge edge=edges[j];
				int start = edge.start;
				int end = edge.end;
				int price= edge.money;

				if(distance[start]==Long.MIN_VALUE)
					continue;
				else if(distance[start]==Long.MAX_VALUE)
					distance[end]=Long.MAX_VALUE;
				else if(distance[end]<distance[start]+money[end]-price)
				{
					distance[end]=distance[start]+money[end]-price;
					if(i>=N-1) distance[end]=Long.MAX_VALUE;
				}
			}
		}
		if(distance[e]==Long.MIN_VALUE)
		{
			System.out.println("gg");
		}
		else if(distance[e]==Long.MAX_VALUE){
			System.out.println("Gee");
		}else{
			System.out.println(distance[e]);
		}


	}
	static class Edge{
		int start ,end, money;
		public Edge(int start,int end,int money)
		{
			this.start=start;
			this.end= end;
			this.money=money;
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
