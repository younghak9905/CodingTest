package graph;

import com.sun.source.tree.NewArrayTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_9372 {
    static ArrayList<Integer>[] airLine;
    static int depth=0;
    static boolean visited[];
    static int []A;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0)
        {
            st = new StringTokenizer(br.readLine());
           int N =  Integer.parseInt(st.nextToken());
           int M = Integer.parseInt(st.nextToken());
           visited = new boolean[N+1];
           airLine = new ArrayList[N+1];
           A = new int[N+1];
           for(int i=1;i<=N;i++)
           {
               airLine[i] = new ArrayList<>();
               A[i] = i;
           }
           for(int i=0;i<M;i++)
           {    st = new StringTokenizer(br.readLine());
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());
               airLine[a].add(b);
               airLine[b].add(a);
           }
           depth = 0;
           for(int i=1;i<=N;i++)
           {
               dfs(i);
           }
            System.out.println(depth);


        }

    }
    static void dfs(int a)
    {

        for(int next : airLine[a])
        {
            if(A[a]!=A[next])
            {
                union(a,next);
                depth++;
                dfs(next);
            }

        }
    }


   static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a!=b)
            A[b]=a;
    }
    static int find(int a)
    {
        if(A[a]==a)
            return a;
        else{
            return A[a]=find(A[a]);
        }
    }
}
