package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hsat_7_visit {
	static int count;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static boolean visited[][];
	static int n,m;
	static Queue<int[]> q;
	static ArrayList<int[]> result;

	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q = new LinkedList<>();
		result = new ArrayList<>();
		for(int i=0;i<m;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			result.add(new int[] {a,b});
			map[a][b]=2;
		}
		visited = new boolean[n+1][n+1];
		int []start = result.get(0);
		int now_x = start[0];
		int now_y = start[1];
		visited[now_x][now_y]=true;
		int []target = result.get(1);
		int target_x = target[0];
		int target_y = target[1];
		map[target_x][target_y]=0;

		count=0;
		recur(now_x,now_y,target_x,target_y,1);
		System.out.println(count);




	}
	static void recur(int now_x,int now_y,int target_x,int target_y,int cnt)
	{
		if(cnt==m)
		{
			count++;
			return;
		}
		for(int i=0;i<4;i++)
		{
			int nx = now_x+dx[i];
			int ny = now_y+dy[i];
			if(nx<1 || ny<1 || nx>n || ny>n) continue;
			if(visited[nx][ny] || map[nx][ny]!=0) continue;

			if(map[nx][ny]==0)
			{
				if(nx==target_x && ny==target_y)
				{
					    int []next;
						if(cnt==m-1)
						{
							count++;
							continue;
						}
						visited[nx][ny]=true;
						next = result.get(cnt+1);
						map[next[0]][next[1]]=0;
						recur(nx,ny,next[0],next[1],cnt+1);
						visited[nx][ny]=false;
						map[next[0]][next[1]]=1;

				}else {
					visited[nx][ny]=true;
					recur(nx,ny,target_x,target_y,cnt);
					visited[nx][ny]=false;
				}
			}


		}
	}
}
//3 3    n m
//n
// 0 0 1
// 0 0 0
// 0 0 1
//m
// 3 1
// 1 2
// 2 3