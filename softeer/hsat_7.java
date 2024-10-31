package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class hsat_7 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		HashMap<Integer,Integer> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			return o1-o2;
		});
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
		{
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		int index = 1;
		while(!pq.isEmpty())
		{
			int a = pq.poll();
			map.put(a, index++);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<q;i++)
		{
			int a = Integer.parseInt(br.readLine());
			if(map.get(a)==null)
			{
				sb.append(0).append("\n");
				continue;
			}
			int ma = map.size();
			int target = map.get(a);
			sb.append((target-1)*(ma-target)).append("\n");
		}
		System.out.println(sb);
	}
}
// 5 3  n,q
// 5 2 3 1 6  // n
// 1  q
// 3  q
// 6  q