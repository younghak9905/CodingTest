package day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2178 {
	static boolean [][]visited;
	static int [][]A;

	static int N,M;

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		A =new int[N][M];
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0;j<M;j++)
			{
				A[i][j]=line.charAt(j) - '0';
			}
		}
		visited=new boolean[N][M];
		BFS(0,0);
		System.out.print(A[N-1][M-1]);
	}

	public static void BFS(int i, int j)
	{
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		visited[i][j]=true;
		while(!queue.isEmpty())
		{
			int linkedNode[] = queue.poll();
			for(int k=0;k<4;k++)
			{
				int x = linkedNode[0] +dx[k];
				int y = linkedNode[1] +dy[k];
				if(x<N && y<M) {
					if (x >= 0 && y >= 0)
					{
						if (A[x][y] != 0 && !visited[x][y]) {
							visited[x][y] = true;
							A[x][y] = A[linkedNode[0]][linkedNode[1]] + 1; //깊이 업데이트
							queue.offer(new int[] {x, y});
						}
					}
				}
			}
		}

	}


}
