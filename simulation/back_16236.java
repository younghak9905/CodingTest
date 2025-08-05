package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_16236 {
	static int N;
	static int[][]map;

	static int curx=0;
	static int cury=0;
	static int remain=2;
	static int shark=2;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N+1][N+1];


		StringTokenizer st;
		for(int i=1;i<=N;i++){
			st= new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
			{
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9)
				{
					 curx=j;
					 cury=i;
					 map[i][j]=0;

				}
			}
		}
		int ans=0;
		while(true)
		{
			int ret = recur(curx,cury);
			if(ret==-1) break;

			ans+=ret;
			remain--;
			if(remain==0)
			{
				shark++;
				remain = shark;
			}
		}
		System.out.println(ans);


	}
	static int recur(int x,int y) {

		PriorityQueue<fish> q = new PriorityQueue<>((a, b) -> {
			if (a.dis == b.dis) {
				if (a.y == b.y) {
					return a.x - b.x;
				}
				return a.y - b.y;
			}
			return a.dis - b.dis;
		});

		q.add(new fish(x, y, 0));
		boolean[][] visited = new boolean[N + 1][N + 1];
		visited[y][x] = true;
		int cnt;

		while (!q.isEmpty()) {
			fish now = q.poll();

			if (map[now.y][now.x] != 0 && shark > map[now.y][now.x]) {
				map[now.y][now.x] = 0;
				cury = now.y;
				curx = now.x;
				cnt = now.dis;
				return cnt;

			}
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + now.x;
				int ny = dy[i] + now.y;

				if (nx >= 1 && ny >= 1 && nx <= N && ny <= N) {
					if (!visited[ny][nx] && shark >= map[ny][nx]) {
						visited[ny][nx] = true;
						q.add(new fish(nx, ny, now.dis + 1));
					}

				}
			}


		}
		return -1;
	}


	static class fish{
		int x;
		int y;
		int dis;

		public fish(int x,int y,int dis)
		{
			this.x=x;
			this.y=y;
			this.dis=dis;
		}
	}
}
