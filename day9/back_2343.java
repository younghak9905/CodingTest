package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		int []A = new int[N];
		st = new StringTokenizer(br.readLine());
		int e=0;
		int s =0;
		for(int i =0;i<N;i++)
		{
			A[i]= Integer.parseInt(st.nextToken());
			if(s<A[i]) s=A[i];
			e +=A[i];
		}

		while(s<=e)
		{	int m = s+ (e-s)/2;
			int sum=0;
			int count=0;
			for(int i=0;i<N;i++)
			{
				if(sum+A[i]>m) {
					count++;
					sum = 0;
				}

				sum=sum+A[i];
			}
			if(sum!=0)
				count++;
			if(count>M)
				s=m+1;
			else
				e=m-1;
		}
		System.out.print(s);


	}
}
