import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_4485 {
    static int []dx = {1,0,-1,0};
    static int []dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N;
        int count =1;
        while((N=Integer.parseInt(br.readLine()))!=0)
        {
            int [][]map = new int[N][N];
            boolean [][]visited = new boolean[N][N];
            int [][]dist = new int[N][N];
            for(int i=0;i<N;i++)
            {
                Arrays.fill(dist[i],Integer.MAX_VALUE);
            }
            for(int i=0;i<N;i++)
            {   st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++)
                {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dist[0][0] = map[0][0];
            PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
                return o1.k-o2.k;
            });
            pq.add(new Node(0,0,map[0][0]));

            while(!pq.isEmpty()) {

                Node now = pq.poll();
                int x = now.x;
                int y = now.y;




                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    int nk = map[ny][nx];
                    if (dist[ny][nx] > dist[y][x] + nk) {
                        dist[ny][nx] = dist[y][x] + nk;
                        pq.add(new Node(nx, ny, dist[ny][nx]));
                    }
                }
                }
            sb.append("Problem ").append(count++).append(": ").append(dist[N-1][N-1]).append("\n");

        }
        System.out.println(sb);

    }

    static class Node{
        int x;
        int y;
        int k;
        public Node(int x,int y,int k)
        {
            this.x=x;
            this.y=y;
            this.k=k;
        }
    }
}
