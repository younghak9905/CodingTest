package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class back_2655 {
	static int N;
	static int [][]map;

	static int []dx = {1,0,-1,0};
	static int []dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map= new int[N+1][N+1];
		for(int i=1;i<=N;i++)
		{	String line = br.readLine();
			for(int j=1;j<=N;j++)
			{
				map[i][j]= line.charAt(j-1)-'0'==0?1:0;
			}
		}
		int result = recur();

		System.out.println(result);


	}

	static int recur()
	{
		PriorityQueue<Point> queue = new PriorityQueue<>((o1,o2)-> o1.count-o2.count);
		queue.offer(new Point(1,1,0));
		boolean [][]visited = new boolean[N+1][N+1];
		visited[1][1] = true;

		while(!queue.isEmpty())
		{
			Point now = queue.poll();
			if(now.x==N && now.y==N)
				return now.count;

			for(int i=0;i<4;i++)
			{
				int x = now.x +dx[i];
				int y =now.y + dy[i];
				if(x<1 || y<1 || x>N || y>N) continue;

				if(!visited[x][y])
				{
					if(map[x][y]==0)
					{
						visited[x][y]=true;
						queue.offer(new Point(x,y,now.count));
					}

					if(map[x][y]==1)
					{
						visited[x][y]=true;
						queue.offer(new Point(x,y,now.count+1));
					}
				}

			}
		}

		return 0;
	}

	static class Point{
		int x;
		int y;
		int count;
		Point(int x,int y, int count)
		{
			this.x = x;
			this.y=y;
			this.count=count;
		}
	}
}
