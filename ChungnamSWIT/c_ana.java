package ChungnamSWIT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_ana {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		char []arr = s.toCharArray();
		int result = 0;
		int count = 0;

		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]=='A')
			{
				if(count==0)
				{
					count++;
				}
				else if(count==2)
				{
					result++;
					count=1;
				}
			}
			else if(arr[i]=='N')
			{
				if(count==1)
				{
					count++;
				}
				else if(count==2) //ANN
				{
					count=0;
				}

			}
		}
		System.out.println(result);
	}
}
