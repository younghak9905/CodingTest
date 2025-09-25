import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_15591 {
    static ArrayList<Node>[] list;
    static int N;
    public static void main(String[] args ) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++)
        {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++)
        {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list[p].add(new Node(q,r));
            list[q].add(new Node(p,r));
        }

        for(int i=0;i<Q;i++)
        {
            st= new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bfs(k,v,0);
        }
    }
    static void bfs(int k,int v,int cnt)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(v,Integer.MAX_VALUE));
        boolean []visited = new boolean[N+1];
        visited[v] = true;
        int count =0;
        while (!q.isEmpty())
        {
            Node now = q.poll();
            for(Node next : list[now.target])
            {
                if(!visited[next.target] && Math.min(next.usado,now.usado)>=k)
                {
                    q.add(new Node(next.target,Math.min(next.usado,now.usado)));
                    count++;
                    visited[next.target]=true;
                }
            }
        }
        System.out.println(count);
    }

    static class Node{
        int target;
        int usado;
        Node(int target,int usado)
        {
            this.target = target;
            this.usado = usado;
        }

    }
}
