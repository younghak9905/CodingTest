package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class back_11652 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<Long,Integer> map = new HashMap<>();
		long input=0;
		for(int i=0;i<N;i++)
		{
			input = Long.parseLong(br.readLine());
			map.put(input, map.getOrDefault(input, 0)+1);
		}
		int max=0;
		long key=0;
		for(Map.Entry<Long, Integer> entry : map.entrySet())
		{
			if(entry.getValue()>=max)
			{
				if(entry.getValue()==max && key<entry.getKey())
				{
					continue;
				}
				max=entry.getValue();
				key=entry.getKey();
			}
		}
		System.out.println(key);

	}
}
