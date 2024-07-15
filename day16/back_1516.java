package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1516 {

	static ArrayList<Integer>[] A;
	static int t[];
	static int D[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;


		A = new ArrayList[N+1];
		D = new int[N+1];
		t= new int[N+1];
		for(int i=1;i<=N;i++)
		{	int temp=1;
			st= new StringTokenizer(br.readLine());
			t[i]= Integer.parseInt(st.nextToken());
			A[i] =new ArrayList<>();
			while(true)
			{
				temp=Integer.parseInt(st.nextToken());
				if(temp==-1) break;
				A[temp].add(i);
				D[i]++;

			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1;i<=N;i++)
		{
			if(D[i]==0)
			{
				queue.offer(i);
			}
		}
		int []result = new int[N+1];
		while(!queue.isEmpty())
		{
			int now = queue.poll();
			for(int i : A[now])
			{
				D[i]--;
				result[i]=Math.max(result[i],result[now]+t[now]);
				if(D[i]==0)
				{
					queue.offer(i);
				}
			}
		}
		for(int i=1;i<=N;i++)
		{
			sb.append(result[i]+t[i]+"\n");
		}
		System.out.print(sb);
	}



}
