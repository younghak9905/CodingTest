package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_4963 {
    static int dx[] = {1,1,1,-1,-1,-1,0,0};
    static int dy[] = {1,0,-1,1,0,-1,1,-1};
    static int map[][];
    static int w,h;
    static boolean visited[][];
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true)
        {   st = new StringTokenizer(br.readLine());
            w= Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;
            map = new int[h][w];
            visited = new boolean[h][w];
            for(int i=0;i<h;i++)
            {   st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++)
                {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt=0;
            for(int i=0;i<h;i++)
            {
                for(int j=0;j<w;j++)
                {
                    if(!visited[i][j] && map[i][j]==1)
                    {
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");

        }
        System.out.println(sb);

    }
    static void bfs(int y,int x)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        if(visited[y][x]) return;
        visited[y][x]=true;

        while (!q.isEmpty())
        {
            int []now =q.poll();
            for(int i=0;i<8;i++)
            {
                int nx = now[1]+dx[i];
                int ny = now[0]+dy[i];
                if(nx<0 || ny<0 || nx>=w || ny>=h) continue;
                if(!visited[ny][nx] && map[ny][nx]==1)
                {
                    q.add(new int[]{ny,nx});
                    visited[ny][nx]= true;
                }

            }
        }

    }
}
