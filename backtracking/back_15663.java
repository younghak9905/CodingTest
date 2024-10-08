package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_15663 {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> result = new Stack<Integer>();
    static HashSet<String> dup = new HashSet<String>();
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr= new int[N];
        visit = new boolean[N];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
           arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        recur(0);
        System.out.println(sb);

    }

    static void recur(int cnt)
    {
        if(cnt==M)
        {   StringBuilder temp = new StringBuilder();

            for(int x:result)
            {
                temp.append(x+" ");
            }
            if(dup.isEmpty() || !dup.contains(temp.toString()))
            {
                dup.add(temp.toString());
                sb.append(temp.toString());
                sb.append("\n");
            }

            return;
        }
        for(int i=0;i<N;i++)
        {
            if(visit[i]==false)
            {
                visit[i] = true;
                result.push(arr[i]);
                recur(cnt+1);
                visit[i] = false;
                result.pop();
            }
        }
    }
}
