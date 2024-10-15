package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1911 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
		}

	}
	static class pool implements Comparable<pool>
	{
		long start;
		long end;
		public pool(long start,long end)
		{
			this.start=start;
			this.end=end;
		}
		@Override
		public int compareTo(pool o)
		{
			return (int) (this.start-o.start);
		}
	}

}
