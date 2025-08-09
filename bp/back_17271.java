package bp;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class back_17271 {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int []dp = new int[N + 1];
        int []skill = {1,M};
        dp[0] = 1; // 0번째는 1가지 경우
        for(int i=1;i<=N;i++){
            for(int j=0;j<skill.length;j++){
                if(i - skill[j] >= 0) {
                    dp[i]+=(dp[i - skill[j]]) % MOD;
                }
            }
        }
        System.out.println(dp[N]%MOD);

    }
}
