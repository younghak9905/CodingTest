package data_structure;

import java.io.*;
import java.util.*;
public class back_20920 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (s.length() < M) continue;
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((o1,o2)->{
			int len1 = o1.getKey().length();
			int len2 = o2.getKey().length();
			if(o1.getValue()==o2.getValue())
			{
				if(len1==len2)
				{
					return o1.getKey().compareTo(o2.getKey());
				}
				else{
					return len2-len1;
				}
			}
			return o2.getValue()-o1.getValue();
		});

		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String,Integer> entry : list)
		{
			sb.append(entry.getKey()).append("\n");
		}
		System.out.print(sb);

	}
}
