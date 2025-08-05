package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2206 {
	static int[][]map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0;i<N;i++)
		{
			String s = br.readLine();
			for(int j=0;j<M;j++)
			{
				map[i][j]=s.charAt(j)-'0';
			}
		}
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(0,0,1,false));
		boolean[][][]vistied = new boolean[N][M][2];
		vistied[0][0][0]=true;

		int min = Integer.MAX_VALUE;
		while (!q.isEmpty())
		{
			Loc now = q.poll();
			if(now.x==M-1&&now.y==N-1)
			{
				if(now.cnt <min)
				{
					min = now.cnt;
				}
				break;
			}

			for(int i=0;i<4;i++)
			{
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
				if(vistied[ny][nx][now.destroyed?1:0]) continue;

				if(map[ny][nx]==0)
				{	vistied[ny][nx][now.destroyed?1:0]=true;
					q.add(new Loc(nx,ny,now.cnt+1, now.destroyed));
				}else if(map[ny][nx]==1 && !now.destroyed)
				{
						vistied[ny][nx][1] =true;
						q.add(new Loc(nx,ny,now.cnt+1,true));

				}
			}
		}
		System.out.println(min == Integer.MAX_VALUE?-1:min);
	}

	static class Loc{
		int x;
		int y;
		int cnt;
		boolean destroyed;

		public Loc(int x, int y, int cnt, boolean d) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.destroyed = d;
		}
	}
}
