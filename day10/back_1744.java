package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queP = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> queM = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int []A = new int[N];
		for(int i=0;i<N;i++)
		{
			A[i]=Integer.parseInt(br.readLine());
			if(A[i]>0)
			{
				queP.add(A[i]);
			}
			else {
				queM.add(A[i]);
			}
		}

		long sum=0;
		int i=0,j=0;
		while (queP.size()>1) {
			i = queP.poll();
			j = queP.poll();
			if(i==1 || j==1)
			{
				sum+=(i+j);
			}
			else{
				sum+=(i*j);
			}

		}
		if(!queP.isEmpty())
			sum+=queP.poll();
		while (queM.size()>1) {
			i = queM.remove();
			j = queM.remove();
			sum += (i*j);
		}
		if(!queM.isEmpty())
			sum+=queM.remove();
		System.out.print(sum);
	}
}
