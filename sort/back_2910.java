package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2910 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long input;
		HashMap<Long,Integer> map  = new HashMap<>();
		HashMap<Long,Integer> mapIndex  = new HashMap<>();
		Queue<Long> queue = new PriorityQueue<>();
		PriorityQueue<Long> priorityQueue = new PriorityQueue<>((o1,o2)->{
			if(map.get(o1).equals(map.get(o2)))
			{
				return mapIndex.get(o1)-mapIndex.get(o2);
			}
			return map.get(o2)-map.get(o1);
		});
		for(int i=0;i<N;i++) {
			input = Long.parseLong(st.nextToken());
			if(map.get(input)==null)
				mapIndex.put(input, i);
			map.put(input, map.getOrDefault(input, 0) + 1);
			queue.add(input);
		}
		while (!queue.isEmpty()) {
			input = queue.poll();
			priorityQueue.add(input);
		}
		StringBuilder sb = new StringBuilder();
		while (!priorityQueue.isEmpty()) {
			sb.append(priorityQueue.poll()).append(" ");
		}
		System.out.println(sb);
	}
}
