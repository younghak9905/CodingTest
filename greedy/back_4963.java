package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_4963 {
    static int[] dx ={-1,0,1,0,-1,-1,1,1};
    static int[] dy ={0,1,0,-1,1,-1,1,-1};
    static int[][] map;
    static boolean[][] visited;
    static int w,h;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            map = new int[h+1][w+1];

            for (int i = 1; i <=h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }

            }
            visited = new boolean[h+1][w+1];
            int result=0;
            for(int i=1;i<=h;i++) {
                for(int j=1;j<=w;j++) {
                    if(map[i][j]==1 && !visited[i][j]) {
                        recur(j,i);
                        result++;
                    }
                }
            }
            sb.append(result+"\n");
        }
        System.out.print(sb);
    }

    static void recur(int x,int y)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        if(visited[y][x]) return;
        visited[y][x] = true;
        while (!q.isEmpty()) {

            int[] cur = q.poll();
            for(int i=0;i<8;i++)
            {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<1 || ny<1 || nx>w || ny>h) continue;
                if(!visited[ny][nx] && map[ny][nx] == 1)
                {
                    visited[ny][nx] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }

    }
}
