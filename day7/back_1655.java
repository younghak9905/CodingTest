package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class back_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queSec = new PriorityQueue<>((o1, o2) -> {
            int first_abs = o1;
            int second_abs = o2;

            return first_abs - second_abs;
        });
        PriorityQueue<Integer> queDesc = new PriorityQueue<>((o1, o2) -> {
            int first_abs = o1;
            int second_abs = o2;

            return second_abs - first_abs;
        });
        int[] A = new int[N];
        int[] tmp1 = new int[N];
        int[] tmp2 = new int[N];
        for (int i = 0; i < N; i++) {
            int j = 0;
            A[i] = Integer.parseInt(br.readLine());
            queSec.add(A[i]);
            queDesc.add(A[i]);
            if ((i + 1) % 2 == 0) {
                j = 0;
                for (int k = 0; k < (i + 1) / 2; k++) {
                     tmp1[j] = queSec.poll();
                    tmp2[j] = queDesc.poll();
                    j++;
                }
                if (queSec.peek() > queDesc.peek())
                    sb.append(queDesc.peek()+"\n");
                else
                    sb.append(queSec.peek());
                for (; j >= 0; j--) {
                    queSec.add(tmp1[j]);
                    queDesc.add(tmp2[j]);
                }
            } else {
                j=0;
                while (!(queDesc.peek() == queSec.peek())) {
                    tmp1[j] = queSec.poll();
                    tmp2[j] = queDesc.poll();
                    j++;
                }
                sb.append(queSec.peek() + "\n");
                for (; j >= 0; j--) {
                    queSec.add(tmp1[j]);
                    queDesc.add(tmp2[j]);
                }

            }

        }
        System.out.print(sb);
    }

}
