package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_17070 {
    static int N;
    static int ans;
    static int [][]map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i=1;i<=N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++)
            {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
       ans =0;
        DFS(1,2,0);
        System.out.println(ans);

    }

    static void DFS(int x, int y, int direction)
    {
        if(x==N && y==N)
        {
            ans++;
            return;
        }

        switch (direction) {
            case 0: // 파이프가 가로 방향일 경우, 갈 수 있는 경우는 동쪽과 대각선임.
                if (y + 1 <= N && map[x][y + 1] == 0) { // 동쪽
                    DFS(x, y + 1, 0);
                }
                break;
            case 1: // 파이프가 세로 방향일 경우, 갈 수 있는 경우는 남쪽과 대각선임.
                if (x + 1 <= N && map[x + 1][y] == 0) { // 남쪽
                    DFS(x + 1, y, 1);
                }
                break;
            case 2: // 파이프가 대각선일 경우, 갈 수 있는 경우는 동쪽과 남쪽, 대각선임.
                if (y + 1 <= N && map[x][y + 1] == 0) { // 동쪽
                    DFS(x, y + 1, 0);
                }

                if (x + 1 <= N && map[x + 1][y] == 0) { // 남쪽
                    DFS(x + 1, y, 1);
                }
                break;
        }

        if(y+1<=N && x+1<=N && map[x][y+1]==0 && map[x+1][y]==0 && map[x+1][y+1]==0)
            DFS(x+1,y+1,2);
    }

}
