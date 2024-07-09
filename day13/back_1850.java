package day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1850 {
		public static void main(String[] args) throws Exception {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();

				long A=Long.parseLong(st.nextToken());
				long B=Long.parseLong(st.nextToken());
				long result =gcd(A,B);
				for(int i=0;i<result;i++)
				{
					sb.append(1);
				}
				System.out.println(sb);
		}
		public static long gcd(long a,long b)
		{
			if(b==0)
			{
				return a;
			}

			return gcd(b,a%b);
		}
	}

