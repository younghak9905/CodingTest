package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_9663 {
	static Stack<Integer> chess = new Stack<Integer>();
	static int N;
	static boolean[] cols;
	static boolean[] d1;
	static boolean[] d2;
	static int count = 0;
	static boolean [][]check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		cols= new boolean[N];
		d1 = new boolean[2*N];
		d2 = new boolean[2*N];
		count = 0;
		recur(0);
		System.out.println(count);
	}

	static void recur(int cnt)
	{
		if(cnt==N)
		{

			count++;
			return;
		}

		for(int i=0;i<N;i++)
		{
			if(!cols[i] && !d1[cnt+i] && !d2[cnt-i+N])
			{
				cols[i] = true;
				d1[cnt+i] = true;
				d2[cnt-i+N] = true;
				recur(cnt+1);
				cols[i] = false;
				d1[cnt+i] = false;
				d2[cnt-i+N] = false;
			}
		}
	}
}
