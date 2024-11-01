package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class softeer_7726 {

		static boolean visited[][];
		static int dd[][];
		static char map[][];
		static int N, M;
		static int dx[] = {0, 0, 1, -1};
		static int dy[] = {1, -1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		dd = new int[N + 1][M + 1];
		int start[] = new int[2];
		int end[] = new int[2];
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1);
				if (map[i][j] == '.')
					continue;
				else if (map[i][j] == 'D') {
					end[0] = i;
					end[1] = j;
				} else if (map[i][j] == 'G') {
					list.add(new int[] {i, j});
				} else if (map[i][j] == 'N') {
					start[0] = i;
					start[1] = j;
				}

			}
		}
		int result=0;
		result=bfs(new boolean[N+1][M+1],start[0], start[1],0,false);
		if(result==-1)
		{
			System.out.println("No");
			return;
		}
		if(list.size()==0)
		{
			System.out.println("Yes");
			return;
		}

		int sum=0;
		int col=0;
		int row=0;
		int min =Integer.MAX_VALUE;
		int [] ghost= new int[2];
		for(int[] g : list)
		{
			int x = g[0];
			int y = g[1];
			col = Math.abs(start[0]-x);
			row = Math.abs(start[1]-y);
			sum = col+row;
			if(min>sum)
			{
				min = sum;
				ghost[0]=x;
				ghost[1]=y;
			}
		}

		System.out.println(result<bfs(new boolean[N+1][M+1],ghost[0], ghost[1],0,true)?"Yes":"No");



	}
	static int bfs(boolean [][]visited, int x, int y,int d,boolean isG)
	{
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y,d));
		visited[x][y] = true;
		while(!q.isEmpty())
		{
			Point now = q.poll();
			int now_x = now.x;
			int now_y = now.y;
			if(map[now_x][now_y]=='D')
			{
				return now.d;
			}
			for(int i=0;i<4;i++)
			{
				int nx = now_x + dx[i];
				int ny = now_y + dy[i];
				if(nx<1 || ny<1 || nx>N || ny>M)
					continue;
				if(visited[nx][ny]) continue;
				if(map[nx][ny]=='#' && !isG) continue;
				visited[nx][ny]=true;
				q.add(new Point(nx,ny,now.d+1));
				dd[nx][ny]=now.d+1;
			}
		}
		return -1;

	}
	static class Point{
		int x, y,d;
		Point(int x, int y,int d)
		{
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}


	}

// .....D
// ......
// .GN#..
// G.....