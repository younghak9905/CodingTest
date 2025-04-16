package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class back_1038 {
    static int N;

    static ArrayList<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N<=10)
        {
            System.out.println(N);
            return;
        }else if(N>=1023) //2^10 °æ¿ìšÃ ¼ö
        {
            System.out.println(-1);
            return;
        }
        for(int i=0;i<10;i++)
        {
            recur(i,1);
        }
        Collections.sort(list);
        System.out.println(list.get(N));

    }
    static void recur(long num ,int cnt) {
        if(cnt >10)
        {
            return;
        }
        list.add(num);
        for(int i=0;i<num%10;i++)
        {
            recur((num*10)+i,cnt+1);
        }


    }



}
