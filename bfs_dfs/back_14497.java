package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_14497 {
	static int N,M;
	static int [][]map;
	static int []dx = {1,0,-1,0};
	static int []dy = {0,1,0,-1};
	static boolean [][]visited;
	public static void main(String[] args) throws  Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		st = new StringTokenizer(br.readLine());

		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());

		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());

		for(int i=1;i<=N;i++)
		{	String line = br.readLine();
			for(int j=1;j<=M;j++)
			{
				map[i][j] = line.charAt(j-1)-'0';
			}
		}
		map[x2][y2]=1;
		System.out.print(recur(x1,y1,x2,y2));

	}

	static int recur(int x1,int y1,int x2,int y2)
	{
		PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
		queue.add(new Point(x1,y1,0));
		visited = new boolean[N+1][M+1];
		visited[x1][y1]=true;
		while(!queue.isEmpty())
		{
			Point now = queue.poll();
			if(now.x==x2 && now.y==y2)
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
