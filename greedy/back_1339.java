package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.util.PriorityQueue;



public class back_1339 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];

		int max = 0;
		for(int i=0;i<N;i++)
		{
			arr[i]=br.readLine();
			if(max<arr[i].length())
			{
				max=arr[i].length();
			}
		}
		int[][] alpha=new int[max+2][10];

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<arr[i].length();j++)
			{
				alpha[arr[i].length()-j][arr[i].charAt(j)-'A']++;
				alpha[max+1][arr[i].charAt(j)-'A']++;
			}
		}
		int k=9;

		for(int i=max;i>0;i--)
		{
			PriorityQueue<Alpha> queue = new PriorityQueue<>();
			for(int j=0;j<10;j++)
			{
				if(alpha[i][j]!=0)
				{
					queue.add(new Alpha(j,alpha[i][j],alpha[max+1][j]));
				}
			}
			while(!queue.isEmpty()) {
				Alpha a = queue.poll();
				if(alpha[0][a.index]==0)
				{
					alpha[0][a.index]=k;
					k--;
				}
			}
		}

		int result=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<arr[i].length();j++)
			{
				result+=(int)Math.pow(10,arr[i].length()-j-1)*alpha[0][arr[i].charAt(j)-'A'];
			}
		}
		System.out.print(result);

	}
	static class Alpha implements Comparable<Alpha> {
		int index;
		int count;
		int whole;

		public Alpha(int index, int count, int whole) {
			this.index = index;
			this.count = count;
			this.whole = whole;
		}

		@Override
		public int compareTo(Alpha o) {

			if (this.count == o.count) {
				return o.whole - this.whole;
			} else {
				return o.count - this.count;
			}
		}
	}


}
