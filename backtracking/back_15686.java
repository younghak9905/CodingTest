package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_15686 {
	static int N,M;
	static int [][]arr;
	static Stack<Integer> result = new Stack<Integer>();

	static ArrayList<map> chickenList = new ArrayList<map>();
	static ArrayList<map> houseList = new ArrayList<map>();
	static long min;
	static StringBuilder sb = new StringBuilder();

	static boolean []visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				int c = Integer.parseInt(st.nextToken());
				if(c==2)
					chickenList.add(new map(i,j));
				else if(c==1)
					houseList.add(new map(i,j));

			}
		}
		min = 1000000000;
		visit = new boolean[chickenList.size()+1];
		recur(0);
		System.out.println(min);
	}
	static class map
	{
		int x;
		int y;
		map(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	static void recur(int cnt)
	{
		if(cnt==M)
		{	int sum=0;
			for(int i=0;i<houseList.size();i++){
				map house = houseList.get(i);
				int min = 2 * N;
				for(int x:result) {
					map chicken = chickenList.get(x);
					int dist = Math.abs(chicken.x - house.x) + Math.abs(chicken.y - house.y);
					if(min>dist)
						min = dist;
				}
				sum+=min;
			}
			if(min>sum)
				min = sum;
		}
		for(int i=0;i<chickenList.size();i++)
		{
			if(!visit[i] && (result.isEmpty() || result.peek()<i))
			{
				visit[i] = true;
				result.push(i);
				recur(cnt+1);
				visit[i] = false;
				result.pop();
			}
		}
	}
}
