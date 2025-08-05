package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_1261 {
	static int []dx = {1,0,-1,0};
	static int []dy = {0,1,0,-1};
	static boolean [][]visited;

	static int [][]map;
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		for(int i=1;i<=N;i++)
		{	String maze = br.readLine();
			for(int j=1;j<=M;j++)
			{
				map[i][j]=maze.charAt(j-1)-'0';
			}
		}
		visited  = new boolean[N+1][M+1];
		int result = recur();
		System.out.println(result);
	}

	static int recur()
	{
		PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
		queue.add(new Point(1,1,0));
		visited[1][1]=true;
		while(!queue.isEmpty())
		{
			Point now = queue.poll();
			if(now.x==N && now.y==M)
				return now.count;
			for(int i=0;i<4;i++)
			{
				int x = now.x+dx[i];
				int y = now.y+dy[i];
				if(x<1 || y < 1 || x>N || y>M) continue;
				if(!visited[x][y] && map[x][y]==1)
				{
					visited[x][y]=true;
					queue.offer(new Point(x,y,now.count+1));
				}

				if(!visited[x][y] && map[x][y]==0)
				{
					visited[x][y]=true;
					queue.offer(new Point(x,y,now.count));
				}
			}
		}
		return 0;

	}
	static class Point  {
		int x;
		int y;
		int count;
		Point(int x,int y, int count)
		{
			this.x=x;
			this.y=y;
			this.count=count;
		}
	}
}
