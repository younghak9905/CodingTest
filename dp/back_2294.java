package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_2294 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N + 1];
		int[] D = new int[K + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		//Arrays.sort(coin);
		for (int i = 0; i <= K; i++) {
			D[i] = 100001;
		}
		D[0] = 0;


		for (int i = 1; i <= N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				D[j] = Math.min(D[j], D[j - coin[i]] + 1);
			}
		}

		if (D[K] == 100001) {
			System.out.println(-1);
		} else {
			System.out.println(D[K]);
		}
	}
}
