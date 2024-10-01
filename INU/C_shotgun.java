package INU;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_shotgun {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[][]arr = new char[4][10];
		for(int i=0;i<4;i++)
		{
			String s = br.readLine();
			arr[i] = s.toCharArray();
		}
		boolean visited[][] = new boolean[4][10];


		String a5 = st.nextToken();
		char[]check = a5.toCharArray();
		int k=9;
		while(k<9){
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<10;j++)
				{
					if(check[k]==arr[i][j])
					{
						visited[i][j]=true;
					}
				}
			}
		}
		for(int i=0;i<=4;i++)
		{
			for(int j=0;j<=10;j++)
			{
				if(visited[i][j]==true)
				{
					System.out.print(arr[i+1][j+1]);
				}
			}
		}

	}
}
