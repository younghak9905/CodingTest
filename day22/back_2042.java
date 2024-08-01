package day22;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2042 {

    static long[]A;

    static int start_index;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int tree=1;
        for(int i=0;i<N;i++)
        {
            tree*=2;
            if(tree>=N)
            {
                break;
            }
        }
        A = new long[tree*2+1];
        start_index = tree-1;
        // for(int i=start_index+1;i<=start_index+N;i++)
        // {   st = new StringTokenizer(br.readLine());
        //     A[i]=Long.parseLong(st.nextToken());
        // }
        initTree(start_index);

        for(int i=0;i<M+K;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
           if(a==1)
           {
               update(start_index+b,c);
           }else if(a==2)
           {
               sum(b,(int)c);
           }
           else{
               return;
           }
        }
    }
    static public void initTree(int index)
    {
       while(index>=1)
       {
           A[index]+=A[2*index]+A[2*index+1];
           index--;
       }

    }
    static public void update(int index,long value)
    {   long temp =A[index];
        A[index]=value;
        long diff = value - temp;
        while(index>1)
        {
            A[index/2]+=diff;
            index/=2;
        }
    }
    static public void sum(int s, int e)
    {   long result = 0;
        int start = start_index+s;
        int end = start_index+e;
        while(start<=end)
        {
            if(start%2==1)
            {
                result+=A[start];
            }
            if(end%2==0)
            {
                result+=A[end];
            }
            start = (start+1)/2;
            end = (end-1)/2;
        }
        System.out.println(result);
    }

}
/*
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 4
 */