package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class back_11656 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < s.length(); i++) {
            pq.add(s.substring(i, s.length()));
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    }
