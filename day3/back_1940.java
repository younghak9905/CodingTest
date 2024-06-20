package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());
        int M  = Integer.parseInt(br.readLine());
        long [] A=new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++)
        {
            A[i]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);  //O(nlogn) 시간 복잡도
        int count=0;
        int i=0;
        int j=N-1;
        long sum=0;
        while(i<j)
        {
            sum=A[i]+A[j];
            if(sum==M)
            {
                count++;
                j--;
                i++;
            }else if(sum>M) {j--;}
            else if(sum<M) {i++;}

        }
        System.out.println(count);

    }
}
