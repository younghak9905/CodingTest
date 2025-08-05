package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2056 {
	static ArrayList<Integer>[] list;
	static int[] cost;
	static int[] time;
	static int[] indegree;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		time = new int[N+1];
		indegree = new int[N+1];
		StringTokenizer st;
		for(int i=1;i<=N;i++)
		{
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			indegree[i] = Integer.parseInt(st.nextToken());
			for(int j=0;j<indegree[i];j++)
			{
				int a = Integer.parseInt(st.nextToken());
				list[a].add(i);
			}
		}

		cost = new int[N+1];
		recur();
		int result = 0;
		for(int i=1;i<=N;i++)
		{
			result = Math.max(result, cost[i]);
		}
		System.out.println(result);

	}
	static void recur()
	{
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++)
		{
			if(indegree[i] == 0)
			{
				queue.add(i);
				cost[i] = time[i];
			}
		}
		while(!queue.isEmpty())
		{
			int idx = queue.poll();
			for(int next : list[idx])
			{
				cost[next] = Math.max(cost[next], cost[idx] + time[next]);
				indegree[next]--;
				if(indegree[next] == 0)
				{
					queue.add(next);
				}
			}
		}
	}
}
