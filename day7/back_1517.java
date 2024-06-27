package day7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1517 {
    public static long[] A,tmp;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new long[N+1];
        tmp = new long[N+1];
        for(int i=1;i<N+1;i++)
        {
            A[i]=Long.parseLong(st.nextToken());
        }
        result=0;
        merge(1,N);

        System.out.print(result);


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
            if(tmp[index1]>tmp[index2])
            {    result = result+index2-j;
                A[j++]=tmp[index2++];
            }
            else {
                A[j++]=tmp[index1++];
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
