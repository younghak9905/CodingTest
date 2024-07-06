package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		long start = 1, end = K;
		long ans = 0;
		while (start <= end) {
			long middle = start + (end - start) / 2;
			long cnt = 0;
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(middle / i, N); //중간값 보다 작은 값의 개수와 배열의 크기중 작은것
			}
			if (cnt < K) {
				start = middle + 1;
			} else {
				ans = middle; //현재 단계의 중앙값을 정답 변수에 저장
				end = middle - 1;
			}
		}
		System.out.print(ans);
	}
}