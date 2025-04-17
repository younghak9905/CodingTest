package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_7569 {
    static int[] dx = {-1, 0, 1, 0,0,0};
    static int[] dy = {0, -1, 0, 1,0,0};
    static int[] dz = {0, 0, 0, 0,1,-1};
    static int N,M,H;
    static int [][][]map;
    static boolean[][][] visited;
    static int res =0;
    static int days=0;
    static int remain=0;
    static Queue<int[]> q= new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M  = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        map = new int[M+1][N+1][H+1];
        visited = new boolean[M+1][N+1][H+1];
        for(int i=1;i<=H;i++)
        {
            for(int j=1;j<=N;j++)
            {   st = new StringTokenizer(br.readLine());
                for(int k=1;k<=M;k++)
                {
                    map[k][j][i] = Integer.parseInt(st.nextToken());
                    if(map[k][j][i]==1)
                    {
                        visited[k][j][i] = true;
                        q.add(new int[]{k,j,i});
                        remain++;
                    }
                    if(map[k][j][i]!=-1)
                    {
                        res++;
                    }
                }
            }
        }
        remain=res-remain;
        if(remain==0)
        {
            System.out.println(remain);
            return;
        }
        recur();


    }
    static void recur()
    {   Queue<int[]> today= new LinkedList<>();
        today = q;
        Queue<int[]> tomorrow= new LinkedList<>();

        while (!tomorrow.isEmpty() || !today.isEmpty())
        {

            int []now = today.poll();
            for(int i=0;i<6;i++)
            {
                int x=now[0]+dx[i];
                int y=now[1]+dy[i];
                int z =now[2]+dz[i];

                if(x>0 && x<=M && y>0 && y<=N && z>0 && z<=H)
                {
                    if(!visited[x][y][z] && map[x][y][z]==0)
                    {
                        visited[x][y][z] = true;
                        tomorrow.add(new int[]{x,y,z});
                        map[x][y][z] = 1;
                        remain--;
                    }
                }
            }
            if(today.isEmpty())
            {
                days++;
                if(remain<=0) break;
                today = tomorrow;
                tomorrow = new LinkedList<>();
            }

        }
        if(remain>0)
        {
            System.out.println(-1);
        }
        else {
            System.out.println(days);
        }
    }
}
