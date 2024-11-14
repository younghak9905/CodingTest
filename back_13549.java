import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_13549 {
	static boolean visited[];
	static int N, K;

	static int minTime = Integer.MAX_VALUE;
	static ArrayList<Integer>[]edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[100001];
		bfs();
		System.out.println(minTime);
		//System.out.println(count);
	}

	static class Node {
		int x;
		int time;

		Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	static void bfs() {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(N, 0));

		while (!q.isEmpty()) {
			Node now = q.poll();
			visited[now.x] = true;
			if (now.x == K)
				minTime = Math.min(minTime, now.time);

			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0)
					next = now.x + 1;
				else if (i == 1)
					next = now.x - 1;
				else
					next = now.x * 2;

				if (next < 0 || next > 100000)
					continue;

				if (!visited[next])
				{

				}
					q.add(new Node(next, now.time + 1));

			}

		}

	}
}






