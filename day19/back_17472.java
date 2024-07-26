package day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_17472 {
	static int map[][];
	static boolean visited[][];
	static PriorityQueue<Edge> queue;
	static ArrayList<int[]> mList;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	static int sNum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1][M+1];

		for(int i=0;i<N;i++)
		{	st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		sNum=1;


		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(map[i][j]!=0 && visited[i][j]!=true)
				{
					BFS(i,j);
				}
			}
		}

	}

	static class Edge implements Comparable<back_1197.Edge>{
		int start ,end;
		int w;
		public Edge(int start,int end,int w)
		{
			this.start=start;
			this.end= end;
			this.w=w;
		}
		@Override
		public int compareTo(back_1197.Edge o)
		{
			return this.w - o.w;
		}
	}

	static void BFS(int s,int e)
	{
		Queue<int[]> queue = new LinkedList<>();
		mList = new ArrayList<>();
		int[] start = {s,e};
		queue.add(start);
		mList.add(start);
		visited[s][e]=true;
		map[s][e]=sNum;
		while(!queue.isEmpty())
		{
			int now[] = queue.poll();
			int r = now[0];
			int c = now[1];

			for(int d = 0;d<4;d++)
			{
				int tempR = dy[d];
				int tempC = dx[d];
			}
		}
	}




}
