package bp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class back_13908 {

	static int N,M;
	static boolean visited[];

	static int count=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		visited= new boolean[10];
		for(int i=0;i<M;i++)
		{
			visited[Integer.parseInt(st.nextToken())]=true;
		}

		recur(0,0);
		System.out.println(count);
	}

	static void recur(int cnt,int idx)
	{
		if(idx == N)
		{
			if(cnt==M) count++;
			return;
		}

		for(int i=0;i<=9;i++)
		{
			if(visited[i])
			{
				visited[i]=false;
				recur(cnt+1,idx+1);
				visited[i]=true;
			}else {
				recur(cnt,idx+1);
			}
		}
	}
}
