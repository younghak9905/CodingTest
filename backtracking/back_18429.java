package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_18429 {
    static int N,K;
    static int[]A;
    static int count =0;
    static Stack<Integer> result = new Stack<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visited  = new boolean[N];
        recur(0,visited );
        System.out.println(count);
    }
    static void recur(int cnt,boolean[] visited)
    {
        if(cnt==N)
        {
            int W = 500;
            boolean isValid=true;
            for(int i : result)
            {
                W-=K;
                W+=A[i];
                if(W<500) {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
                count++;
            return;
        }
        for(int i=0;i<N;i++)
        {
            if(!visited[i])
            {   visited[i] = true;
                result.push(i);
                recur(cnt+1,visited);
                result.pop();
                visited[i] = false;
            }
        }
    }
}
