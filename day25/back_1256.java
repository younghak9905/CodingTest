package day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1256 {
	static long D[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int D[][] = new int[202][202];

		for (int i = 0; i <= 200; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == j) {
					D[i][j] = 1;
				} else {
					D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
					if (D[i][j] > 1000000000)
						D[i][j] = 1000000001;
				}

			}
		}
		if (D[N + M][M]< K) {
			System.out.println("-1");
		} else {
			while (!(N == 0 && M == 0)) {
				//a를 선택 했을 때 K값 보다 남은 경우의 수가 많다면 a를 그대로 사용
				if (D[N - 1 + M][M] >= K) {
					sb.append("a");
					N--;
				} else {
					sb.append("z");
					K = K - D[N - 1 + M][M];
					M--;
				}
			}
		}
		System.out.println(sb);
	}
}
