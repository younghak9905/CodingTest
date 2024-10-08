package SeoulScient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_max_queen {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		long result = 0;
		//가로
		result += (M-1)*N;
		//세로
		result += (N-1)*M;
		//대각선
		result += (N-1)*(M-1)*2;

		System.out.println(result);

	}
}
