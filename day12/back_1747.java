package day12;

public class back_1747 {
	static Reader in = new Reader();
	static char []C;
	static int []A;
	static int N;
	public static void main(String[] args) throws Exception {
		N = in.nextInt();
		A = new int[1003002];
		int sqrt = (int)Math.sqrt(1003002);
		for(int i =2; i <1003002; i++) {
			A[i] = i;
		}
		for(int i=2;i<=sqrt ;i++)
		{
			if(A[i]==0)
				continue;
			for(int j=i+i;j<1003002;j+=i)
			{
				A[j]=0;
			}
		}
		int i =N;
		while(i<1003002) {
			if (A[i] != 0) {
				if (isPalindrome(A[i])) {
					System.out.println(A[i]);
					return;
				}
			}
			i++;
		}

		System.out.print("Standard output is empty");
	}
	public static boolean isPalindrome(int target)
	{
		C = Integer.toString(target).toCharArray();
		int s = 0;
		int e = C.length-1;
		while(s<e)
		{
			if(C[e]!=C[s])
				return false;
			s++;
			e--;
		}
		return true;
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
