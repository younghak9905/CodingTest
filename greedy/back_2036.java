package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.Stack;

public class back_2036 {
    static long result = 0;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N= Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++)
        {
            pq.add(Long.parseLong(br.readLine()));
        }

        Stack<Long> stack = new Stack<>();
        Stack<Long> pstack = new Stack<>();
        Stack<Long> zero = new Stack<>();
        while(!pq.isEmpty())
        {
            long num = pq.poll();
            if(num<0)
            {
                if(stack.isEmpty())
                {
                    stack.add(num);
                }
                else{
                    long temp = stack.pop();
                    result+=temp*num;
                }
            }else if(num==0) {
                zero.add(num);
            }else {
                if(!pstack.isEmpty()) {
                    long temp = pstack.peek();
                    if(temp+num>=temp*num)
                    {
                        result+=pstack.pop();
                        pstack.add(num);
                    }
                    else{
                        pstack.add(num);
                    }
                }
                else{
                    pstack.add(num);
                }

            }
        }
        while (!pstack.isEmpty())
        {
           if(pstack.size()>=3) {
               long a = pstack.pop();
               long b = pstack.pop();
               long c = pstack.pop();
               if (a * b >=b * c) {
                   result += a * b;
                   pstack.add(c);
               } else {
                   result += b * c;
                   pstack.add(a);
               }
           }else {
               long a = pstack.pop();
               if(pstack.isEmpty())
               {
                   result+=a;
               }
               else{
                   long b = pstack.pop();
                   result+=Math.max(a*b,a+b);
               }
           }

        }



        if(!stack.isEmpty())
        {
            if(zero.isEmpty())
            {
                result+=stack.pop();
            }
        }
        System.out.println(result);

    }
}
