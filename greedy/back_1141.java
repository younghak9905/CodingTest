package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class back_1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(br.readLine());
        }
        Collections.sort(list);
        int count=N;
        for(int i=0;i<N-1;i++){
               int len = list.get(i).length();
               int len1 = list.get(i+1).length();
            if(len<=len1 && list.get(i).equals(list.get(i+1).substring(0,len)))
               {
                    count--;
               }

        }
        System.out.println(count);
    }
}
