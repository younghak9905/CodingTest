import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_3085 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for(int i=0;i<N;i++)
		{
			String str = br.readLine();
			for(int j=0;j<N;j++)
			{
				map[i][j] = str.charAt(j);
			}
		}
		int max = 0;
		for(int i=0;i<N;i++)
		{
			for(int j=1;j<N;j++)
			{
				if(map[i][j]!=map[i][j-1])
				{
					int temp = check(map,i,j,i,j-1,N);
					max = Math.max(max, temp);
				}
			}
		}

		for(int i=0;i<N;i++)
		{
			for(int j=1;j<N;j++)
			{
				if(map[j][i]!=map[j-1][i])
				{
					int temp = check(map,j,i,j-1,i,N);
					max = Math.max(max, temp);
				}
			}
		}
		System.out.println(max);
	}

	static int check(char[][] map,int x1,int y1,int x2,int y2,int N)
	{

		int result =0;
		int max =0;
		char temp = map[x1][y1];
		map[x1][y1]=map[x2][y2];
		map[x2][y2]=temp;

		for(int i=0;i<N;i++) {
			int count = 1;
			for(int j=1;j<N;j++)
			{
				if(map[i][j]==map[i][j-1]) {
					count++;
				}else
				{
					max = Math.max(max, count);
					count=1;
				}
				max = Math.max(max, count);
			}

		}
		for(int i=0;i<N;i++) {
			int count = 1;
			for(int j=1;j<N;j++)
			{
				if(map[j][i]==map[j-1][i]) {
					count++;
				}else
				{
					max = Math.max(max, count);
					count=1;
				}
			}
			max = Math.max(max, count);
		}

		temp = map[x1][y1];
		map[x1][y1]=map[x2][y2];
		map[x2][y2]=temp;
		return max;

	}
}
