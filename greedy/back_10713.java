package greedy;

import java.io.*;
import java.util.*;

public class back_10713 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Long> p = new ArrayList<>();
		long []d = new long[(int) (N + 1)];
		for(int i=0;i<M;i++)
		{
			long num = Long.parseLong(st.nextToken());
			p.add(num);
		}
		for(int i=1;i<M;i++)
		{
			long prev = p.get(i-1);
			long next = p.get(i);
			if(prev>next)
			{
				long temp = prev;
				prev = next;
				next = temp;

			}
			d[(int) prev]++;
			d[(int) next]--;

		}
		ArrayList<Node> list = new ArrayList<>();
		for(int i=1;i<N;i++)
		{
				st = new StringTokenizer(br.readLine());
				long A = Long.parseLong(st.nextToken());
				long B = Long.parseLong(st.nextToken());
				long C = Long.parseLong(st.nextToken());
				list.add(new Node(A, B, C));

		}
		long result = 0;
		long sum = 0;
		for(int i=0;i<N-1;i++)
		{
			Node node = list.get(i);
			sum += d[i+1];
			if(sum==0) continue; // 현재 구간에 아무도 없으면 건너뛰기
			result += Math.min(sum*node.A, sum*node.B+node.C);
		}
		System.out.println(result);


	}
	static class Node {
		long A;
		long B;
		long C;

		Node(long A, long B, long C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}
}
