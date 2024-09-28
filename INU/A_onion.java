package INU;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_onion {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int a_onion = 1;
		int b_onion = 1;
		int temp = 0;
		while(N-->0)
		{
			a_onion+=A;
			b_onion+=B;
			if(a_onion<b_onion)
			{
				temp = a_onion;
				a_onion = b_onion;
				b_onion = temp;
			}
			else if(a_onion==b_onion)
			{
				b_onion--;
			}
		}
		System.out.println(a_onion+" "+b_onion);

	}
}
