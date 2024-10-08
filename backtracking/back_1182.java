package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_1182 {
    static int []arr;

    static int N,S,s;
    static boolean []visit;

    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> result = new Stack<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S= Integer.parseInt(st.nextToken());
        arr= new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        s=0;
        for(int i=1;i<=N;i++)
        {
            visit = new boolean[N];
            result.clear();
            recur(0,i);
        }


        System.out.println(s);


    }

    static void recur(int cnt,int count)
    {
        if(cnt==count)
        {   int sum=0;
            for(int x:result)
            {
                sum+=arr[x];
            }
            if(sum==S)
            {
               /* for(int x:result)
                {
                    System.out.print(x+" ");
                }
                System.out.println();*/
              s++;
            }
            return;
        }

        for(int i=0;i<N;i++)
        {
            if(!visit[i] && (result.isEmpty() || result.peek()<i))
            {
                visit[i]=true;
                result.push(i);
                recur(cnt+1,count);
                visit[i]=false;
                result.pop();
            }
        }

    }
}
