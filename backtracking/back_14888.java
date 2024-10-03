package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_14888 {
	static int N;
	static int []arr;
	static int []cal;
	static Stack<Integer> result = new Stack<Integer>();
	static long max,min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		cal = new int[4];
		for(int i=0;i<N;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++)
		{
			cal[i] = Integer.parseInt(st.nextToken());
		}
		max = -1000000000;
		min = 1000000000;
		recur(0);
		System.out.println(max);
		System.out.println(min);
	}
	static long calculate(int a,int index,long result)
	{
		if(a==0)
		{
			return result+arr[index+1];
		}
		else if(a==1)
		{
			return result-arr[index+1];
		}
		else if(a==2)
		{
			return result*arr[index+1];
		}
		else
		{
			return result/arr[index+1];
		}
	}
	static void recur(int cnt)
	{
		if(cnt==N-1)
		{
			long now = arr[0];
			for(int i=0;i<N-1;i++)
			{
				int c = result.get(i);
				now = calculate(c,i,now);
			}
			if(max<now)
			{
				max = now;
			}

			if(min>now)
			{
				min = now;
			}
			return;
		}

		for(int i=0;i<4;i++)
		{
			if(cal[i]>0)
			{
				cal[i]--;
				result.push(i);
				recur(cnt+1);
				cal[i]++;
				result.pop();
			}

		}
	}
}
