import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class back_24511 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []qs =new int[N];
        int []init = new int[N];
        for(int i=0;i<N;i++)
        {
            qs[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            init[i]  = Integer.parseInt(st.nextToken());
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<N;i++)
        {
            if(qs[i]==0)
                dq.addLast(init[i]);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)
        {
            int a = Integer.parseInt(st.nextToken());
            dq.addFirst(a);
            int out = dq.removeLast();
            sb.append(out).append(' ');
        }
        System.out.println(sb);
    }
}
