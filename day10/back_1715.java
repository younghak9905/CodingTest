package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []A = new int[N];
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i=0;i<N;i++)
		{
			A[i]=Integer.parseInt(br.readLine());
			que.add(A[i]);
		}
		int i=0,j=0;
		int sum=0;
		while(que.size()>1)
		{	i=que.remove();
			j=que.remove()+i;
			sum+=(j);
			que.add(j);
		}
		System.out.print(sum);

	}
}
