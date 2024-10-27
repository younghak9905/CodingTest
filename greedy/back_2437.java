package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_2437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       int []A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long currentSum=0;
        for(int i=0;i<N;i++)
        {
            A[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        for (int coin : A) {
            if (coin > currentSum + 1) {
                // currentSum + 1을 만들 수 없으므로 반환
                System.out.print(currentSum + 1);
                return;
            }
            currentSum += coin;
        }
       System.out.println(currentSum+1);
    }
}
