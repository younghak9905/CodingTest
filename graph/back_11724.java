package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_11724 {
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		//간선을 연결
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		//그래프를 순회하여 연결요소의 개수를 구한다.
		visited = new boolean[N + 1];
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
				count++;
			}
		}
		System.out.println(count);
	}

	// DFS 메서드
	static void dfs(int node, ArrayList<Integer>[] graph, boolean[] visited) {
		visited[node] = true;
		for (int neighbor : graph[node]) {
			if (!visited[neighbor]) {
				dfs(neighbor, graph, visited);
			}
		}
	}

	static void bfs(int s)
	{
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;
		while(!q.isEmpty())
		{
			int now = q.poll();
			for(int neighbor : graph[now])
			{
				if(!visited[neighbor])
				{
					visited[neighbor] = true;
					q.add(neighbor);
				}
			}
		}
	}

}
