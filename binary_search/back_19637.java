package binary_search;

import java.io.*;
import java.util.*;

public class back_19637 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		long [] arr = new long[N];

		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			String ch = st.nextToken();
			long num = Long.parseLong(st.nextToken());
			arr[i] = num;
			map.put(i, ch);
		}
		for(int i=0;i<M;i++)
		{
			long target = Long.parseLong(br.readLine());
			int index = binarySearch(arr, target);
			sb.append(map.get(index)).append("\n");
		}
		System.out.print(sb); // 결과 출력

	}

	public static int binarySearch(long[] arr, long target) {
		int low = 0, high = arr.length - 1;
		if (target <= arr[low]) {
			return low;
		}
		if (target >= arr[high]) {
			return high;
		}
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if(arr[mid] < target) {
				low =mid + 1;
			} else{
				high = mid -1;
			}
		}

		return low;

	}
}
