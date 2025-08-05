package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_11501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            long []days = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                days[j] = Integer.parseInt(st.nextToken());
            } // 1 1 3 1 2
            // 1 2 4 1
           long profit=0;
            long max = days[N-1];
            for(int j=N-2;j>=0;j--){
                if(days[j]<=max)
                {
                    profit+=max-days[j];
                }else max=days[j];
            }
            sb.append(profit+"\n");

        }
        System.out.print(sb);

    }
}
