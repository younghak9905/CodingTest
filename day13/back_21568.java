package day13;

import java.util.PriorityQueue;

public class back_21568 {
	static Reader in = new Reader();
	public static void main(String[] args) throws Exception {
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		long gcd = gcd(A,B);
		if(C%gcd!=0) //c가 최대공약수의 배수가 아닌경우
		{
			System.out.println("-1");
		}else{
			int mok = (int)(C/gcd); //몫
			long[] ret = Excute(A,B);
			System.out.println(ret[0]*mok+ " "+ret[1]*mok); //ax+by
		}
	}
	private static long[] Excute(long a,long b)
	{
		long[] ret = new long[2];
		if(b==0)
		{
			ret[0]=1; ret[1]=0;
			return ret;
		}
		long q=a/b;
		long[] v = Excute(b,a%b);
		ret[0] = v[1]; //x=y'
		ret[1] = v[0]-v[1]*q; //y=x'-y'*몫
		return ret;
	}


	public static long gcd(long a,long b)
	{
		if(b==0)
		{
			return a;
		}

		return gcd(b,a%b);
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
