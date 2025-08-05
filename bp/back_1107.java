package bp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1107 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean []button = new boolean[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++)
		{
			button[Integer.parseInt(st.nextToken())] =true;
		}
		int result =Math.abs(N-100);

		for(int i=0;i<=99999;i++)

		{
			String num = String.valueOf(i);

			boolean isBreak = false;
			for(int j=0;j<num.length();j++)
			{
				if(button[num.charAt(j)-'0'])
				{
					isBreak = true;
					break;
				}
			}
			if(!isBreak)
			{
				int min = Math.abs(N-i)+num.length();
				result= Math.min(min,result);
			}
		}
		System.out.println(result);


	}
}
