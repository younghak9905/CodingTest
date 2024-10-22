import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_1036 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String []s= new String[N];
		int []num = new int[N];

		int cnt =0;
		for(int i=0;i<N;i++)
		{
			s[i]=br.readLine();
			for(int j=s[i].length()-1;j>=0;j--)
			{
				if(s[i].charAt(j)>9)
				{
					cnt=s[i].charAt(j)-'A'+10;
				}
			}
		}
		int K = Integer.parseInt(br.readLine());
		System.out.println(cnt);


	}
}
