package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bacK_14891 {
    static int[] dx ={1,-1};
    static ArrayList<RotatableArray> list;
    public static class RotatableArray {
        private int[] arr;
        int N;
        private int startIndex;

        public RotatableArray(int N) {
            this.N = N;
            arr = new int[N];
            startIndex = 0;
        }

        public void set(int i, int value)
        {
            arr[(startIndex+i)%N]=value;
        }

        public int get(int i)
        {
            return arr[(i+startIndex)%N];
        }

        public void rotateRight()
        {
            startIndex = (startIndex-1+N)%N;
        }

        public void rotateLeft()
        {
            startIndex = (startIndex+1)%N;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<RotatableArray>();

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            RotatableArray r = new RotatableArray(8);
            for (int j = 0; j < 8; j++) {
                r.set(j, line.charAt(j) - '0');
            }
            list.add(r);
        }
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<gear> q = new LinkedList<>();
            q.add(new gear(a-1,b));
            boolean[] visited = new boolean[5];
            while (!q.isEmpty()) {
                gear g = q.poll();
                int x = g.index;

                visited[x] = true;
                for (int j = 0; j < 2; j++) {
                    int nx = x + dx[j];
                    if (nx < 0 || nx > 3) continue;
                    if (!visited[nx]) {
                        if (x > nx) {
                            if (list.get(x).get(6) != list.get(nx).get(2)) {
                                q.add(new gear(nx,-g.rotate));
                            }
                            visited[nx] = true;
                        } else {
                            if (list.get(x).get(2) != list.get(nx).get(6)) {
                                q.add(new gear(nx,-g.rotate));
                            }
                            visited[nx] = true;
                        }

                    }
                }
                if (g.rotate== 1)
                    list.get(x).rotateRight();
                else
                    list.get(x).rotateLeft();
            }


        }
        int sum = 0;
        if (list.get(0).get(0) == 1) sum += 1;
        if (list.get(1).get(0) == 1) sum += 2;
        if (list.get(2).get(0) == 1) sum += 4;
        if (list.get(3).get(0) == 1) sum += 8;
        System.out.println(sum);

    }
    static class gear{
        int index;
        int rotate;
        public gear(int index, int rotate) {
            this.index = index;
            this.rotate = rotate;
        }
    }

}
