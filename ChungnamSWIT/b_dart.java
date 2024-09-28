package ChungnamSWIT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_dart {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dart = new int[20]; // 20개의 점수 영역
		int aliceIndex = 0; // Alice가 20점에 해당하는 영역의 인덱스를 저장할 변수

		// 점수 배열을 입력받음
		for (int i = 0; i < 20; i++) {
			dart[i] = Integer.parseInt(st.nextToken());
			if (dart[i] == 20) {
				aliceIndex = i; // 20점이 적힌 영역의 인덱스
			}
		}

		// Alice의 점수 계산 (원형 배열을 고려)
		int leftIndex = (aliceIndex - 1 + 20) % 20;  // 왼쪽 인접 영역
		int rightIndex = (aliceIndex + 1) % 20;      // 오른쪽 인접 영역
		double average = (dart[aliceIndex] + dart[leftIndex] + dart[rightIndex]) / 3.0;
		if (average > 10.5) {
			System.out.println("Alice");
		} else if (average < 10.5) {
			System.out.println("Bob");
		} else {
			System.out.println("Tie");
		}

	}
}
