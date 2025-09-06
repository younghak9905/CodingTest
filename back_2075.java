import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_2075 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        for(int i=1;i<=N;i++)
        {   st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++)
            {
               pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        int n=0;
        while (N-->0)
        {
         n  = pq.poll();
        }
        System.out.println(n);
    }
}
