package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_11403 {
	static int A[];
	static ArrayList<Integer>[] list;

	static int [][]map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map  = new int[N][N];
		list = new ArrayList[N];

		for(int i=0;i<N;i++)
		{
			list[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
				{
					list[i].add(j);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			dfs(i, visited);
			for (int j = 0; j < N; j++) {
				result[i][j] = visited[j] ? 1 : 0;
			}
		}
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

	static void dfs(int u, boolean[] visited) {
		for (int v : list[u]) {
			if (!visited[v]) {
				visited[v] = true;
				dfs(v, visited);
			}
		}
	}



}
