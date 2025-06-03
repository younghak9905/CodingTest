import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class back_20916 {
	// “안녕한 정수” 후보를 미리 계산해 놓는 정적 배열
	// (12개만 존재한다: 202021, 20202021, 202002021, …, 202092021)
	private static final long[] BENIGNS = new long[] {
		202021L,
		20202021L,
		202002021L, 202012021L, 202022021L, 202032021L,
		202042021L, 202052021L, 202062021L, 202072021L,
		202082021L, 202092021L
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 1) 빈도수 맵 구축
			HashMap<Long, Integer> freq = new HashMap<>();
			for (int i = 0; i < n; i++) {
				long x = Long.parseLong(st.nextToken());
				freq.put(x, freq.getOrDefault(x, 0) + 1);
			}

			long totalCount = 0;

			// 2) 각 “안녕한 정수” S에 대해 two-sum 카운팅
			for (long S : BENIGNS) {
				// HashMap을 순회하면서 x + y = S인 경우 계산
				// 키들을 배열로 가져오면 (순차 접근) 더 편하다
				Long[] keys = freq.keySet().toArray(new Long[0]);

				for (Long x : keys) {
					long y = S - x;
					if (!freq.containsKey(y)) continue;

					if (x < y) {
						totalCount += (long) freq.get(x) * freq.get(y);
					} else if (x.equals(y)) {
						int c = freq.get(x);
						totalCount += (long) c * (c - 1) / 2;
					}
					// x > y인 경우는 이미 x < y 때 센 것이므로 무시
				}
			}

			sb.append(totalCount).append('\n');
		}

		System.out.print(sb.toString());
	}
}
