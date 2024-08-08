package day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1722 {
	static long D[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int height=fac(N);

		D= new long[height+1][N+1];
		for(int i=1;i<=height;i++)
		{

		}
		int a = Integer.parseInt(st.nextToken());
		int result[]= new int[N];
		if(a==1)
		{

		}else{
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				result[i] = Integer.parseInt(st.nextToken());
			}
		}

	}
	public static int fac(int i)
	{	if(i<=1)
			return i;
		return i*fac(i-1);
	}
}
