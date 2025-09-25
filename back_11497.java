import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_11497 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-->0)
		{
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
				return o2-o1;
			});
			for(int i=0;i<N;i++)
			{
				pq.add(Integer.parseInt(st.nextToken()));
			}
			int max = 0;

				int mid1 = pq.poll();
				int mid2 = mid1;
				if(pq.size()%2!=0)
					mid2 =pq.poll();
				max = Math.max(max,Math.abs(mid1-mid2));
				while(!pq.isEmpty())
				{
					max = Math.max(max,Math.abs(mid1-pq.peek()));
					mid1 = pq.poll();
					max = Math.max(max,Math.abs(mid2-pq.peek()));
					mid2 = pq.poll();
				}
				max = Math.max(max,Math.abs(mid1-mid2));

				sb.append(max).append("\n");
		}
		System.out.println(sb);

	}
}
