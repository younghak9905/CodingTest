import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_29700 {
	public static void main(String[] args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [][]theater = new int[N][M];
		int flag = 0;
		int result =0;
		for(int i=0;i<N;i++)
		{
			String line = br.readLine();
			flag =0;
			for(int j=0;j<M;j++)
			{
				theater[i][j] = line.charAt(j) - '0';
				if(theater[i][j]==0 && flag==0)
				{
					flag = 1;
					if(flag==K) result++;
				}else if(theater[i][j]==0 && flag!=0)
				{
					flag++;
					if(flag>=K) result++;
				}
				else if(theater[i][j]==1)
				{
					flag = 0;
				}
			}
		}
		System.out.println(result);
	}
}
