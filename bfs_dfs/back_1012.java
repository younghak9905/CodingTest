package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1012 {
	static int N,M,K;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static int [][]map;
	static int result=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++)
		{
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int i=0;i<K;i++)
			{
				st= new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X]=1;
			}
			visited = new boolean[N][M];
			for(int i=0;i<N && K>0;i++)
			{
				for(int j=0;j<M;j++)
				{
					if(map[i][j]==1 && !visited[i][j])
					{
						bfs(j,i);
						if(K==0)
							break;
					}
				}

			}
			sb.append(result+"\n");
			result=0;

		}
		System.out.print(sb);
	}

	static void bfs(int x,int y)
	{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});
		visited[y][x]=true;

		while (!q.isEmpty())
		{
			int []now = q.poll();
			for(int i=0;i<4;i++)
			{
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];

				if(nx<0 || ny<0|| nx>M-1 ||ny>N-1) continue;
				if(!visited[ny][nx] && map[ny][nx]==1)
				{
					visited[ny][nx] =true;
					q.add(new int[]{nx,ny});
				}
			}

		}
		result++;
		K--;
	}
}
