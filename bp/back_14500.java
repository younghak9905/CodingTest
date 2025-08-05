package bp;
import java.io.*;
import java.util.*;
public class back_14500 {
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	static int count=0;
	static int max =0;
	static int N, M;
	static int[][] arr;
	static boolean [][]visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i=1;i<=N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=M;j++)
			{
				visited[i][j] = true;
				recur(i,j,arr[i][j],1);
				visited[i][j] = false;
			}
		}
		System.out.println(max);

	}
	static void recur(int x, int y,int sum,int cnt) {

		if(cnt==4) {
			max = Math.max(max, sum);
			return;
		}
		for(int i=0;i<4;i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<1 || ny<1 || nx>N || ny>M ) continue;
			if(!visited[nx][ny])
			{
				if(cnt==2)
				{
					visited[nx][ny] = true;
					recur(x, y,  sum + arr[nx][ny], cnt + 1); // Skip the next step
					visited[nx][ny] = false;
				}
				visited[nx][ny] = true;
				recur(nx, ny, sum + arr[nx][ny], cnt + 1);
				visited[nx][ny] = false;
			}


		}
	}
}
