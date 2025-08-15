package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1389 {
	static ArrayList<Integer> [] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			list[i] = new ArrayList<>();
		}

		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		int min = Integer.MAX_VALUE;
		int result = 1;
		for(int i=1;i<=N;i++)
		{
			int cnt=0;

			cnt=recur(i);
			if(cnt<min)
			{
				min = cnt;
				result = i;

			}

		}
		System.out.println(result);


	}
	static int recur(int start)
	{
		int cnt =0;
		Queue<int []> q = new LinkedList<>();
		q.add(new int[]{start,0});
		boolean visited[] = new boolean[list.length+1];
		visited[start] = true;
		while (!q.isEmpty())
		{
			int[] now = q.poll();
			for(int next: list[now[0]])
			{
				if(!visited[next])
				{
					cnt+= now[1]+1;
					q.add(new int[]{next, now[1]+1});
					visited[next] = true;
				}
			}
		}
		return cnt;
	}
}
