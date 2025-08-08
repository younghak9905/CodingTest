package bp;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class back_2468 {
	static int []dx = {0, 0, -1, 1};
	static int []dy = {-1, 1, 0, 0};

	static boolean[][] visited;
	static int[][]map;

	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		StringTokenizer st;
		int max =0;
		int min = 100;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		int result = 0;
		for(int r=min-1;r<=max;r++)
		{
			int count=0;
			visited = new boolean[N][N]; // Reset visited for each height
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(map[i][j] > r && !visited[i][j])
					{
						recur(i,j,r);
						count++;
					}
				}
			}
			result = Math.max(result, count);
		}
		System.out.println(result);
	}
	static void recur(int x,int y,int cnt)
	{
		visited[x][y] = true;

		for(int i=0;i<4;i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] > cnt)
			{
				recur(nx, ny, cnt);
			}
		}
	}
}
