
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.*;

	public class b_layer {
		// 최대공약수(GCD)를 계산하는 함수

		public static long findMinGeneration(int[] layer) {
			// 우선순위 큐(Min-Heap) 생성
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			for (int num : layer) {
				minHeap.offer(num);
			}

			long generations = 0;
			int target = minHeap.peek();

			// 모든 값이 동일해질 때까지 반복
			while (true) {
				// 현재 최소값과 최대값을 가져와서 비교
				int min = minHeap.poll();
				int max = minHeap.peek() != null ? minHeap.peek() : min;

				if (min == max) {
					break;
				}

				// 세대에 따른 증가 값 적용
				int addValue = (generations % 2 == 0) ? 1 : 2;
				min += addValue;
				minHeap.offer(min);

				generations++;
			}

			return generations;
		}
		static  int getMaxValue(int[] arr) {
			int max = arr[0];
			for (int i = 1; i < arr.length; i++) {
				max = Math.max(max, arr[i]);
			}
			return max;
		}
		public static void main(String[] args) {
			// 테스트 예제
			int[] layer = {1, 1, 2, 4};
			long minGeneration = findMinGeneration(layer);
			System.out.println("Minimum generation: " + minGeneration);
		}
	}



