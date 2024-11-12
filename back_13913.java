import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_13913 {
	static int visited[];
	static int parent[];
	static int N,K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N == K) {
			System.out.println(0);
			System.out.println(N);
			return;
		}
		visited = new int[100001];
		parent = new int[100001];
		bfs();
		System.out.println(visited[K]-1);
		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		int now = K;
		while(now!=N)
		{
			stack.push(parent[now]);
			now = parent[now];
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
		{
			sb.append(stack.pop()+" ");
		}
		System.out.println(sb);
	}
	static void bfs()
	{

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 1;
		while(!q.isEmpty())
		{
			int now = q.poll();
			if(now==K) return;

			for(int i=0;i<3;i++)
			{	int next;
				if(i==0)
					next=now+1;
				else if(i==1)
					next=now-1;
				else
					next=now*2;




				if(next<0 || next>100000)
					continue;
				if(visited[next]!=0) continue;
				q.add(next);
				visited[next] =visited[now]+1;
				parent[next] = now;

			}
		}

	}
}
