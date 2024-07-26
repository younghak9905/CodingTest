package day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class back_13418{
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges.add(new Edge(u, v, w));
		}

		// 최소 스패닝 트리를 위한 정렬
		Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

		// 최소 스패닝 트리의 피로도 계산
		int minFatigue = calculateFatigue(edges, N);

		// 최대 스패닝 트리를 위한 정렬 (가중치의 내림차순)
		Collections.sort(edges, (e1, e2) -> e2.weight - e1.weight);

		// 최대 스패닝 트리의 피로도 계산
		int maxFatigue = calculateFatigue(edges, N);

		// 결과 출력
		System.out.println(-maxFatigue * maxFatigue + minFatigue * minFatigue);
	}

	static int calculateFatigue(List<Edge> edges, int N) {
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		int fatigue = 0;
		for (Edge edge : edges) {
			if (find(edge.u) != find(edge.v)) {
				union(edge.u, edge.v);
				if (edge.weight == 0) {
					fatigue++;
				}
			}
		}

		return fatigue;
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			parent[rootY] = rootX;
		}
	}

	static class Edge {
		int u, v, weight;

		Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}
}

