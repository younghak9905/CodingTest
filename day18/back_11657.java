package day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;



public class back_11657 { //벨만포드 알고리즘 엣지 리스트
	static Edge edges[];
	static long distance[];

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M =  Integer.parseInt(st.nextToken());
		edges=new Edge[M+1];
		distance=new long[N+1];
		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges[i]=new Edge(A,B,C);
		}
		distance[1]=0;
		for(int i=2;i<=N;i++)
		{
			distance[i]=Integer.MAX_VALUE;
		}

		for(int i=1;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{	Edge edge=edges[j];
				if(distance[edge.start]!=Integer.MAX_VALUE&&(distance[edge.end]>distance[edge.start]+edge.time))
				{
					distance[edge.end]=distance[edge.start]+edge.time;
				}
			}
		}
		boolean mCycle = false;
		for(int i=0;i<M;i++)
		{
			Edge edge=edges[i];
			if(distance[edge.start]!=Integer.MAX_VALUE&&(distance[edge.end]>distance[edge.start]+ edge.time))
			{
				mCycle=true;
			}
		}
		if(!mCycle){
			for(int i=2;i<=N;i++)
			{
				if(distance[i]==Integer.MAX_VALUE)
				{
					sb.append("-1\n");
				}
				else {
					sb.append(distance[i]+"\n");
				}
			}
		}
		else{
			System.out.println("-1");
		}
		System.out.println(sb);
	}
	static class Edge{
		int start ,end, time;
		public Edge(int start,int end,int time)
		{
			this.start=start;
			this.end= end;
			this.time=time;
		}
	}

}
