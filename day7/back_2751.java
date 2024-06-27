package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2751 {
    public static int[] A,tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
       A = new int[N+1];
       tmp = new int[N+1];
        for(int i=1;i<N+1;i++)
        {
            A[i]=Integer.parseInt(br.readLine());
        }
        merge(1,N);
        for(int i=1;i<N+1;i++)
        {
            sb.append(A[i]+"\n");
        }
        System.out.print(sb);


    }
    public static void merge(int s,int e)
    {
        if(e-s<1)
            return ;
        int m = s+(e-s)/2;
        merge(s,m);
        merge(m+1,e);
        for(int i=s;i<=e;i++)
        {
            tmp[i]=A[i];
        }
        int j=s;
        int index1=s;
        int index2=m+1;
        while(index1<=m&&index2<=e)
        {
            if(tmp[index1]<tmp[index2])
            {
                A[j++]=tmp[index1++];
            }
            else {
                A[j++]=tmp[index2++];
            }
        }
        while(index1<=m)
        {
            A[j++] = tmp[index1++];
        }
        while(index2<=e)
        {
            A[j++] = tmp[index2++];
        }
    }
}
