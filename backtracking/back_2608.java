package backtracking;


import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class back_2608 {
	static long pivot;
	static String pre;
	static Stack<Character> stack ;
	static StringBuilder sb= new StringBuilder();

	static long cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = br.readLine()) != null && !line.isEmpty()) {
			// 1) �� �� �Ǵ� EOF�� ����
			if (line.isEmpty()) {
				break;
			}

			// 2) �Է� �Ľ�
			 StringTokenizer st = new StringTokenizer(line);
			 pre = st.nextToken();
			 pivot = Long.parseLong(st.nextToken());
			 cnt=0;
			// 3) ���� �غ�
			sb.append(pre).append(" ").append(pivot).append(" = ");
			stack = new Stack<>();
			int len = pre.length();
			if (pivot > factorial(len)) {
				sb.append("No permutation");
			} else {

				// ���� ��� ȣ��� ���� ����
				recur(0, new boolean[len]);
			}
			sb.append("\n");
		}

		// ��� �� ���� ���
		System.out.print(sb);

	}

	static void recur(int len,boolean visited[]){
		if(len == pre.length())
		{
			cnt++;
			if(cnt == pivot) {

				for (char c : stack) {
					sb.append(c);
				}

			}
			return;
		}




		for(int i=0;i<pre.length() && cnt<pivot;i++)
		{

			if(visited[i]==false) {
				visited[i] = true;
				stack.push(pre.charAt(i));
				recur(len+1, visited);
				stack.pop();
				visited[i] = false;
			}

		}
	}

	public static long factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must be >= 0");
		}
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}



}
