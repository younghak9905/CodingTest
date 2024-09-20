package weak0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_7576 {
	static int visited[][];
	static int D[][];

	static int dx[];
	static int dy[];

	static int A[][];
	static Queue<Tomato> queue = new LinkedList<Tomato>();
	public static void main(String[] args) throws Exception {
		dx = new int[] {0,0,1,-1};
		dy = new int[] {1,-1,0,0};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st= new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		D = new int[M][N];
		visited = new int[M][N];
		for(int i=0;i<M;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				D[i][j]=Integer.parseInt(st.nextToken());
				if(D[i][j]!=0)
				{
					visited[i][j]=D[i][j];
					if(D[i][j]==1)
					{
						queue.add(new Tomato(i,j));
					}
				}
			}

		}
		BFS();
		int MAX=0;
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(visited[i][j]==0)
				{
					System.out.println(-1);
					return;
				}
				if(visited[i][j]>MAX)
				{
					MAX=visited[i][j];
				}
			}
		}
		System.out.println(MAX-1);
	}
	static void BFS()
	{
		while(!queue.isEmpty())
		{
			Tomato linkedNode = queue.poll();
			for(int i=0;i<4;i++)
			{
				int nx = linkedNode.x+dx[i];
				int ny = linkedNode.y+dy[i];
				if(nx>=0 && ny>=0 && nx<visited.length && ny<visited[0].length)
				{	if(D[nx][ny]==-1)
					{
						continue;
					}
					else if(visited[nx][ny]>visited[linkedNode.x][linkedNode.y]+1 || visited[nx][ny]==0)
					{
						visited[nx][ny]=visited[linkedNode.x][linkedNode.y]+1;
						queue.add(new Tomato(nx,ny));
					}
					else{
						continue;
				}
				}
			}

		}


	}

	static class Tomato{
		int x;
		int y;
		public Tomato(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
}


}
