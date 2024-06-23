package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class back_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int []A= new int[N];

        for(int i=0;i<N;i++)
        {
            A[i]=Integer.parseInt(br.readLine());
        }

        for(int i=0;i<N-1;i++)
        {   boolean swapped=false;
            for(int j=0;j<N-1-i;j++)
            {
                if(A[j]>A[j+1])
                {
                    int swap= A[j];
                    A[j]=A[j+1];
                    A[j+1]=swap;
                    swapped = true;

                }
            }
            if(!swapped)
            {
                break;
            }

        }
        for(int i=0;i<N;i++)
        {
            sb.append(A[i]+"\n");
        }
        System.out.print(sb);
    }
}
