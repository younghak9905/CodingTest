import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class back_14620 {
    static int dx[] = {0,1,0,-1,0};
    static int dy[] = {0,0,-1,0,1};
    static int N;
    static Stack<int[]> result = new Stack<>();
    static boolean [][]visited;
    static int min = Integer.MAX_VALUE;
    static int [][]map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        for(int i=1;i<=N;i++)
        {   st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       recur(0);
        System.out.println(min);
    }
    static void recur(int cnt)
    {
        if(cnt==3)
        {   int cost = 0;
            for(int[] re : result)
            {
                int i = re[0];
                int j = re[1];
                for(int d=0;d<5;d++)
                {
                    cost+=map[i+dy[d]][j+dx[d]];
                }
            }
            min = Math.min(cost,min);
            return;

        }

        for(int i=2;i<=N-1;i++)
        {
            for(int j=2;j<=N-1;j++)
            {
                if(result.isEmpty() || isValid(i,j))
                {
                    for(int d=0;d<5;d++)
                       visited[i+dy[d]][j+dx[d]]=true;
                    result.push(new int[]{i,j});
                    recur(cnt+1);
                    result.pop();
                    for(int d=0;d<5;d++)
                        visited[i+dy[d]][j+dx[d]]=false;
                }
            }
        }
    }

    static boolean isValid(int i, int j)
    {
        for(int d=0;d<5;d++) {
            if (visited[i + dy[d]][j + dx[d]])
                return false;
        }
        return true;
    }


}
