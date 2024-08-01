package day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11505 {
	static long[] tree;
	static long MOD;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		MOD =1000000007;

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
			tree[i]=1;
		}
		for (int i = start_index + 1; i <= start_index + N; i++) {
			st = new StringTokenizer(br.readLine());
			tree[i] = Long.parseLong(st.nextToken());
		}
		initTree(start_index);

		for(int i=0;i<M+K;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1)
			{
				update(start_index+b,c);
			}else if(a==2)
			{
				sum(b+start_index,(int)c+start_index);
			}
			else{
				return;
			}
		}
	}

	static public void initTree(int index)
	{
		while(index>=1)
		{
			tree[index]*=tree[2*index]%MOD*tree[2*index+1]%MOD;
			index--;
		}

	}
	static public void update(int index,long value)
	{
		tree[index]=value;
		while(index>1)
		{	index/=2;
			tree[index]=tree[2*index]%MOD*tree[2*index+1]%MOD;
		}
	}

	static public void sum(int start, int end)
	{   long result = 1;
		while(start<=end)
		{
			if(start%2==1)
			{
				result=result*tree[start]%MOD;
				start++;
			}
			if(end%2==0)
			{
				result=result*tree[end]%MOD;
				end--;
			}
			start = start/2;
			end = end/2;
		}
		System.out.println(result);
	}
}
