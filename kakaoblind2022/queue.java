package kakaoblind2022;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class queue {
    static Queue<Integer> q1;
    static Queue<Integer> q2;
    public int solution(int[] queue1, int[] queue2) {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }

        if((sum1+sum2)%2!=0)
        {
            return -1;
        }
        long total = (sum1 + sum2)/2;
        //printq();

        int count = 0;
        HashSet<int[]> set = new HashSet<>();
        set.add(queue1);
        while (!q1.isEmpty() && !q2.isEmpty()) {





            if (sum1 > total) {
                int a = q1.poll();
                q2.add(a);
                sum1 -= a;
                sum2 += a;
                count++;
                //set.add(q1.toArray());
            } else if (total < sum2) {
                int a = q2.poll();
                q1.add(a);
                sum1 += a;
                sum2 -= a;
                count++;
            } else {
                return count;
            }

            if(set.contains(q1.toArray()))
            {
                return -1;
            }
           // printq();
        }
        if(sum1!=total || sum2!=total)
            return -1;
        return count;



    }

    static void printq()
    {
        System.out.println();
        for(int a : q1)
        {
            System.out.print(a+" ");
        }

        System.out.println();

        for(int a : q2)
        {
            System.out.print(a+" ");
        }
    }
    public static void main(String[] args) {
        queue queue = new queue();
        int[] queue1 = {10,5,1}; // 시간 초과 케이스
        int[] queue2 = {2,2,2};
        System.out.println(queue.solution(queue1, queue2));
    }

}
