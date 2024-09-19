package weak0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_4158 {
	static long [] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		while(true)
		{
			int result=0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N==0 && M==0)
			{
				break;
			}
			A= new long[N+1];

			for(int i=0;i<N;i++)
			{
				A[i]=Integer.parseInt(br.readLine());
			};
			for(int i=0;i<M;i++)
			{
				long input = Integer.parseInt(br.readLine());
				if(A[N-1]>=input)
				{
					if(halfSearch(input))
					{
						result++;
					}
				}

			}
			System.out.println(result);
		}

	}
	static boolean halfSearch(long target)
	{
		int start =0;
		int end = A.length-1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			if(A[mid]>target)
			{
				end = mid -1;
			}
			else if(A[mid]<target) {
				start = mid+1;
			}else
			{
				return true;

			}
		}
		return false;

	}
}
