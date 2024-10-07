package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class back_9251 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String sq = br.readLine();
		String sq2 = br.readLine();
		char []arr1 = sq.toCharArray();
		char []arr2 = sq2.toCharArray();
		int []D = new int[27];
		int []D2 = new int[27];
		int result = 0;
		D[0]=0;

		for(int i= arr1.length;i>0;i--)
		{
			D[i]=Math.max(D[i-1],D[i]);
		}
		System.out.println(result);
	}
}
