package KaistHajeOpenContest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class back_32354 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int result=0;
        // 메모리 저장할 리스트 (deque의 상태를 저장)
        ArrayList<Deque<Integer>> memory = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        memory.add(new LinkedList<>());  // 0번째 상태는 빈 상태로 초기화

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();

            if (query.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
                memory.add(new LinkedList<>(deque));
              //  inMemory[i]=1+num;


            } else if (query.equals("restore")) {
                int num = Integer.parseInt(st.nextToken());

                if(num==0)
                {
                    deque = new LinkedList<>();
                }
                else if (num < i) {
                    deque = new LinkedList<>(memory.get(num));
                    memory.add(new LinkedList<>(deque));

                }
            } else if (query.equals("print")) {

                if (!deque.isEmpty()) {
                    for (Integer element : deque) {
                        result += element;
                    }
                }
                sb.append(result).append("\n");

            } else if (query.equals("pop")) {
                if (!deque.isEmpty()) {
                   deque.pollLast();
                }
                memory.add(new LinkedList<>(deque));
            }

        }

        System.out.println(sb);
    }

}
