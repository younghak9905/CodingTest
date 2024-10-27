package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2606 {
	static int []A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		A = new int[N+1];

		for(int i=1;i<=N;i++)
		{
			A[i]=i;
		}
		StringTokenizer st;
		//간선을 연결
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		int count = 0;
		for(int i=2;i<=N;i++)
		{
			if(find(i)==find(1))
				count++;
		}
		System.out.println(count);
	}
	public static void union(int a,int b)
	{
		a=find(a);
		b=find(b);
		if(a!=b)
			A[b]=a;
	}
	public static int find(int a)
	{
		if(A[a]==a)
			return a;
		else{
			return A[a]=find(A[a]);
		}
	}
}
