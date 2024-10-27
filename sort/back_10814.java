package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_10814 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        PriorityQueue<Member> pq = new PriorityQueue<>((o1,o2)->{
            if(o1.age==o2.age)
            {
                return o1.index-o2.index;
            }else {
                return o1.age-o2.age;
            }
        });
        StringTokenizer st ;
        for(int i=0;i<N;i++)
        {   st =new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pq.add(new Member(age,name,i));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {   Member member = pq.poll();
            sb.append(member.age+" "+member.name).append("\n");
        }
        System.out.println(sb);
    }
    static class Member{
        int age;
        String name;
        int index;
        public Member(int age,String name,int index)
        {
            this.age=age;
            this.name=name;
            this.index=index;
        }
    }

    }
