package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class back_14503 {
    static int []dx = {-1,0,1,0};
    static int []dy = {0,1,0,-1};
    static int N,M;
    static int [][]map;
    static int count=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        int [][]visit = new int[N][M];
        for(int i=0;i<N;i++)
        {   st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

       dfs(x,y,dir);
       System.out.println(count);
    }
    static void dfs(int x,int y,int dir)
    {
       map[x][y]=-1;
    

       for(int i=0;i<4;i++)
       {
            dir = (dir+3)%4;
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
            if(map[nx][ny]==0)
            {
                count++;
                dfs(nx,ny,dir);
                return;
            }
       }
            int back = (dir+2)%4;
            int bx = x+dx[back];
            int by = y+dy[back];
            if(bx<0 || bx>=N || by<0 || by>=M) return;
            if(map[bx][by]==1) return;
            dfs(bx,by,dir);



    }
    
}
