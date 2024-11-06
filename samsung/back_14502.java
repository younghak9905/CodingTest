package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_14502 {
    static int []dx = {1,0,-1,0};
    static int []dy = {0,1,0,-1};
    static int [][]map;
    static int N,M,max,count;

    static HashSet<int[]> virus;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        count=0;
        virus = new HashSet<>();
        for(int i=1;i<=N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++)
            {
                int input = Integer.parseInt(st.nextToken());
                map[i][j]=input;
                if(input==2)
                    virus.add(new int[]{j,i});
            }
        }
        max=0;
        recur(0);
        System.out.println(max);
    }

    private static void funcSafeZone(int[][] copyMap) {
        int safeZone =0;
        for(int i=1; i<=N ; i++) {
            for(int j=1; j<=M; j++) {
                if(copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        if (max < safeZone) {
            max = safeZone;
        }
    }
    static void bfs()
    {
        Queue<int[]> q = new LinkedList<>();
        for(int [] virus: virus)
        {
            q.add(virus);
        }

        int [][]temp = new int[N+1][M+1];
        for(int i=0;i<=N;i++)
        {
            temp[i]=map[i].clone();
        }
        while(!q.isEmpty() )
        {
            int [] v = q.poll();
            for(int i=0;i<4;i++)
            {
                int nx = v[0]+dx[i];
                int ny = v[1]+dy[i];
                if(nx<1||ny<1||nx>M||ny>N) continue;
                if(temp[ny][nx]!=0) continue;
                q.add(new int[] {nx,ny});
                temp[ny][nx]=2;
            }
        }
        funcSafeZone(temp);
    }
    static void recur(int cnt )
    {
        if(cnt==3)
        {
            bfs();
            return;
        }

        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=M;j++)
            {
                if(map[i][j]!=0) continue;
                map[i][j]=1;
                recur(cnt+1);
                map[i][j]=0;
            }
        }
    }
}
