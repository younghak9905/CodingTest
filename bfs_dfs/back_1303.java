package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1303 {
    static int N,M;
    static char[][]map;
    static boolean[][] visited;
    static int[]dx = {1,0,-1,0};
    static int[]dy = {0,-1,0,1};
    static int W=0;
    static int B=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
            map = new char[M + 1][N + 1];
            visited = new boolean[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = s.charAt(j-1);
            }
        }
        for(int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if(!visited[i][j]) {
                    recur(j, i);
                }
            }
        }
        System.out.println(W + "\n" + B);




    }
    static void recur(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int count = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0;i<4;i++)
            {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx>0 && ny>0 && ny<=M && nx<=N && !visited[ny][nx])
                {
                    if(map[ny][nx]==map[y][x])
                    {   System.out.println(map[ny][nx] +" "+map[y][x]);
                        q.offer(new int[]{nx, ny});
                        visited[ny][nx] = true;
                        count++;

                    }
                }
            }
        }
        if(map[y][x]=='W')
            W+=count*count;
        else
            B+=count*count;
        return;

    }
}
