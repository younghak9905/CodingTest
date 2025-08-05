package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_1920 {
	static int []A;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for(int i=0;i<N;i++)
		{
			A[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++)
		{
			int target = Integer.parseInt(st.nextToken());
			halfSearch(target);
		}
		System.out.print(sb);
	}
	static void halfSearch(int target)
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
			{	sb.append(1+"\n");
				return;
			}
		}
		sb.append(0+"\n");
	}
}







