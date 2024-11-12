import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_12851 {
	static int visited[];
	static int parent[];
	static int N,K;
	static int count=0;
	static int result;
	static int minTime = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N >= K) {
			System.out.println(N-K);
			System.out.println(1);
			return;
		}
		visited = new int[100001];
		parent = new int[100001];
		result = 0;

		bfs();
		System.out.println(minTime);
		System.out.println(count);
	}
	static class Node
	{
		int now;
		int depth;
		Node(int now,int depth)
		{
			this.now = now;
			this.depth = depth;
		}
	}
	static void bfs()
	{

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 1;
		while(!q.isEmpty())
		{
			int now = q.poll();
			if(minTime<visited[now]) return;

			for(int i=0;i<3;i++)
			{	int next;
				if(i==0)
					next=now+1;
				else if(i==1)
					next=now-1;
				else
					next=now*2;

				if(next<0 || next>100000) continue;

				if(next==K)
				{
					minTime = visited[now];
					count++;
				}


				if(visited[next]==0 || visited[next]==visited[now]+1) {
					q.add(next);
					visited[next] = visited[now] + 1;
				}

			}

		}

	}




}
