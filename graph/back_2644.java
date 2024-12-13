package graph;
import java.io.*;
import java.util.*;
public class back_2644 {

		static boolean[] visit;
		static int a,b;
		static ArrayList<Integer>[] list;
		static int result=-1;
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list = new ArrayList[N+1];
			for(int i=0;i<=N;i++)
			{
				list[i]= new ArrayList<>();
			}
			int m = Integer.parseInt(br.readLine());
			for(int i=0;i<m;i++)
			{	st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list[x].add(y);
				list[y].add(x);
			}
			visit= new boolean[N+1];

			dfs(a,0);
			System.out.println(result);



		}
		static void dfs(int v,int depth)
		{
			if(visit[v])
				return;
			if(v==b)
			{
				result=depth;
				visit[v]=true;
				return;
			}

			visit[v]=true;
			for(int i: list[v])
			{
				if(!visit[i])
					dfs(i,depth+1);
			}
		}
	/*  static void bfs(int start)
	  {
		  Queue<Integer> q = new LinkedList();
		  q.add(e)
	  }*/

	}


