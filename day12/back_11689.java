package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_11689 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N= Long.parseLong(br.readLine());
		long result = N;
		for(long p=2;p<=Math.sqrt(N);p++)
		{
			if(N%p==0) //p가 N의 소인수 (2^4*3^3  이면 2,3)
			{
				result = result - result/p;
				while(N%p==0)
				{
					N/=p;
				}
			}
		}
		if(N>1)  //반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되느 ㄴ케이스
		{
			result =result-result/N;
		}
		System.out.println(result);
	}
}
