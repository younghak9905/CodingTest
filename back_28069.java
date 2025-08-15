import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_28069 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N < K) {
            System.out.println("minigimbob");
            return;
        }
        int[] dp = new int[N + 1];
        boolean[] visited = new boolean[N+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 0; i < 2; i++) {
                int now = curr;
                if (i == 0)
                    now += 1;
                else
                    now += (int) Math.floor(curr / 2);

                if (now <= N && !visited[now]) {
                    q.add(now);
                    dp[now] = dp[curr] + 1;
                    visited[now]=true;
                }

            }

        }
        if(dp[N]==K)
            sb.append("minigimbob");
        else{
            sb.append("water");
        }
        System.out.println(sb);
    }


}
