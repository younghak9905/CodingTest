package graph;

import com.sun.source.tree.NewArrayTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class back_10282 {
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(T-->0)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list = new ArrayList[n+1];
            int []dist = new int[n+1];
            boolean []visited = new boolean[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            for(int i=1;i<=n;i++)
            {
                list[i] =  new ArrayList<>();
            }
            for(int i=0;i<d;i++)
            {
              st = new StringTokenizer(br.readLine());
              int a  =Integer.parseInt(st.nextToken());
              int b = Integer.parseInt(st.nextToken());
              int s = Integer.parseInt(st.nextToken());
              list[b].add(new Node(a,s));

            }
            dist[c]=0;
            int start =c;
            int result =0;
            int max =0;
            PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
                return o1.v-o2.v;
            });
            pq.add(new Node(start,0));
            while(!pq.isEmpty())
            {
                Node nowNode = pq.poll();
                int now  = nowNode.idx;
                if(!visited[now]){
                    visited[now] = true;
                for(Node com: list[now])
                {
                        if (dist[com.idx] > dist[now] + com.v) {
                            dist[com.idx] = dist[now] + com.v;

                            pq.add(new Node(com.idx, dist[com.idx]));
                        }
                }
                }
            }
            for(int i=0;i<=n;i++)
            {
                if(dist[i]!=Integer.MAX_VALUE) {
                    result++;
                    max = Math.max(dist[i], max);
                }

            }
            sb.append(result).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());

    }
    static class Node{
        int idx;
        int v;
        public Node(int idx,int v)
        {
            this.idx = idx;
            this.v = v;
        }
    }
}
