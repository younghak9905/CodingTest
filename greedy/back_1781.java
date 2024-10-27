package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_1781 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Problem> pq = new PriorityQueue<>((o1,o2)->{
            if(o1.deadline==o2.deadline)
            {
                if(o1.size==o2.size)
                    return o1.index-o2.index;
                return o2.size-o1.size;
            }
            return o2.deadline-o1.deadline;
        });

        PriorityQueue<Problem> ramen = new PriorityQueue<>((o1,o2)->{
            if(o1.size==o2.size)
            {
                if(o1.deadline==o2.deadline)
                    return o1.index-o2.index;
                return o2.deadline-o1.deadline;
            }
            return o2.size-o1.size;
        });
        StringTokenizer st;
        for(int i=1;i<=N;i++)
        {
            st =new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            pq.add(new Problem(i,d,s));
        }
        long sum=0;
        int count=0;
       for(int i=200000;i>=1;i--){
          while(count<N && pq.peek().deadline==i)
          {
              ramen.add(pq.poll());
              count++;
              if(pq.isEmpty()) break;
          }
            if(ramen.isEmpty()) continue;
            sum+=ramen.poll().size;
       }
       System.out.println(sum);
    }
    static class Problem{
        int index;
        int deadline;
        int size;

        public Problem(int index,int deadline,int size)
        {
            this.index= index;
            this.deadline=deadline;
            this.size=size;
        }


    }
}
