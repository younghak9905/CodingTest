package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []A = new int[N];
        int []S= new int[N+1];
        for(int i=0;i<N;i++)
        {
            A[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N;i++)
        {
            int insert_index=i;
            int value=A[i];   //2
            for(int j=i-1;j>=0;j--) {
                if (value < A[j]) {
                   A[j+1] = A[j];
                    insert_index=j;
                }
            }
            A[insert_index]=value;
        }
       int sum=0;
        S[0]=A[0];

        for(int i =1;i<N;i++)
        {
            S[i]=S[i-1]+A[i];
        }
        for(int i =0;i<N ;i++)
        {
            sum+=S[i];
        }
        System.out.print(sum);
    }
}
