package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class back_2667 {
    static boolean [][]visit;
    static int result =0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][]map;
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
       map = new int[N+1][N+1];

        for(int i=1;i<=N;i++)
        {   String str = br.readLine();
            for(int j=1;j<=N;j++)
            {
                map[i][j]= (int)(str.charAt(j-1)-'0');
            }
        }
        visit= new boolean[N+1][N+1];
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=N;j++)
            {
               if(map[i][j]!=0 && !visit[i][j])
               {
                   bfs(i,j);
               }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty())
        {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);

    }
    static void bfs(int x,int y)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        int count=1;
        visit[x][y]=true;
        while (!q.isEmpty())
        {
            int []now = q.poll();
            for(int i=0;i<4;i++)
            {
                int nx=  now[0]+dx[i];
                int ny= now[1]+dy[i];
                if(nx>0 && nx<=N && ny>0 && ny<=N)
                {
                    if(map[nx][ny]==1 && !visit[nx][ny])
                    {
                        visit[nx][ny]=true;
                        count++;
                        q.add(new int[]{nx,ny});

                    }
                }
            }
        }
        pq.add(count);

    }

    }
