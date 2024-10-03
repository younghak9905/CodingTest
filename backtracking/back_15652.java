package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_15652 {//중복 순열 비내림차순
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> result = new Stack<Integer>();
	static int []arr;
	static boolean []visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}

		visit = new boolean[N+1];
		recur(0);
		System.out.println(sb);

	}
	static void recur(int cnt)
	{
		if(cnt==M)
		{
			for(int x:result)
			{
				sb.append(x+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++)
		{

			if(visit[i]==false)
			{
			    visit[i] = true;
				result.push(arr[i]);
				recur(cnt+1);
			    visit[i] = false;
				result.pop();
			}


		}
	}
}

