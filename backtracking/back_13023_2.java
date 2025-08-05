package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_13023_2 {
    static ArrayList<Integer>[] list;
    static int N,M;
    static int result =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=0;i<N;i++)
        {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for(int i=0;i<N;i++)
        {
            if(list[i].size()>0)
            {   boolean []visited = new boolean[N+1];
                visited[i] = true;
                recur(i , 0 ,visited);
                if(result == 1) {
                    break; // Early exit if a valid path is found
                }
            }
        }
        System.out.println(result);

    }

    static void recur(int idx , int cnt , boolean[] visited)
    {
        if(cnt==4)
        {
            result=1;
            return;
        }
        for(int a : list[idx])
        {
            if(!visited[a])
            {
                visited[a] = true;
                recur(a , cnt + 1, visited);
                visited[a] = false;
            }
        }
    }
}
