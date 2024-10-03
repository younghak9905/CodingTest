package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_14889 {
	static int N;
	static int [][]arr;
	static Stack<Integer> result = new Stack<Integer>();
	static Stack<Integer> result2 = new Stack<Integer>();
	static long min;
	static StringBuilder sb = new StringBuilder();

	static boolean []visit;
	static boolean []visit2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		arr	= new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++)
		{	st	= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min=1000000000;
		recur(0);
		System.out.println(min);
	}
	static int score()
	{
		int team1 = 0;
		int team2 = 0;
		for(int x : result) //1 2
		{
				for(int y : result)
				{
					if(x!=y)
					{
						team1+=arr[x-1][y-1];
					}
				}
		}
		for(int x : result2)
		{
			for(int y : result2)
			{
				if(x!=y)
				{
					team2+=arr[x-1][y-1];
				}
			}
		}
		result2.clear();
		return Math.abs(team1-team2);
	}
	static void recur(int cnt)
	{
		if(cnt==N/2)
		{
			visit2 = new boolean[N+1];
			for(int x : result)
			{
				visit2[x] = true;
			}
			for(int i=1;i<=N;i++)
			{
				if(!visit2[i])
				{
					result2.push(i);
				}
			}
			int score =score();
			if(min>score)
			{
				min = score;
			}
			return;
		}

		for(int i=1;i<=N;i++)
		{
			if(!visit[i] && (result.isEmpty() || result.peek()<i))
			{
				visit[i] = true;
				result.push(i);
				recur(cnt+1);
				visit[i] = false;
				result.pop();
			}


		}
	}
}
