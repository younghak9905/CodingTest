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
		int N = Integer.parseInt(st.nextToken()); // ��ٸ��� ����
		int M = Integer.parseInt(st.nextToken()); // ���� ����

		for(int i=0;i<N+M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x]= y; // ��ٸ��� ���� ��ġ�� ����
		}
		recur(1);


	}

	static void recur(int v)
	{
		Queue<int[]> queue = new java.util.LinkedList<>();
		queue.add(new int[] {v, 0}); // ���� ��ġ�� �̵� Ƚ��
		visit[v] = true;
		while (!queue.isEmpty()) {
			int []p = queue.poll();
			if (p[0] == 100) {
				System.out.println(p[1]); // 100�� �������� �� �̵� Ƚ�� ���
				return;
			}

			for(int i=1;i<=6;i++)
			{
				int next = p[0]+i;
				if(next<=100)
				{
					if(map[next]!=0)
					{
						next = map[next]; // ��ٸ��� ���� Ÿ�� �̵�
					}
					if(!visit[next]) // �湮���� ���� ��ġ���
					{
						visit[next] = true; // �湮 ǥ��
						queue.add(new int[] {next, p[1]+1}); // ���� ��ġ�� �̵� Ƚ�� ����
					}
				}
			}

		}
	}

}
