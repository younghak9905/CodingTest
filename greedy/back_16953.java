package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_16953 {


	static long A,B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int depth = 0;
		for (int i = 1; i < B; i *= 2) {
			depth++;
		}
		System.out.println(bfs(A, B));
	}

	public static int bfs(long A, long B) {
		Queue<long[]> queue = new LinkedList<>();
		queue.add(new long[] { A, 1 }); // [현재 숫자, 연산 횟수]

		while (!queue.isEmpty()) {
			long[] current = queue.poll();
			long num = current[0];
			int count = (int) current[1];

			// B와 같으면 연산 횟수 반환
			if (num == B) {
				return count;
			}

			// 다음 연산: 곱하기 2
			long next1 = num * 2;
			if (next1 <= B) {
				queue.add(new long[] { next1, count + 1 });
			}

			// 다음 연산: 끝에 1 추가
			long next2 = num * 10 + 1;
			if (next2 <= B) {
				queue.add(new long[] { next2, count + 1 });
			}
		}

		// B를 만들 수 없는 경우
		return -1;
	}
}
