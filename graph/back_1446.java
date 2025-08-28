package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_1446 {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int []dist = new int[D+1];
        visited = new boolean[D+1];
        list = new ArrayList[D+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0;i<=D;i++)
        {
            list[i] = new ArrayList<>();
        }
        PriorityQueue<Integer> node = new PriorityQueue<>();
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(b>D) continue;
            int v = Integer.parseInt(st.nextToken());
            if(b-a<v)continue;
            list[a].add(new Node(b,v));
            node.add(a);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.value-o2.value;
        });
        pq.add(new Node(0,0));
        dist[0] = 0;
        while(!pq.isEmpty())
        {
            Node nowNode = pq.poll();
            int now = nowNode.tartget;
            int value = nowNode.value;
            if(value>dist[now]) continue;
            if(now +1 <=D &&value+1 <dist[now+1])
            {
                dist[now+1] = value+1;
                pq.add(new Node(now+1,value+1));
            }


                for(Node n : list[now])
                {
                    if(dist[n.tartget] > dist[now]+n.value)
                    {
                        dist[n.tartget] = dist[now]+n.value;
                        pq.add(new Node(n.tartget,dist[n.tartget]));
                    }
                }

        }
        System.out.println(dist[D]);



    }
    static class Node{
        int tartget;
        int value;
        public Node(int tartget,int value)
        {
            this.tartget=tartget;
            this.value=value;
        }
    }
}
