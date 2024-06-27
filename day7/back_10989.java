package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int []A= new int[N];
        for(int i=0;i<N;i++)
        {
            A[i]=Integer.parseInt(br.readLine());
        }
        br.close();

       Sort(A);
        for(int i=0;i<N;i++)
        {
            sb.append(A[i]+"\n");
        }
        System.out.print(sb);

    }
    public static void Sort(int []A) {
        int[] count = new int[10];
        int[] output = new int[A.length];

        int k = 1;
        while (k <= 10000) {
            for(int i=0;i<10;i++)
            {
                count[i]=0;
            }
            for (int i = 0; i < A.length; i++) {
                int digit=(A[i]/k)%10;
                count[digit]++;
            }
            //count 배열 누적합
            for(int i=1;i<10;i++)
            {
                count[i]+=count[i-1];
            }
            for(int i=A.length-1;i>=0;i--)
            {
                int digit=(A[i]/k)%10;
                output[count[digit]-1]=A[i];
                count[digit]--;
            }
            int j = 0;
            for (int i=0;i<A.length;i++) {
               A[i]=output[i];
            }
            k *= 10;
        }
    }

}
