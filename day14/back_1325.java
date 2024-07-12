package day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//효율적인 해킹 , BFS, 그래프


public class back_1325 {
    static Reader in = new Reader();
    static ArrayList<Integer>[] A;

    static int []result;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        StringBuilder st = new StringBuilder();
        int N = in.nextInt();
        int M = in.nextInt();
        A= new ArrayList[N+1];

        result = new int[N+1];

        for(int i=1;i<=N;i++)
        {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            A[s].add(e);
        }
        for(int i=1;i<=N;i++)
        {
            visited = new boolean[N+1];
            BFS(i);
        }
        int max=0;
        for(int i=1;i<=N;i++)
        {
            max = Math.max(max, result[i]);
        }
        for(int i=1;i<=N;i++)
        {
            if(result[i]==max)
            {
                st.append(i+" ");
            }
        }
        System.out.println(st);
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


    static void BFS(int v)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visited[v]=true;
        while(!queue.isEmpty())
        {
            int linkedNode = queue.poll();

            for(int i : A[linkedNode])
            {
                if(visited[i]==false)
                {
                    visited[i]=true;
                    result[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
