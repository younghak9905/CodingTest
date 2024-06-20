package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());
        long[] S= new long [N];
        long[] C=new long [M];
        long answer=0;
        st=new StringTokenizer(br.readLine());
        S[0]=Long.parseLong(st.nextToken());
        for(int i =1;i<N;i++)
        {
          S[i]= S[i-1]+Long.parseLong(st.nextToken());
        }
        for(int i=0;i<N;i++)
        {
            int j=(int)(S[i]%M);
            if(j==0) answer++; //M으로 나누어 떨어지는 구분합 구하기
            C[j]++; //나머지 값이 같은 구분합 개수 구하기
        }

        for(int i=0;i<M;i++)
        {
            if(C[i]>1)

            {answer=answer+(C[i]*(C[i]-1))/2; }// 구간합
        }
        System.out.print(answer);
    }
}
