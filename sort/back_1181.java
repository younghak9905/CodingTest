package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class back_1181 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1,o2)->{
			if(o1.length()==o2.length())
			{
				return o1.compareTo(o2);
			}else
			{
				return o1.length()-o2.length();
			}
		});
		for(int i=0;i<N;i++)
		{
			String input = br.readLine();
			if(map.get(input)!=null)
			{
				continue;
			}
			map.put(input,i);
			priorityQueue.add(input);
		}
		StringBuilder sb = new StringBuilder();
		while(!priorityQueue.isEmpty())
		{
			sb.append(priorityQueue.poll()).append("\n");
		}
		System.out.print(sb);
	}
}
