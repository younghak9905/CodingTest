package simulation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_31416 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		Queue<Integer> aq = new LinkedList<>();
		Queue<Integer> bq = new LinkedList<>();

		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			int ta = Integer.parseInt(st.nextToken());
			int tb = Integer.parseInt(st.nextToken());
			int va = Integer.parseInt(st.nextToken());
			int vb = Integer.parseInt(st.nextToken());
			for(int j=0;j<va;j++)
			{
				aq.add(ta);
			}
			for(int j=0;j<vb;j++)
			{
				bq.add(tb);
			}

			int a = 0;
			int b = 0;
			int time=0;
			while (!aq.isEmpty() || !bq.isEmpty() || b>0||a>0)
			{
				if(bq.isEmpty() && b<=0)
				{
					if(!aq.isEmpty())
					{
						b = aq.poll();
					}
				}
				else if(!bq.isEmpty() && b<=0)
				{
					b = bq.poll();
				}

				if(!aq.isEmpty() && a<=0)
				{
					a = aq.poll();
				}

				int min = Math.min(a, b);
				int max = Math.max(a, b);
				if(min==0)
				{
					min = max;
					if(a==0)
						a=b;
					else
						b=a;
				}
				a-= min;
				b-= min;
				time+=min;

			}
			sb.append(time + "\n");


		}

		System.out.print(sb);





	}
}
