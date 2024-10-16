package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class back_2565 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int []A = new int[501];
        int []D = new int[N+1];
        ArrayList<Edge> list = new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Edge(u,v));
        }

        Collections.sort(list, Comparator.comparingInt(edge -> edge.u));
        int result=0;
        D[0]=1;

        for(int i=1;i<N;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(list.get(i).v>list.get(j).v)
                {
                    if(D[j]>=D[i])
                    {
                        D[i]=D[j]+1;
                    }
                }
            }
            result = Math.max(result,D[i]);


        }
        for(int i=0;i<N;i++)
        {
            System.out.println(D[i]);
        }
        System.out.println(N-result);
    }
    static class Edge
    {
        int u;
        int v;
        Edge(int u, int v)
        {
            this.u = u;
            this.v = v;
        }
    }
}
