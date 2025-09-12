import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_17396 {
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int []valid = new int[N];
        list = new ArrayList[N];
        for(int i=0;i<N;i++)
        {
            list[i] = new ArrayList<>();
            valid[i]=Integer.parseInt(st.nextToken());
        }
        long []dist = new long[N];
        boolean []visited = new boolean[N];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());

                list[a].add(new Node(b,t));
                list[b].add(new Node(a,t));

        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));

        while(!pq.isEmpty())
        {
            Node now = pq.poll();
            if(!visited[now.target])
            {
                visited[now.target]=true;
                for(Node next:list[now.target])
                {
                    if(next.target!=N-1 && valid[next.target]==1) continue;
                    if(dist[next.target]>dist[now.target]+next.t)
                    {
                        dist[next.target] = dist[now.target]+next.t;
                        pq.add(new Node(next.target,dist[next.target]));
                    }
            }
            }
        }


        if(dist[N-1]!=Long.MAX_VALUE)
            System.out.println(dist[N-1]);
        else
            System.out.println("-1");

    }
    static class Node implements Comparable<Node> {
        int target;
        long t;
        public Node(int target,long t)
        {
            this.target=target;
            this.t = t;
        }

        @Override
        public int compareTo(Node n) {
            if(this.t - n.t > 0) return 1;
            else return -1;
        }
    }
}
