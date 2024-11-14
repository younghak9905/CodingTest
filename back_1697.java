import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1697 {
	static int visited[];
	static int N,K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N == K) {
			System.out.println(0);
			return;
		}
		visited = new int[100001];
		bfs();
	}
	static void bfs()
	{

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 1;
		while(!q.isEmpty())
		{
			int now = q.poll();
			for(int i=0;i<3;i++)
			{	int next;
				if(i==0)
					next=now+1;
				else if(i==1)
					next=now-1;
				else
					next=now*2;



				if(next==K)
				{
					System.out.println(visited[now]);
					return;
				}

				if(next<0 || next>100000)
					continue;
				if(visited[next]!=0) continue;
				q.add(next);
				visited[next] =visited[now]+1;

			}
		}

	}

}
