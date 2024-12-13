package iicpc_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_26107 {
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int []map = new int[N+1];
        List<int []> list = new ArrayList<>();

        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0]==o2[0])
            {
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });

        for(int i=1;i<=N;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            pq.add(new int[]{a,b});
            list.add(new int[]{a,b});
        }
        List<Integer> result = new ArrayList<>();
        int[] current = pq.poll();
       // result.add(current[0]);
        int size =pq.size();
        for(int i=0;i<size;i++)
        {
            int []next = pq.poll();

            if(current[1]>=next[0])
            {
                if(current[1]<next[1])
                {
                    current[1]=next[1];

                }
            }else
            {
                result.add(current[1]);
                current=next;
                result.add(current[0]);
            }
        }
        for(int i=0;i<result.size();i++)
        {
            System.out.print(result.get(i)+" ");
        }



       Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)
        {
            q.add(Integer.parseInt(st.nextToken()));
        }
        int []start = list.get(0);
        while(!q.isEmpty())
        {
            int next = q.poll();
            int [] s= list.get(next-1);




        }

    }
    static void find(int end, List<Integer> result)
    {
        for(int i=0;i<result.size();i++)
        {
            if(result.get(i)<=end)
            {
                result.remove(i);
                result.remove(i);
                return;
            }
        }
    }
    static class Edge {
        int start;
        int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    }
