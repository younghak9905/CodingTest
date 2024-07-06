package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_18185 {
	static Reader in = new Reader();
	public static void main(String[] args) throws Exception {

		int N = in.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = in.nextInt();
		}

		long sum = 0;
		long m=0;
		for (int start = 0; start < N - 2; start++) {
			if(A[start+1]>A[start+2])
			{
				m=Math.min(A[start],A[start+1]-A[start+2]);
				sum+= 5*m;
				A[start]-=m;
				A[start+1]-=m;

			}

			if (A[start]>0 && A[start + 1] > 0 && A[start + 2] > 0) {
				m=Math.min(A[start],A[start+1]);
				sum += m*7;
				A[start]-=m;
				A[start + 1]-=m;
				A[start + 2]-=m;
			}
			if(A[start]>0){
				sum += A[start]*3;
				A[start]=0;

			}
		}

		if(A[N-2]>0 && A[N-1]>0)
		{
			m=Math.min(A[N-2],A[N-1]);
			sum += 5*m;
			A[N-1]-=m;
			A[N-2]-=m;
		}
		if(A[N-1]>0)
		{
			sum += A[N-1]*3;
		}
		else if(A[N-2]>0){
			sum += A[N-2]*3;
		}
		System.out.println(sum);
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
