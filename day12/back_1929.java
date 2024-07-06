package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long []A = new long[N+1];
        for(int i =2; i <=N; i++) {
            A[i] = i;
        }
        for(int i=2;i<=Math.sqrt(N);i++)
        {
            if(A[i]==0)
                continue;
            for(int j=i+i;j<=N;j+=i)
            {
                A[j]=0;
            }
        }
        for(int i=M;i<=N;i++)
        {
            if(A[i]!=0)
                sb.append(A[i]+"\n");
        }
        System.out.print(sb);
    }
}
