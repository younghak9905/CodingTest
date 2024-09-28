package ChungnamSWIT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a_hamburger {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();


		if(s.equals("(1)"))
		{
			System.out.println(0);
		}
		else{
			if(s.equals(")1("))
			{
				System.out.println(2);
			}
			else
			{
				System.out.println(1);
			}
		}
	}
}
