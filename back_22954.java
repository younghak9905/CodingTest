import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class back_22954 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] graph = new ArrayList[N + 1];
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
		//그래프에서 원하는 만큼 간선을 삭제해, 서로 다른 크기의 트리2개로 반할해보자
		// 그래프 분할 가능 여부 확인 및 분할 수행
		boolean[] visited = new boolean[N + 1];
		List<Integer> tree1 = new ArrayList<>();
		List<Integer> tree2 = new ArrayList<>();

		// DFS를 통한 그래프 탐색 및 분할
		if (dfs(1, graph, visited, tree1, tree2)) {
			System.out.println("YES");

			// 트리 1 출력
			System.out.println(tree1.size() + " " + (tree1.size() - 1));
			for (int i = 0; i < tree1.size() - 1; i++) {
				System.out.println(tree1.get(i) + " " + tree1.get(i + 1));
			}

			// 트리 2 출력
			System.out.println(tree2.size() + " " + (tree2.size() - 1));
			for (int i = 0; i < tree2.size() - 1; i++) {
				System.out.println(tree2.get(i) + " " + tree2.get(i + 1));
			}
		} else {
			System.out.println("NO");
		}
	}

		// DFS 메서드
		 static boolean dfs(int node, List<Integer>[] graph, boolean[] visited, List<Integer> tree1, List<Integer> tree2) {
			visited[node] = true;
			tree1.add(node);

			for (int neighbor : graph[node]) {
				if (!visited[neighbor]) {
					if (dfs(neighbor, graph, visited, tree2, tree1)) {
						return true;
					}
				}
			}

			if (tree1.size() > 0 && tree2.size() > 0) {
				return true;
			}

			tree1.remove(tree1.size() - 1);
			return false;
		}

	}


