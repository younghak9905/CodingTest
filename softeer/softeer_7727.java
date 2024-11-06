package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class softeer_7727 {
	static boolean visited[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int n, m;
	static int[][] map;
	static ArrayList<int[]> worker;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1][n + 1];
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;

		worker = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			result += map[a][b];
			visited[a][b] = true;
			worker.add(new int[] {a, b});
		}
		recur(0, 0, worker.get(0)[0], worker.get(0)[1], result);
		System.out.println(result);
	}

	static void recur( int cnt, int wcnt, int x, int y, int sum) {

		if (cnt == 3) {
			if (wcnt + 1 < m) {
				recur(0, wcnt + 1, worker.get(wcnt+1)[0], worker.get(wcnt+1)[1], sum);
			}
			result =Math.max(result, sum);
			return;
		}
		for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (nx < 1 || ny < 1 || nx > n || ny > n)
					continue;
				if (visited[nx][ny])
					continue;
				if (!visited[nx][ny]) {

					visited[nx][ny] = true;
					recur( cnt + 1, wcnt, nx, ny, sum + map[nx][ny]);
					visited[nx][ny] = false;

				}
			}


	}
}
//4 2 n m
//nxn
// 20 26 185 80
// 100 20 25 80
// 20 20 88 99
// 15 32 44 50
// 1 2
// 2 3
