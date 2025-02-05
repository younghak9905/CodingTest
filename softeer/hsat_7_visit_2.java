package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hsat_7_visit_2 {
	static int[][] map;
	static int []dx = {1,0,-1,0};
	static int []dy = {0,1,0,-1};
	static int N,M;
	static int count=0;
	static 	ArrayList<int []> result;
	public static void main(String[] arg) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int i=1;i<=N;i++)
		{	st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = new ArrayList<>();
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			result.add(new int[] {x,y});
			map[x][y]=2;

		}

		int []start  =result.get(0);
		int []next = result.get(1);
		boolean [][]visited = new boolean[N+1][N+1];
		visited[start[0]][start[1]]= true;
		map[next[0]][next[1]]=0;
		recur(1,visited,start[0],start[1],next[0],next[1]);
		System.out.println(count);




	}
	static void recur(int cnt, boolean [][]visited, int now_x,int now_y,int target_x,int target_y)
	{
		if(cnt==M)
		{
			count++;

			return;
		}

		for(int i=0;i<4;i++)
		{
			int nx = now_x + dx[i];
			int ny = now_y + dy[i];

			if(nx<=0 || nx>N || ny<=0 || ny>N) continue;
			if(visited[nx][ny]==true || map[nx][ny]!=0) continue;
			if(map[nx][ny]==0)
			{
				if(nx == target_x && ny == target_y)
				{
					if(cnt==M-1)
					{
						count++;
						return;
					}
					visited[nx][ny]=true;
					target_x = result.get(cnt+1)[0];
					target_y = result.get(cnt+1)[1];
					map[target_x][target_y]=0;
					recur(cnt+1,visited,nx,ny,target_x,target_y);
					visited[nx][ny]=false;
					map[target_x][target_y]=1;

				}
				else {
					visited[nx][ny]=true;
					recur(cnt,visited,nx,ny,target_x,target_y);
					visited[nx][ny]=false;
				}

			}


		}
	}
}
