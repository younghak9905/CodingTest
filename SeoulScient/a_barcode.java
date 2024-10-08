package SeoulScient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a_barcode {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		char arr[] = s.toCharArray();
		for (int i = 0; i < N; i++) {
			if (arr[i] >= 'Z')
				arr[i] = (char)(arr[i] - 32);
			else
				arr[i] = (char)(arr[i] + 32);
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}

}
