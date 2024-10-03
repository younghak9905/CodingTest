package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_15649 { //순열
	static int N,M;
	static int []arr;
	static StringBuilder sb = new StringBuilder();

	static boolean []visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N+1];
		recur(0);
		System.out.println(sb);

	}
	static void recur(int cnt)
	{
		if(cnt==M)
		{
			for(int i=0;i<M;i++)
			{
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}

		for(int i=1;i<=N;i++)
		{
			if(!visit[i])
			{
				visit[i] = true;
				arr[cnt] = i;
				recur(cnt+1);
				visit[i] = false;
				arr[cnt] = 0;
			}


		}
	}
}
