package graph;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class back_1058 {
	static ArrayList<Integer>[] list;
	static int max =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		for(int i=0;i<N;i++)
		{
			list[i]=new ArrayList<>();
		}
		for(int i=0;i<N;i++)
		{
			String s =br.readLine();
			for(int j=0;j<N;j++)
			{
				if(i==j)continue;
				if(s.charAt(j)=='Y')
				{
					list[i].add(j);
				}
			}
		}
		int result =0;
		for(int i=0;i<N;i++)
		{
			boolean []visited = new boolean[N];
			recur(i, visited,0);
			result = Math.max(result, max);
			max=0;

		}
		System.out.println(result);


	}
	static void recur(int v, boolean []visited,int depth)
	{
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{v,depth});

		if(visited[v])return;
		visited[v]=true;

		while (!queue.isEmpty())
		{

			int now[] = queue.poll();
			int idx = now[0];
			depth = now[1];
			if(depth==2)break;

			for(int next : list[idx])
			{
				if(!visited[next])
				{
					visited[next]=true;
					queue.add(new int[]{next,depth+1});
					max++;
				}
			}

		}

	}

}
