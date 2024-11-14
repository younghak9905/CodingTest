package day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11726 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		long D[] = new long[1000+1];
		D[1] =1;
		D[2]= 2;
		for(int i=3;i<=1000;i++)
		{
			D[i]=(D[i-2]+D[i-1])%10007;
		}
		System.out.println(D[N]);

	}
}
