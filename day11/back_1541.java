package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String []S = s.split("-");
		int sum=0;
			for(int i=0;i<S.length;i++) {
				int temp = toInteger(S[i]);
				if (i == 0)
					sum += temp;
				else
					sum-= temp;

			}
			System.out.println(sum);
	}
	static int toInteger(String a)
	{
		int sum=0;
		String []temp = a.split("[+]"); //+는 정규표현식 이기 때문에 [] 를 붙여줘서 문자라는 것을 인식 시켜야 한다.
		for(int i=0;i< temp.length;i++)
		{
			sum+=Integer.parseInt(temp[i]);
		}
		return sum;
	}
}
