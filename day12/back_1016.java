package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1016 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long MIN= Long.parseLong(st.nextToken());
		long MAX= Long.parseLong(st.nextToken());
		boolean []A = new boolean[(int)(MAX-MIN+1)];
		for(long i=2;i*i<=MAX;i++)
		{
			long pow = i*i;
			long start = MIN/pow;
			if(MIN%pow!=0)
			{
				start++;
			}
			for(long j= start;pow*j<=MAX;j++)
			{
				A[(int)((j*pow)-MIN)]= true;
			}
		}
		int count=0;
		for(int i=0;i<=MAX-MIN;i++)
		{
			if(!A[i])
			{
				count++;
			}
		}
		System.out.println(count);

	}

}
