package day22;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2042 {

    static long[]A;

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
        A = new long[tree*2];
        int start_index = tree;
        for(int i=start_index;i<start_index+N;i++)
        {   st = new StringTokenizer(br.readLine());
            A[i]=Long.parseLong(st.nextToken());
        }
        initTree(start_index-1);
        for(int i=0;i<tree*2;i++)
        {
            System.out.print(A[i]);
        }

        int result = 0;
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
               int start = start_index+b;
               int end = start_index+(int)c;
               while(start<end)
               {
                   if(start%2==1)
                   {
                       result+=A[start];
                   }
                   if(end%2==1)
                   {
                       result+=A[end];
                   }
                   start = (start+1)/2;
                   end = (end-1)/2;
               }
               sb.append(result+"\n");
               result =0;
           }
        }
        System.out.println(sb);
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
    {
        A[index]=value;
        while(index!=1)
        {
            A[index/2]+=value;
            index/=2;
        }
    }
    static class Reader {
        final int SIZE = 1 << 13;
        byte[] buffer = new byte[SIZE];
        int index, size;

        int nextInt() throws Exception {
            int n = 0;
            byte c;
            while ((c = read()) <= 32)
                ;
            do
                n = (n << 3) + (n << 1) + (c & 15);
            while (isNumber(c = read()));
            return n;
        }

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        byte read() throws Exception {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0)
                    buffer[0] = -1;
            }
            return buffer[index++];
        }
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