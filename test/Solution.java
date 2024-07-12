package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

	public static int largestSubgrid(List<List<Integer>> grid, int maxSum) {
		int N = grid.size();
		long[][] S = new long[N+1][N+1];

		// 구간 합 배열 계산
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + grid.get(i-1).get(j-1);
			}
		}

		int start = 1;
		int end = N;
		int result = 0;

		while(start <= end) {
			int mid = start + (end - start) / 2;
			boolean found = true;
			long max =0;
			long sum=0;
			for(int i=mid; i<=N; i++) {
				for(int j=mid; j<=N; j++) {
					sum = S[i][j] - S[i-mid][j] - S[i][j-mid] + S[i-mid][j-mid];
					if(max<sum)
					{
						max=sum;
						if(max>maxSum)
						{
							found=false;
							break;
						}
					}
				}
				if(!found) {
					break;
				}
			}
			if(max <= maxSum) {
				found = true;
			}

			if(found) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return result;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));  // 표준 출력으로 설정

		int gridRows = Integer.parseInt(bufferedReader.readLine().trim());
		int gridColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> grid = new ArrayList<>();

		IntStream.range(0, gridRows).forEach(i -> {
			try {
				grid.add(
					Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList())
				);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int maxSum = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result.largestSubgrid(grid, maxSum);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
