package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class back_14501 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] T = new int[N];
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());

        }
        int[] D = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            if (i + T[i] <= N) {
                D[i + T[i]] = Math.max(D[i + T[i]], D[i] + P[i]);
            }
            D[i + 1] = Math.max(D[i + 1], D[i]);
        }
        System.out.print(D[N]);
    }
}
//7
//3 10
//5 20
//1 10
//1 20
//2 15
//4 40
//2 200