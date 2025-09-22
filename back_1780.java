import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1780 {
	static int [][]map;
	static int []cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		cnt = new int[3];
		for(int i=0;i<N;i++)
		{	st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0,0,N);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		System.out.println(cnt[2]);
	}
	static void divide(int r,int c,int size)
	{
		if(isSame(r,c,size))
		{
			cnt[map[r][c]+1]++;
			return;
		}
		int newSize = size/3;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				divide(r+i*newSize,c+j*newSize,newSize);
			}
		}
	}

	static boolean isSame(int r,int c,int size)
	{
		int val = map[r][c];
		for(int i=r;i<r+size;i++)
		{
			for(int j=c;j<c+size;j++)
			{
				if(map[i][j]!=val)
					return false;
			}
		}
		return true;
	}
}
