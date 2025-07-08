package bfs_dfs;
import java.io.*;
import java.util.*;
public class back_2468 {
	static boolean[][] visit;
	static int result =0;
	static int maxResult = 0;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int max = 0;

		int[][] map = new int[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);

			}
		}

		for(int i=1;i<=max;i++)
		{	result =0;
			visit = new boolean[N][N]; // Reset visit for each height
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<N;k++)
				{
					if(map[j][k] > i && !visit[j][k]) {
						result++;
						recur(map, new Point(j, k, map[j][k]), i);
					}

				}
			}
			maxResult = Math.max(maxResult, result);
		}
		System.out.println(maxResult);


	}
	static void recur(int [][]map,Point p ,int num)
	{


		visit[p.x][p.y] = true;
		for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx >=0 && nx < map.length && ny >=0 && ny < map.length && !visit[nx][ny] && map[nx][ny] > num) {
					visit[nx][ny] = true;
					recur(map, new Point(nx, ny, map[nx][ny]), num);
				}
		}

	}

	static class Point {
		int x, y,h;
		Point(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
}
