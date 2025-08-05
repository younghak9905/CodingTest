package binary_search;

import java.util.*;
import java.io.*;

public class back_20115 {

	static int n;
	static int[] arr = new int[100000];
	static int min = Integer.MAX_VALUE;
	static int[] answer = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n - 1; i++) {
			int target = arr[i];
			binarySearch(i + 1, n - 1, target);
		}

		for (int a : answer) {
			System.out.print(a + " ");
		}
	}

	static void binarySearch(int left, int right, int target) {
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = Math.abs(arr[mid] + target);

			if (sum < min) {
				min = sum;
				answer[0] = target;
				answer[1] = arr[mid];
			}

			if (arr[mid] + target < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
	}
}