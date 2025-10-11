package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2636 {
    static int board[][];
    static int count=0;
    static boolean[][]visited;
    static int N,M;
    static int[] dx = {0,1,0,-1};
    static int []dy = {-1,0,1,0};
    public static void main(String[]args ) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1)
                {
                    count++;
                }
            }
        }
        int result = 0;
        int time=0;
        while(count>0)
        {
            result = count;
            time++;
            visited = new boolean[N][M];
            bfs();
        }

        System.out.println(time);
        System.out.println(result);
    }
    static void bfs()
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0]=true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ni = now[0] + dy[i];
                int nj = now[1] + dx[i];
                if (ni <0 || nj <0 || ni >=N || nj >=M || visited[ni][nj]) continue;
                visited[ni][nj] = true;
                if (board[ni][nj] == 0) {
                    q.add(new int[]{ni, nj});
                } else {
                    count--;
                    board[ni][nj] = 0;
                }
            }
        }

    }
}
