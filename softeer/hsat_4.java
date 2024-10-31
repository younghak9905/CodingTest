package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class hsat_4 {
	static long B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		HashMap<Long,Integer> map = new HashMap<>();
		for(int i=0;i<N;i++)
		{
			int a = Integer.parseInt(st.nextToken());
			pq.offer(a);
		}

		long min= pq.isEmpty()?0:pq.poll();

		int count=1;
		while(!pq.isEmpty() && B>0)
		{
			int  a= pq.poll();
			if(a==min)
			{
				continue;
			}
			if(count>B) break;
			long temp = min;
			min = check(min,a,count);
			if(temp == min) break;
			if(a==min) count++;



		}
		System.out.println(min);
	}
	static class Computer{
		long num;
		long price;
		public Computer(long num, long price) {
			this.num = num;

			this.price = price;
		}
	}
	static long check(long min,long next,int count)
	{
		long result=min;
		long small=min;
		while(small<=next)
		{
			long mid = (small+next)/2;
			if(Math.pow(mid-min,2)*count>B)
				next=mid-1;
			else if(Math.pow(mid-min,2)*count<B)
			{
				small=mid+1;
				result=mid;
			}
			else if(Math.pow(mid-min,2)*count==B)
			{
				B-=Math.pow(mid-min,2)*count;
				return mid;
			}

		}
		B-=Math.pow(result-min,2)*count;
		return result;

	}
}
//4 10   N - 컴퓨터 수 B - 예산
// 5 5 6 1
