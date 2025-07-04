package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_1043 {
	static int []A;
	static ArrayList<int []> list  = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		A= new int[N+1];
		for(int i=0;i<=N;i++)
		{
			A[i] = i;
		}
		int result =0;
		if(num == 0) {
			System.out.println(M);
			return;
		}
		for(int i=1;i<=num;i++)
		{
			int a = Integer.parseInt(st.nextToken());
			union(a, 0);
		}
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());
			int []p = new int[k];
			for(int j=0;j<k;j++)
			{
				int a = Integer.parseInt(st.nextToken());
				p[j] = a;
			}
			list.add(p);
			for(int j=1;j<k;j++)
			{
				union(p[j], p[0]);
			}

		}
		for(int[] party : list)
		{	boolean lie = false;
			for(int i=0;i<party.length;i++)
			{
				if(find(party[i])==find(0))
				{
					lie=true;
					break;
				}
			}
			if(!lie) result++;
		}
		System.out.println(result);
	}

	public static void union(int a,int b)
	{	a=find(a);
		b=find(b);
		if(a!=b)
		{
			A[b]=a;
		}

	}
	public static int find(int a)
	{
		if(A[a]==a)
			return a;
		else{
			return A[a]=find(A[a]);
		}
	}

	// You can add methods to solve the problem here.
}
