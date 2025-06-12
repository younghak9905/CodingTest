import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class back_20916 {
	// ���ȳ��� ������ �ĺ��� �̸� ����� ���� ���� �迭
	// (12���� �����Ѵ�: 202021, 20202021, 202002021, ��, 202092021)
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

			// 1) �󵵼� �� ����
			HashMap<Long, Integer> freq = new HashMap<>();
			for (int i = 0; i < n; i++) {
				long x = Long.parseLong(st.nextToken());
				freq.put(x, freq.getOrDefault(x, 0) + 1);
			}

			long totalCount = 0;

			// 2) �� ���ȳ��� ������ S�� ���� two-sum ī����
			for (long S : BENIGNS) {
				// HashMap�� ��ȸ�ϸ鼭 x + y = S�� ��� ���
				// Ű���� �迭�� �������� (���� ����) �� ���ϴ�
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
					// x > y�� ���� �̹� x < y �� �� ���̹Ƿ� ����
				}
			}

			sb.append(totalCount).append('\n');
		}

		System.out.print(sb.toString());
	}
}
