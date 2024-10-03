package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_15651 {
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> result = new Stack<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

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
		for(int i=1;i<=N;i++)
		{
				result.push(i);
				recur(cnt+1);
				result.pop();
		}
	}
}
