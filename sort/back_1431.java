package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class back_1431 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1,o2)->{

			if(o1.length()==o2.length())
			{	int sum1=0;
				int sum2=0;
				for(int j=0;j<o1.length();j++)
				{
					if(o1.charAt(j)<='9')
					{
						sum1+=o1.charAt(j)-'0';
					}
				}
				for(int j=0;j<o2.length();j++)
				{
					if(o2.charAt(j)<='9')
					{
						sum2+=o2.charAt(j)-'0';
					}
				}
				if(sum1==sum2)
				{
					return o1.compareTo(o2);
				}
				return sum1>sum2?1:-1;
			}else
			{
				return o1.length()-o2.length();
			}
		});


		for(int i=0;i<N;i++)
		{
			priorityQueue.add(br.readLine());
		}

		while(!priorityQueue.isEmpty())
		{
			System.out.println(priorityQueue.poll());
		}
	}
}
