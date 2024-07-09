package day13;



public class back_1934 {
	static Reader in = new Reader();
	static int A;
	static int B;

	public static void main(String[] args) throws Exception {
		int T = in.nextInt();
		for(int i=0;i<T;i++)
		{
			A = in.nextInt();
			B = in.nextInt();
			int result =A*B/gcd(A,B);
			System.out.println(result);
		}
	}
	public static int gcd(int a,int b)
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




