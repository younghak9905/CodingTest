package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long M = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        int sqrt = (int)Math.sqrt(N);
        long[] A = new long[sqrt+1];
        for (int i = 2; i <= sqrt; i++) {
            A[i] = i;
        }

        for(int i=2;i<=sqrt;i++)
        {
            if(A[i]==0)
                continue;
            for(int j=i+i;j<=sqrt;j+=i)
            {
                A[j]=0;
            }
        }
        long count=0;
        for(int i=2;i<=sqrt;i++)
        {
            if(A[i]!=0 )
            {   long temp = A[i];

                while((double)A[i]<=(double)N/(double)temp) {
                    if ((double) A[i] >= (double) M / (double) temp)
                        count++;
                    temp *= A[i];
                }

            }


        }

        System.out.println(count);
    }
}
