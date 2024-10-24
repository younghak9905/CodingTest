package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class back_5648 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		long N = Integer.parseInt(first.split(" ")[0]);
		PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
		long count=0;
		String[] values = first.split(" ");
		for (int i = 1; i < values.length; i++) {  // i = 1부터 시작 (첫 번째는 N이기 때문에)
			if (!values[i].isEmpty()) {  // 빈 문자열이 아닌 경우 처리
					String reversedStr = new StringBuilder(values[i]).reverse().toString();
					priorityQueue.add(Long.parseLong(reversedStr));
					count++;
			}
		}
		while (count < N) {
			String line = br.readLine();
			String[] lineValues = line.split(" ");
			for (String s : lineValues) {
				if (!s.isEmpty()) {  // 빈 문자열이 아닌 경우 처리
					String reversedStr = new StringBuilder(s).reverse().toString();

						priorityQueue.add(Long.parseLong(reversedStr));
						count++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!priorityQueue.isEmpty()) {
			sb.append(priorityQueue.poll()).append("\n");
		}
		System.out.print(sb);

	}

}
