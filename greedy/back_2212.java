package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_2212 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int []d = new int[N-1];
        Arrays.sort(A);
        for(int i=0;i<N-1;i++)
        {
            d[i]=A[i+1]-A[i];
        }
        Arrays.sort(d);
        int result=0;
        for(int i=0;i<N-K;i++)
        {
            result+=d[i];
        }
        System.out.println(result);

    }
}
