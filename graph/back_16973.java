package graph;
import java.io.*;
import java.util.*;
public class back_16973 {
	static int M, N;
	static int[][] map;
	static int[][] result;
	static int dx[] = {0, 0, -1, 1}; // 상하좌우 이동
	static int dy[] = {-1, 1, 0, 0}; // 상하좌우 이동
	static List<int[]> list = new ArrayList<>(); // 이동 가능한 위치를 저장할 리스트
	static int ans = -1; // 결과값 초기화
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					map[i][j] = -1; // 벽인 경우 -1로 표시
					list.add(new int[] {i, j}); // 벽의 위치를 리스트에 추가
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int fr = Integer.parseInt(st.nextToken());
		int fc = Integer.parseInt(st.nextToken());


		recur(sr, sc, H, W, fr, fc);
		System.out.println(ans);

	}

	static void recur(int r, int c, int h,int w, int fr,int fc)
	{
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N+1][M+1];

		queue.add(new int[] {r, c});
		visit[r][c] = true; // 시작 위치 방문 표시
		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			if(p[0] == fr && p[1] == fc) {
				ans = map[p[0]][p[1]];
				return;
			}

			for(int i=0;i<4;i++)
			{
				int x = p[0] + dx[i];
				int y = p[1] + dy[i];

				if(x < 1 || x > N || y < 1 || y > M || visit[x][y]) continue;
				if(!isValid(x,y,h,w)) continue; // 유효한 위치인지 확인
				if(map[x][y] == 0)
				{
					queue.add(new int[] {x, y}); // 다음 위치와 이동 횟수 증가
					visit[x][y] = true; // 방문 표시
					map[x][y]= map[p[0]][p[1]] + 1; // 이동 횟수 증가
				}




			}




		}

		// 시작 위치와 이동 횟수
	}
	static boolean isValid(int x, int y, int h, int w) {
		// 주어진 위치 (x, y)에서 가로 h, 세로 w 크기의 직사각형이 유효한지 확인
		if ( x+h-1 > N ||  y+w-1 > M) return false; // 범위 초과
		for(int i=0;i<list.size();i++)
		{
			int[] wall = list.get(i);
			int wallX = wall[0];
			int wallY = wall[1];
			// 벽이 직사각형 영역에 포함되는지 확인
			if (wallX >= x && wallX <= x + h - 1 && wallY >= y && wallY <= y + w - 1) {
				return false; // 벽이 포함되면 유효하지 않음
			}
		}
		return true; // 유효한 위치
	}
}
