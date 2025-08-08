import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_19638 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //
		long H = Long.parseLong(st.nextToken()); //
		int T = Integer.parseInt(st.nextToken()); //
		PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->{
			if(a>=b) return -1;
			else return 1;


		});
		for(int i=0;i<N;i++)
		{
		   pq.add(Long.parseLong(br.readLine()));
		}


		for(int i=0;i<T;i++)
		{
			long h=pq.peek();
			if(H>pq.peek())
			{
				System.out.println("YES"+"\n"+i);
				return;
			}else if(h>1)
			{
				pq.poll();
				h=(long)Math.floor((double)h/2);
				pq.add(h);
			}
		}

		if(pq.peek()>=H)
			System.out.println("NO" + "\n"+pq.peek());
		else
			System.out.println("YES" + "\n"+T);

	}
}
