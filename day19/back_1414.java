package day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_1414 {
	static int parent[];
	static PriorityQueue<Edge> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int sum=0;
		queue = new PriorityQueue<>();
		parent = new int[N];
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(br.readLine());
			char[] tempC = st.nextToken().toCharArray();
			for(int j=0;j<N;j++)
			{
				int temp=0;
				if(tempC[j]>='a' && tempC[j]<='z')
				{
					temp= tempC[j]-'a'+1;
				}else if(tempC[j]>='A' && tempC[j]<='Z')
				{
					temp= tempC[j]-'A'+27;
				}
				sum+=temp;
				if(i!=j && temp!=0) queue.add(new Edge(i,j,temp));
			}
		}
		for(int i=0;i<N;i++)
		{
			parent[i]=i;
		}

		int unionCount=0;
		long result = 0; //최소 신장 트리의 길이
		while(!queue.isEmpty())
		{
			Edge now = queue.poll();
			int a =find(now.start);
			int b =find(now.end);
			if(a!=b)
			{
				union(now.start,now.end);
				result +=now.w;
				unionCount++;

			}
		}
		//전체 랜선에서 최소 신장트리를 만족하는 최소한의 랜선을 구하고 나머지는 모두 기부
		if(unionCount==N-1)
		{
			System.out.println(sum-result);

		}
		else {
			System.out.println(-1);
		}



	}
	public static void union(int a,int b)
	{	a=find(a);
		b=find(b);
		if(a!=b)
		{
			parent[b]=a;
		}

	}

	public static int find(int a)
	{
		if(parent[a]==a)
			return a;
		else{
			return parent[a]=find(parent[a]);
		}
	}
	static class Edge implements Comparable<Edge>{
		int start ,end;
		int w;
		public Edge(int start,int end,int w)
		{
			this.start=start;
			this.end= end;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o)
		{
			return this.w - o.w;
		}
	}

}
