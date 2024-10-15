package IT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_14940 {
	static int[][]map;
	static int[][]dist;
	static boolean [][]visited;
	static int []dx = {0,0,1,-1};
	static int []dy = {1,-1,0,0};
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist= new int[N][M];
		int n=0;
		int m=0;

		visited = new boolean[N][M];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				int a= Integer.parseInt(st.nextToken());
				if(a==0)
				{
					visited[i][j]=true;
					dist[i][j]=0;
				}
				else if(a==2)
				{
					n=i;
					m=j;
					dist[i][j]=0;
				}
				else{
					dist[i][j]=-1;
				}
				map[i][j]=a;

			}
		}

		StringBuilder sb = new StringBuilder();
		bfs(n,m);
		dist[n][m]=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{

				sb.append(dist[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void bfs(int n,int m)
	{
		Queue<int[]> queue = new LinkedList<>();
		int []start = {n,m};
		queue.add(start);
		if(visited[start[0]][start[1]])
			return;
		visited[start[0]][start[1]]=true;
		while(!queue.isEmpty())
		{
			int []cur = queue.poll();
			for(int i=0;i<4;i++)
			{
				int nx = cur[1]+dx[i];
				int ny = cur[0]+dy[i];
				if(nx>=0 && ny>=0 && ny<N && nx<M)
				{
					if(visited[ny][nx]==false)
					{
						visited[ny][nx]=true;
						dist[ny][nx]=dist[cur[0]][cur[1]]+1;
						queue.add(new int[] {ny,nx});
					}
				}
			}
		}
	}
}
