package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1303_2 {
    static char[][] map;
    static boolean[][] visited;
    static int[]dx = {-1,1,0,0};
    static int[]dy = {0,0,1,-1};
    static ArrayList<int[]> soldiers;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M+1][N+1];
        visited = new boolean[M+1][N+1];
        for(int i=1;i<=M;i++)
        {   String s = br.readLine();
            for(int j=1;j<=N;j++)
            {
                map[i][j]=s.charAt(j-1);
            }
        }
        int w=0;
        int b=0;
        for(int i=1;i<=M;i++)
        {
            for(int j=1;j<=N;j++)
            {   soldiers=new ArrayList<>();
                if(!visited[i][j])
                {
                    soldiers.add(new int[] {i,j});
                    recur(j,i);
                    if(map[i][j]=='W')
                    {
                        w+=soldiers.size()*soldiers.size();
                    }else {
                        b+=soldiers.size()*soldiers.size();
                    }

                }
            }
        }
        System.out.println(w+" "+b);


    }
    static void recur(int x,int y)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[y][x] = true;
        char c  = map[y][x];
        while (!q.isEmpty())
        {
            int[] cur = q.poll();
            for(int k=0;k<4;k++)
            {
                int nx = cur[0]+dx[k];
                int ny = cur[1]+dy[k];
                if(nx<1 || ny <1 || nx>N || ny >M) continue;
                if(map[ny][nx]==c && !visited[ny][nx])
                {
                    visited[ny][nx] = true;
                    q.add(new int[]{nx,ny});
                    soldiers.add(new int[] {nx,ny});
                }

            }
        }
    }
}
