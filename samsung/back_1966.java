package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-->0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int []arr = new int[N];
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
            Deque<document> q = new LinkedList<>();
            for(int i=0;i<N;i++)
            {
                int x = Integer.parseInt(st.nextToken());
                q.add(new document(i, x));
                pq.add(x);
            }
            while(!q.isEmpty())
            {
                document temp=q.peek();
                int priority = temp.priority;
                int idx = temp.idx;
                int next = pq.peek();
                if(priority==next)
                {
                    q.poll();
                    pq.poll();
                    if(idx==M)
                    {
                        sb.append(N-q.size()).append("\n");
                        
                        break;
                    }
                }
                else
                {
                    q.addLast(q.poll());
                }
            }
            
        }
        System.out.println(sb.toString());
        

    }
    static class document
    {
          int idx;
          int priority;
          public document(int idx,int priority)
          {
              this.idx=idx;
              this.priority=priority;
          }
          
    }
    
    
}
