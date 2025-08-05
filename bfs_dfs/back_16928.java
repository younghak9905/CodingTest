package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_16928 {
	static int []map = new int[101];
	static boolean []visit = new boolean[101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사다리의 개수
		int M = Integer.parseInt(st.nextToken()); // 뱀의 개수

		for(int i=0;i<N+M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x]= y; // 사다리나 뱀의 위치를 저장
		}
		recur(1);


	}

	static void recur(int v)
	{
		Queue<int[]> queue = new java.util.LinkedList<>();
		queue.add(new int[] {v, 0}); // 시작 위치와 이동 횟수
		visit[v] = true;
		while (!queue.isEmpty()) {
			int []p = queue.poll();
			if (p[0] == 100) {
				System.out.println(p[1]); // 100에 도달했을 때 이동 횟수 출력
				return;
			}

			for(int i=1;i<=6;i++)
			{
				int next = p[0]+i;
				if(next<=100)
				{
					if(map[next]!=0)
					{
						next = map[next]; // 사다리나 뱀을 타고 이동
					}
					if(!visit[next]) // 방문하지 않은 위치라면
					{
						visit[next] = true; // 방문 표시
						queue.add(new int[] {next, p[1]+1}); // 다음 위치와 이동 횟수 증가
					}
				}
			}

		}
	}

}
