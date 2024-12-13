package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_16987 {
    static int N,max=0;
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<Egg> eggs = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<N;i++)
        {   st=new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
          eggs.add(new Egg(s,w));
        }

        recur(0,new boolean[N]);

    }
    static void recur(int cnt,boolean[]visted)
    {
        if(cnt==N)
        {
            PriorityQueue<Egg> pq = new PriorityQueue<>((o1,o2)->{
                return o1.s - o2.s;
            });
            Egg start = eggs.get(0);
            for(int v: stack)
            {
                Egg next = eggs.get(v);
                start.s-=next.w;
                next.s-=start.w;
                if(start.s>0 && next.s>0)
                {
                    pq.add(start);
                    pq.add(next);
                }

            }

        }
        for(int i=1;i<N;i++)
        {
            if(!visted[i])
            {
                visted[i]=true;
                stack.push(i);
                recur(cnt+1,visted);
                stack.pop();
                visted[i]=false;

            }
        }
    }
    static class Egg{
        int s;
        int w;
        public Egg(int s,int w)
        {
            this.s=s;
            this.w=w;
        }
    }
    }
//3   N
//8 5  S W
//1 100
//3 5