package day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_6497 {
    static int parent[];
    static PriorityQueue<Edge> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        queue=new PriorityQueue<>();
        parent =new int[N+1];
        for(int i=0;i<N;i++)
        {
            parent[i]=i;
        }
        long sum=0;
        while (true) {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) break; // 입력이 끝났을 때 루프 탈출

            st = new StringTokenizer(line);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (s == 0 && e == 0) break; // 종료 조건
            int w = Integer.parseInt(st.nextToken());
            queue.add(new Edge(s, e, w));
            sum += w;
        }

        int unionCount=0;
        long result = 0;
        while(unionCount<N-1)
        {
           Edge now = queue.poll();
            int a = find(now.start);
            int b =find(now.end);
            if(a!=b)
            {
                union(now.start,now.end);
                result +=now.w;
                unionCount++;

            }
        }
        System.out.println(sum-result);


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



