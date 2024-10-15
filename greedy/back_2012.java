package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class back_2012 {
	static PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o1 - o2);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++)
		{
			que.add(Integer.parseInt(br.readLine()));
		}
		long result = 0;


		for(int i=1;i<=N;i++)
		{
			int now = que.poll();
			result+= Math.abs(now-i);
		}
		System.out.print(result);
	}
}