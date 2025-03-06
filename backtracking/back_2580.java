package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2580 {
	static int []dx = {0,0,1,-1};
	static int []dy = {1,-1,0,0};

	static int [][]map;
	static Queue<int []> queue;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		StringTokenizer st;
		for(int i=1;i<=9;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		sb = new StringBuilder();
		recur(1,1);
		System.out.println(sb);

	}

	static void recur(int x,int y)
	{
		if(y==10)
		{
			recur(x+1,1);
			return;
		}

		if(x==10)
		{
			for(int i=1;i<=9;i++)
			{
				for(int j=1;j<=9;j++)
				{
					sb.append(map[i][j] +" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0);
		}

		if (map[x][y] == 0) {
			for (int k = 1; k <= 9; k++) {
				if (check(x, y, k)) {
					map[x][y] = k;
					recur(x,y+1);

				}
			}
			map[x][y]=0;
			return;
		}
			recur(x,y+1);



	}


	static boolean check(int x,int y, int num)
	{
		for(int i=1;i<=9;i++)
		{
			if(map[x][i]==num)
				return false;
			if(map[i][y]==num)
				return false;
		}
		int nx = (x-1)/3;
		int ny = (y-1)/3;
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=3;j++)
			{
				if(map[nx*3+i][ny*3+j]==num)
					return false;
			}
		}
		return true;
	}

}
