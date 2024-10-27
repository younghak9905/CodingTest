package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_1826 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<Gs> station = new PriorityQueue<>((o1,o2)->{
            return o1.dis-o2.dis>0?1:-1;
        });
        int max =0;
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            station.add(new Gs(a,b));
        }
        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());

        int count=0;

        while(P<L)
        {
            while (!station.isEmpty() && station.peek().dis<=P)
            {
                fuels.add(station.poll().gas);
            }
            if(fuels.isEmpty())
            {
                System.out.println(-1);
                return;
            }
            count++;
            P+=fuels.poll();
        }
        System.out.println(count);
    }
    static class Gs
    {
        long dis;
        int gas;
        public Gs(long dis, int gas)
        {
            this.gas=gas;
            this.dis=dis;
        }
    }

}
