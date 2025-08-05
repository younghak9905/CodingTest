package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1743 {
    static int N,M,K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int Max =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=0;i<K;i++)
        {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=M;j++)
            {
                System.out.print(map[i][j]+" ");
                if(!visited[i][j] && map[i][j]==1)
                {
                    recur(i,j);
                }
            }
            System.out.println();

        }
        System.out.println(Max);

    }
    static void recur(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        int count=1;
        visited[r][c] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0;i<4;i++)
            {
                int nx = cur[1]+dx[i];
                int ny = cur[0]+dy[i];

                if(nx<=0 || ny<=0 || nx>M ||ny >N) continue;
                if(map[ny][nx]==0 || visited[ny][nx]) continue;

                if(map[ny][nx]==1)
                {
                    q.add(new int[]{nx,ny});
                    visited[ny][nx] = true;
                    count++;
                }
            }


        }
        Max = Math.max(Max,count);



    }
}
