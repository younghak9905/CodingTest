package backtracking;
import java.io.*;
import java.util.*;
public class back_18430 {
	static int [][]map;

	static int max =0;
	static boolean visited[][];

	static int dx[][] = {{0,1}, {0,1}, {-1,0}, {-1,0}};
	static int dy[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static Stack<Integer> stack;

	static int M, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(N < 2 || M < 2) {
			System.out.println(0);
			return;
		}
		recur(0,0);
		System.out.println(max);


	}

	static void recur(int cnt,int sum)
	{
		if(cnt == N*M)
		{
			max = Math.max(max, sum);
			return;
		}
		int x = cnt / M; // Row index
		int y = cnt % M; // Column index


				if(!visited[x][y])
				{
					for(int k=0;k<4;k++)
					{
						int nx = x + dx[k][0];
						int nnx = x + dx[k][1];
						int ny = y + dy[k][0];
						int nny = y + dy[k][1];
						if(isValid(nx, ny, nnx, nny)) {
							visited[x][y] = true;
							visited[nx][ny] = true;
							visited[nnx][nny] = true;
							int newSum = sum + (map[x][y] * 2 + map[nx][ny] + map[nnx][nny]);
							recur(cnt + 1, newSum);
							visited[x][y] = false;
							visited[nx][ny] = false;
							visited[nnx][nny] = false;
						}
					}
				}
				recur(cnt + 1, sum); // Skip this cell

	}

	static boolean isValid(int nx, int ny ,int nnx, int nny) {
		if(nx < 0 || ny < 0 || nnx < 0 || nny < 0 || nx >= N || ny >= M || nnx >= N || nny >= M) {
			return false;
		}
		if(visited[nx][ny] || visited[nnx][nny]) {
			return false;
		}
		return true;
	}

	// Add any helper methods or classes needed for the solution here
}
