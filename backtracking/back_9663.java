package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_9663 {
	static Stack<queen> result = new Stack<queen>();
	static Stack<Integer> chess = new Stack<Integer>();
	static int N;
	static int dx[] = { 1, -1, 1, -1 };
	static int dy[] = { 1, 1, -1, -1 }; // 대각
	static boolean [][]visit;
	static int count = 0;
	static boolean [][]check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		visit = new boolean[N+1][N+1];
		check= new boolean[N+1][N+1];
		count = 0;
		recur(0);
		System.out.println(count);
	}

	static class queen
	{
		int x;
		int y;
		queen(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	static boolean check(int x, int y)
	{

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			while (nx < N && nx >= 0 && ny < N && ny >= 0) {
				if (visit[ny][nx] == true) {
					return false;
				}
				nx += dx[i];
				ny += dy[i];
			} // 대각
		}

		for(int i=0;i<N;i++)
		{
			if(visit[y][i])
			{
				return false;
			}
			if(visit[i][x])
			{
				return false;
			}
		}

		return true;
	}
	static void recur(int cnt)
	{
		if(cnt==N)
		{

			count++;
			return;
		}

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++) {
				if(!visit[i][j] && (chess.isEmpty() || chess.peek()<i*N+j))
				{

					if(!check(j,i))
					{
						continue;
					}
					visit[i][j] = true;
					chess.push(i*N+j);
					recur(cnt+1);
					visit[i][j] = false;
					chess.pop();
				}

			}

		}
	}
}
