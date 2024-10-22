package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class back_9251 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String sq = br.readLine();
		String sq2 = br.readLine();
		int sq_len = sq.length();
		int sq2_len = sq2.length();


		char []arr1 = new char[sq_len+1];
		char []arr2 = new char[sq2_len+1];

		for(int i=1;i<=sq_len;i++)
		{
			arr1[i]=sq.charAt(i-1);
		}
		for(int i=1;i<=sq2_len;i++)
		{
			arr2[i]=sq2.charAt(i-1);
		}

		int [][]D = new int[sq2_len+1][sq_len+1];



		for(int i=1;i<=sq2_len;i++)
		{
			for(int j=1;j<=sq_len;j++)
			{
				if(arr2[i]==arr1[j])
					D[i][j]=D[i-1][j-1]+1;
				else
					D[i][j]=Math.max(D[i-1][j], D[i][j-1]);
			}
		}
		System.out.println(D[sq2_len][sq_len]);
	}
}
