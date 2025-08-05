package simulation;
import java.util.*;
import java.io.*;

public class back_2573 {
	static int dx[] = {1,-1,0,0};
	static int dy[]= {0,0,-1,1};
	static int N,M;
	static int[][]map;
	static boolean[][]visited;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for(int i=0;i<N;i++)
		{ 	st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		int cnt =0;
		int result =0;
		while ((cnt = recur())<2){
			if(cnt==0)
			{
				result=0;
				break;
			}
			bfs();
			result++;

		}
		System.out.println(result);


	}
	static int recur()
	{
		boolean[][] visited = new boolean[N][M];
		int cnt =0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(map[i][j]!=0 && !visited[i][j])
				{
					dfs(i,j,visited);
					cnt++;
				}
			}
		}
		return cnt;
	}
	static void dfs(int x,int y,boolean[][]visited)
	{
		visited[x][y] = true;
			int nx;
			int ny;
			for(int i=0;i<4;i++)
			{
				nx = x + dx[i];
				ny = y+ dy[i];
				if(nx<0 || ny < 0 || nx>+N || ny>+M) continue;
				if(map[nx][ny]!=0 && !visited[nx][ny])
				{
					dfs(nx,ny,visited);
				}
		}

	}

	static void bfs()
	{
		Queue<int []> queue = new LinkedList<>();

		boolean [][]visited  = new boolean[N][M];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(map[i][j]!=0)
				{
					queue.add(new int[]{i,j});
					visited[i][j] = true;
				}
			}
		}

		int nx = 0,ny=0;
		while (!queue.isEmpty())
		{
			int []now = queue.poll();
			int x = now[0];
			int y = now[1];

			int num =0;
			for(int i=0;i<4;i++)
			{
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(!visited[nx][ny] && map[nx][ny]==0)
				{
					num++;
				}
			}
			if(map[x][y] - num<0)
			{
				map[x][y]=0;
			}else{
				map[x][y]-=num;
			}
		}

	}


}
