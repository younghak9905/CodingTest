package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2178 {
    static int N,M;
    static int[][]map;
    static boolean[][]visit;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map= new int[N+1][M+1];
        visit= new boolean[N+1][M+1];
        for(int i=1;i<=N;i++)
        {   String str = br.readLine();
            for(int j=1;j<=M;j++)
            {
                map[i][j]=str.charAt(j-1)-'0';
            }
        }

        recur();
        System.out.println(map[N][M]);

    }
    static void recur()
    {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        visit[1][1]=true;

        while(!queue.isEmpty())
        {
            int []now = queue.poll();

            for(int i=0;i<4;i++)
            {
                int x = now[0]+dx[i];
                int y= now[1]+dy[i];

                if(x<1 || y<1 || x>N||y>M) continue;
                if(!visit[x][y] && map[x][y]!=0)
                {   visit[x][y]=true;
                    map[x][y]+=map[now[0]][now[1]];
                    queue.add(new int[]{x,y});
                }
            }
        }


    }

    }
