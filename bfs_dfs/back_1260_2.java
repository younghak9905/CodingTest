package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1260_2 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++)
            list[i] = new ArrayList<>();
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        bfs(V);
        System.out.println();
    }

    static void bfs(int u) {
      Queue<Integer> q = new LinkedList<>();
      q.add(u);
      boolean visited[] = new boolean[N+1];
      visited[u] = true;
      while (!q.isEmpty()) {
          int v = q.poll();
          System.out.print(v+" ");
          for(Integer i : list[v])
          {
              if(!visited[i])
              {
                  q.add(i);
                  visited[i] = true;
              }
          }

      }


    }

    static void dfs(int v)
    {

        if(visited[v])
            return;
        visited[v] = true;
        System.out.print(v+" ");


            for(int i:list[v])
            {
                if(!visited[i])
                {
                    dfs(i);
                }

            }


    }
}
