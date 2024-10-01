package kakaoblind2023;


import java.util.ArrayList;

public class delivery {

}

class Solution {

	static int N,caps;
	static long result;
	static int []del;
	static int []pick;
	static int []box;

	static ArrayList<Integer> dlist = new ArrayList<>();
	static ArrayList<Integer> plist = new ArrayList<>();
	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		N = n;
		del = deliveries;
		pick = pickups;
		caps = cap;
		box = new int[n + 1];
		result = 0;

		for (int i = N - 1; i >= 0; i--) {
			if (del[i] != 0) {
				dlist.add(i);
			}
			if (pick[i] != 0) {
				plist.add(i);
			}
		}
		while (true) {
			int lastDelivery = dlist.isEmpty() ? 0 : dlist.get(0)+1;
			int lastPickup = plist.isEmpty() ? 0 : plist.get(0)+1;
			if (lastDelivery == 0 && lastPickup == 0) {
				return result;
			}

			result += (long)Math.max(lastDelivery, lastPickup) * 2;
			int capacity = cap;
			for (int i = 0; i<dlist.size();) {
				int idx = dlist.get(i);
				if (deliveries[idx] <= capacity) {
					capacity -= deliveries[idx];
					deliveries[idx] = 0;
					dlist.remove(i);
				} else {
					deliveries[idx] -= capacity;
					break;

				}

			}
			capacity = cap;
			for (int i = 0; i< plist.size();) {
				int idx = plist.get(i);
				if (pickups[idx] <= capacity) {
					capacity -= pickups[idx];
					pickups[idx] = 0;
					plist.remove(i);
				} else {
					pickups[idx] -= capacity;
					break;
				}
			}
		}

	}



	public static void main(String[] args) {
		// 예시 1
		int cap1 = 4;
		int n1 = 5;
		int[] deliveries1 = {1, 0, 3, 1, 2};
		int[] pickups1 = {0, 3, 0, 4, 0};
		System.out.println(solution(cap1, n1, deliveries1, pickups1));  // 출력: 16

		// 예시 2
		int cap2 = 2;
		int n2 = 7;
		int[] deliveries2 = {1, 0, 2, 0, 1, 0, 2};
		int[] pickups2 = {0, 2, 0, 1, 0, 2, 0};
		System.out.println(solution(cap2, n2, deliveries2, pickups2));  // 출력: 30
	}
}
