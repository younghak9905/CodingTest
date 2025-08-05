package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;



public class back_11000 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> {
			if(a[0]==b[0])
				return a[1]-b[1];
			return a[0]-b[0];
		});
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			q.add(new int[]{s,t});
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(q.poll()[1]);

		while (!q.isEmpty())
		{
			int []next = q.poll();
			if(pq.peek()<=next[0])
			{
				pq.poll();
			}
			pq.offer(next[1]);
		}

		System.out.println(pq.size());

	}


}
