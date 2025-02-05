package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2573 {
    static int N;
    static int M;
    static int [][]arr;
    static int []dx = {1,0,-1,0};
    static int []dy = {0,1,0,-1};
    static Queue<int []> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr= new int[N+1][M+1];
        for(int i=1;i<=N;i++)
        {   st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++)
            {   int a = Integer.parseInt(st.nextToken());
                arr[i][j]=a;
                if(a!=0)
                {
                    q.add(new int[]{i,j});
                }
            }
            int count=1;

        }

    }

    static void bfs(boolean [][]visit)
    {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{1,1});
        visit[1][1]=true;
        int count=1;
        while(!que.isEmpty())
        {   int []a = q.poll();
            for(int i=0;i<4;i++)
            {
                int x = a[0]+dx[i];
                int y = a[1]+dy[i];

            }
        }
    }

    static void dfs()
    {

    }
}
