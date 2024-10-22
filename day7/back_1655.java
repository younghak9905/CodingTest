package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class back_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> sol = new PriorityQueue<>((o1, o2) -> o2 - o1);

        PriorityQueue<Integer> even = new PriorityQueue<>((o1, o2) -> o1 - o2);
        int input = 0;
        for(int i=1;i<=N;i++)
        {
                input = Integer.parseInt(br.readLine());
                if(sol.isEmpty())
                {
                    sol.add(input);
                }
                else if(even.isEmpty())
                {
                    if(sol.peek()>input)
                    {
                        even.add(sol.poll());
                        sol.add(input);
                    }else
                        even.add(input);


                }
                else if(even.peek()<input)
                {
                    even.add(input);
                    if(even.size()>sol.size()+1)
                        sol.add(even.poll());
                }
                else if(even.peek()>=input)
                {
                    sol.add(input);
                    if(sol.size()>even.size()+1)
                        even.add(sol.poll());
                }

                if(i%2==0)
                    sb.append(Math.min(sol.peek(), even.peek())).append("\n");
                else
                {
                    if(i==1)
                    {
                        sb.append(sol.peek()).append("\n");
                    }
                    else if(sol.size()>even.size())
                        sb.append(sol.peek()).append("\n");
                    else if(sol.size()<even.size())
                        sb.append(even.peek()).append("\n");
                }
        }
        System.out.println(sb);

    }

}
