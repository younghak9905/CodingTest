package graph;
import java.io.*;
import java.util.*;
public class back_16973 {
	static int M, N;
	static int[][] map;
	static int[][] result;
	static int dx[] = {0, 0, -1, 1}; // �����¿� �̵�
	static int dy[] = {-1, 1, 0, 0}; // �����¿� �̵�
	static List<int[]> list = new ArrayList<>(); // �̵� ������ ��ġ�� ������ ����Ʈ
	static int ans = -1; // ����� �ʱ�ȭ
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
					map[i][j] = -1; // ���� ��� -1�� ǥ��
					list.add(new int[] {i, j}); // ���� ��ġ�� ����Ʈ�� �߰�
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
		visit[r][c] = true; // ���� ��ġ �湮 ǥ��
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
				if(!isValid(x,y,h,w)) continue; // ��ȿ�� ��ġ���� Ȯ��
				if(map[x][y] == 0)
				{
					queue.add(new int[] {x, y}); // ���� ��ġ�� �̵� Ƚ�� ����
					visit[x][y] = true; // �湮 ǥ��
					map[x][y]= map[p[0]][p[1]] + 1; // �̵� Ƚ�� ����
				}




			}




		}

		// ���� ��ġ�� �̵� Ƚ��
	}
	static boolean isValid(int x, int y, int h, int w) {
		// �־��� ��ġ (x, y)���� ���� h, ���� w ũ���� ���簢���� ��ȿ���� Ȯ��
		if ( x+h-1 > N ||  y+w-1 > M) return false; // ���� �ʰ�
		for(int i=0;i<list.size();i++)
		{
			int[] wall = list.get(i);
			int wallX = wall[0];
			int wallY = wall[1];
			// ���� ���簢�� ������ ���ԵǴ��� Ȯ��
			if (wallX >= x && wallX <= x + h - 1 && wallY >= y && wallY <= y + w - 1) {
				return false; // ���� ���ԵǸ� ��ȿ���� ����
			}
		}
		return true; // ��ȿ�� ��ġ
	}
}
