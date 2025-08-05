package data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class back_1270 {
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0;t<N;t++)
		{
			st= new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			HashMap<Long,Integer> map = new HashMap<>();
			for(int i=0;i<M;i++)
			{
				//
				long a = Long.parseLong(st.nextToken());
				map.put(a, map.getOrDefault(a, 0) + 1);

			}
			long result = -1;
			boolean flag = false;
			for(Map.Entry<Long, Integer> entry : map.entrySet())
			{
				if(entry.getValue()>M/2)
				{
					result = entry.getKey();
					flag = true;
					break;
				}
			}
			if(!flag)
			{
				sb.append("SYJKGW").append("\n");
			}
			else
			{
				sb.append(result).append("\n");
			}
		}
		System.out.print(sb);
	}
}
