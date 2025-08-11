package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_16401 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long []snacks = new long[N+1];
        long sum =0;
        long result=0;
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++)
        {
            snacks[i] = Long.parseLong(st.nextToken());
            sum+=snacks[i];
        }
        long start =1;
        long end = sum/M;
        while(start<=end) {
            int count = 0;
            long mid = start + (end - start) / 2;

            for (int i = 1; i <= N; i++) count += snacks[i] / mid;
            if (count >= M) {
                result = Math.max(result, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }

}
