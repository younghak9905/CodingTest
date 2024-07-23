package day18;

import java.util.Arrays;

public class back_11404 {//플로이드 워셜
	static Reader in = new Reader();
	static int D[][];
	public static void main(String[] args) throws Exception {
		StringBuilder sb =new StringBuilder();
	 int N = in.nextInt();
	 int M = in.nextInt();
	 D = new int[N+1][N+1];
	 for (int i = 1; i <= N; i++) {
		 for(int j=1;j<=N;j++)
		 {
			 if(i==j)
			 	D[i][j]= 0;
			 else
				 D[i][j]=10000001;
		 }
	 }

	 for(int i=0;i<M;i++)
	 {
		int s= in.nextInt();
		int e= in.nextInt();
		int w= in.nextInt();
		if(D[s][e]>w) D[s][e]=w;

	 }
	 for(int k=1;k<=N;k++)
	 {
		 for(int i=1;i<=N;i++)
		 {
			 for(int j=1;j<=N;j++)
			 {
				 D[i][j]=Math.min(D[i][j],D[i][k]+D[k][j]);
			 }
		 }
	 }
	 for(int i=1;i<=N;i++)
	 {
		 for(int j=1;j<=N;j++)
		 {
			 if(D[i][j]==10000001)
			 {
				 sb.append("0 ");
			 }else{
				 sb.append(D[i][j]+" ");
			 }
		 }
		 sb.append("\n");
	 }
	 System.out.print(sb);
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
