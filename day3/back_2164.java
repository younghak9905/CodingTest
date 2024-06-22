package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class back_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Deque<Integer> mydeque=new LinkedList<>();
        for(int i=1;i<=N;i++)
        {
            mydeque.addLast(i);
        }
        for(int i=1;mydeque.size()>1;i++)
        {
                if(i%2==0)
                {    Integer topElement = mydeque.pollFirst();
                     mydeque.offerLast(topElement);

                }else {
                    mydeque.removeFirst();
                }
        }
        System.out.println(mydeque.getFirst());
    }


}
