package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_1759 {
	static int L,C;
	static boolean []visit;
	static char[] chars;
	static Stack<Integer> result = new Stack<Integer>();
	//자음 모음
	static String st="bcdfghjklmnpqrstvwxyz";
	//모음 모음
	static String st2="aeiou";
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		 L = Integer.parseInt(st.nextToken());
		 C = Integer.parseInt(st.nextToken());
		 visit= new boolean[C];
		st = new StringTokenizer(br.readLine());
		chars = new char[C];
		for(int i=0;i<C;i++)
		{
			chars[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(chars);
		recur(0);
		System.out.println(sb);
	}

	static void recur(int cnt)
	{
		if(cnt==L)
		{	int j=0;
			int m=0;
			for(int x:result) {
				if (st.contains(chars[x] + "")) {
					j++;
				}else if(st2.contains(chars[x]+""))
				{
					m++;
				}
			}
			if(j>=2 && m>=1)
			{
				for(int x:result)
				{
					sb.append(chars[x]+"");
				}
				sb.append("\n");
			}
			return;
		}
		for(int i=0;i<C;i++)
		{
			if(!visit[i] && result.isEmpty() || result.peek()<i)
			{
				visit[i] = true;
				result.push(i);
				recur(cnt+1);
				result.pop();
				visit[i] = false;
			}
		}
	}
}
