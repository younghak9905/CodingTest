package day14;

import java.util.ArrayList;

public class back_1707 {

    static Reader in = new Reader();
    static ArrayList<Integer>[] A;
    static boolean result;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        int N = in.nextInt();

        for(int i =0;i<N;i++)
        {
            result=true;
            int V= in.nextInt();
            int E = in.nextInt();
            A= new ArrayList[V+1];
            visited = new boolean[V+1];
            for(int k=1;k<=V;k++)
            {
                A[k] = new ArrayList<>();
            }
            for(int j=0;j<E;j++)
            {
                int s = in.nextInt();
                int e = in.nextInt();
                A[e].add(s);
                A[s].add(e);
            }
            for(int k=1;k<=V;k++)
            {

                if(!result)
                    break;
                else
                    DFS(k);

            }
            if(result)
            {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }
    }


    static void DFS(int v)
    {
        if(visited[v])
        {   result = false;
            return;
        }
        visited[v]=true;
        for(int i : A[v])
        {
            if(visited[i]==false)
            {
                DFS(i);
            }
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
