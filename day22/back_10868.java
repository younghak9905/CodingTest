package day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_10868 {
	static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int k = 1;
		for (int i = 0; i < N; i++) {
			k *= 2;
			if (k >= N) {
				break;
			}
		}
		tree = new long[k * 2 + 1];
		int start_index = k - 1;
		for(int i=0;i<tree.length;i++)
		{
			tree[i]=1000000001;
		}
		for (int i = start_index + 1; i <= start_index + N; i++) {
			st = new StringTokenizer(br.readLine());
			tree[i] = Long.parseLong(st.nextToken());
		}
		minTree(start_index);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			System.out.println(checkMin(s+start_index,e+start_index));
		}

	}
	static public void minTree(int index)
	{
		while(index>=1)
		{
			tree[index]=Math.min(tree[2*index],tree[2*index+1]);
			index--;
		}

	}
	static public long checkMin(int start, int end)
	{
		long result = 1000000000;

		while(start<=end)
		{
			if(start%2==1)
			{
				result=Math.min(result,tree[start]);
				start++;
			}
			if(end%2==0 )
			{
				result=Math.min(result,tree[end]);
				end--;
			}
			start = start/2;
			end = end/2;
		}
		return result;
	}
}
/*
10 4
75
30
100
38
50
51
52
20
81
5
1 10
3 5
6 9
8 10
*/
