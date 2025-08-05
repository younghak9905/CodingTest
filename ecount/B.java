package ecount;

import java.io.*;
import java.util.*;

public class B {
	static long[]H;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = new long[N];
		for(int i=0; i<N;i++)
		{
			H[i]= Integer.parseInt(st.nextToken());
		}

		Map<Long,List<Integer>> map = new HashMap<>();
		for(int i=0;i<N;i++)
		{
			if(map.get(H[i])==null)
			{
				map.put(H[i],new ArrayList<>());
			}
			map.get(H[i]).add(i);
		}
		int count=0;

		for(long h:map.keySet())
		{
			List<Integer> positions = map.get(h);
			for(int i=0;i<positions.size()-1;i++)
			{
				int left = positions.get(i);
				int right = positions.get(i+1);
				if(isValid(left,right))
				{
					count++;
				}
			}
		}


		System.out.println(count);

	}
	static boolean isValid(int start,int end)
	{
		long max = H[start];
		for(int i=start+1;i<end;i++)
		{
			if(H[i]>=max)
			{
				return false;
			}
		}
		return true;
	}

}