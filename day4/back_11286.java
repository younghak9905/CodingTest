package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>((o1,o2)->{
           int first_abs= Math.abs(o1);
           int second_abs=Math.abs(o2);
           if(first_abs==second_abs)
               return o1 > o2 ? 1 : -1;
           else
               return first_abs - second_abs;
        });

        for(int i=0;i<N;i++)
        {
            int request=Integer.parseInt(br.readLine());

            if(request==0)
            {
                if(que.isEmpty())
                  sb.append("0\n");
                else
                    sb.append(que.poll()+"\n");
            }
           else {
               que.add(request);
            }

        }
        System.out.print(sb);

    }
}
