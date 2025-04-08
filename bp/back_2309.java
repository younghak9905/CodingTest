package bp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class back_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int []tall = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++)
        {
            tall[i]=Integer.parseInt(br.readLine());
            sum+=tall[i];
        }
        int a=0,b=0;
        for(int i=0;i<8;i++)
        {
            for(int j=i+1;j<9;j++)
            {
                if(sum-tall[i]-tall[j]==100)
                {
                    a=i;
                    b=j;
                    break;
                }
            }
            if(a!=b)
            {
                break;
            }
        }
        for(int i=0;i<9;i++)
        {   if(i!=a && i!=b)
            {
                pq.add(tall[i]);
            }

        }
        while (!pq.isEmpty())
        {
            System.out.println(pq.poll());
        }
    }

}
