package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_2011 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = s.length();
        long[] dp = new long[N + 1];
        if(s.charAt(0)=='0')
        {
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {

            if (s.charAt(i - 1) == '0') {  //0이 들어갈 경우 21 20  두 개를 넣는 것 밖에 되지 않는다. 212 0 X
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') { //0앞에 붙는 수가 1,2 일 때 만
                    dp[i] = dp[i - 2] % 1000000;
                } else
                    break;  //30 , 40 은 안되기 때문
            } else {
                int result = Integer.parseInt(s.substring(i - 2, i));
                if (result < 27 && result > 9) {  //2151  -> 51 x    2101  -> 01 x
                    dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;  //2151   21 51 , 215 1
                } else {
                    dp[i] = dp[i - 1] % 1000000; //이럴 땐 2101 -> 210 1 밖에 안됨
                }
            }
        }
        System.out.println(dp[N] % 1000000);
    }
}
