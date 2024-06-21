package day3;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class back_11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> mydeque=new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) //초기 배열
        {
            long now=Long.parseLong(st.nextToken());
            while(!mydeque.isEmpty() && mydeque.getLast().value>now)
            {
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now,i));
            if(mydeque.getFirst().index<=i-L)
            {
                mydeque.removeFirst();
            }
           System.out.print(mydeque.getFirst().value+" ");
        }

    }

    static class Node
    {
        public long value;
        public int index;
        Node(long value,int index)
        {
            this.value=value;
            this.index=index;
        }
    }


}
