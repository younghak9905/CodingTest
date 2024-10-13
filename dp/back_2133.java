package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class back_2133 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []D = new int[31];
		D[2]=3;
		D[0]=1;
		for(int i=4;i<=N;i+=2)
		{
			D[i]=D[i-2]*3;
			for(int j=4;j<=i;j+=2)
			{
				D[i]+=D[i-j]*2;
			}

		}
		if(N%2==1)
		{
			System.out.println(0);
			return;
		}
		System.out.println(D[N]);
	}
}
