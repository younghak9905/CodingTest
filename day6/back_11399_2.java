package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11399_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []A = new int[N];
		int []S= new int[N+1];
		for(int i=0;i<N;i++)
		{
			A[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<N;i++)
		{
			int target = A[i];
			int location = binarySearch(A, target, 0, i);
			int j=i-1;
			while(j>=location)
			{
				A[j+1]=A[j];
				j--;
			}
			A[location] = target;
		}

		int sum=0;
		S[0]=A[0];

		for(int i =1;i<N;i++)
		{
			S[i]=S[i-1]+A[i];
		}
		for(int i =0;i<N ;i++)
		{
			sum+=S[i];
		}
		System.out.print(sum);


	}
	private static int binarySearch(int[] a, int key, int lo, int hi) {

		int mid;
		while(lo < hi) {
			// 좀 더 빠르게 하기 위해서 /2 대신 >>> 1을 사용해도 된다.
			mid = lo + ((hi - lo) / 2);

			if(key < a[mid]) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}
		return lo;
	}
}
