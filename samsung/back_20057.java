package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_20057 {
	static int []dx = {-1,0,1,0};
	static int []dy=  {0,1,0,-1};
	static int [][]map;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		int count=0;
		StringTokenizer st;
		int x = (N+1)/2;
		int y = (N+1)/2;
		for(int i=1;i<=N;i++)
		{	st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
			{	int input = Integer.parseInt(st.nextToken());
				map[i][j]=input;
				count+=input;
			}
		}

		int i=0;
		int cnt=1;
		int nx=x;
		int ny=y;

		while(nx!=1 && ny!=1)
		{
			for(int j=0;j<2;j++)
			{
				for(int k=0; k<cnt;k++)
				{
					if(nx==1 && ny==1) {
						count(map,count);
						return;
					}
					nx +=dx[i];
					ny +=dy[i];

					move(i,nx,ny);
					look(map);

				}
				 i=(i+1)%4;

			}
			cnt++;
		}
		for(int j=1;j<=N;j++)
		{
			for(int k=1;k<=N;k++)
			{
				count-=map[j][k];
				System.out.print(map[j][k]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(count);

	}
	static void look(int[][]map)
	{
		for(int j=1;j<=N;j++)
		{
			for(int k=1;k<=N;k++)
			{
				System.out.print(map[j][k]+" ");
			}
			System.out.println();
		}System.out.println();
	}
	static void count(int[][]map,int count)
	{
		for(int j=1;j<=N;j++)
		{
			for(int k=1;k<=N;k++)
			{
				count-=map[j][k];
			}
		}
		System.out.println(count);
	}

	static void move(int dir,int nx,int ny)
	{
		int ax = nx+dx[dir];
		int ay = ny+dy[dir];
		int x = nx-dx[dir];
		int y = ny-dy[dir];
		int ndir=(dir+1)%4;
		int size = map[ny][nx];

		if(isPossible(nx,ny)) {
			if (isPossible(x + dx[ndir], y + dy[ndir]))
				map[y + dy[ndir]][x + dx[ndir]] +=(int)Math.ceil(map[ny][nx]/100);
			size-=(int)Math.ceil(map[ny][nx]/100);
			if (isPossible(x - dx[ndir], y - dy[ndir]))
				map[y - dy[ndir]][x - dx[ndir]] += map[ny][nx] / 100;
			size-=map[ny][nx] / 100;
			if (isPossible(nx + dx[ndir], ny + dy[ndir]))
				map[ny + dy[ndir]][nx + dx[ndir]] += (map[ny][nx] * 7) / 100;
			size-=(map[ny][nx] * 7) / 100;
			if (isPossible(nx - dx[ndir], ny - dy[ndir]))
				map[ny - dy[ndir]][nx - dx[ndir]] += (map[ny][nx] * 7) / 100;
			size-=(map[ny][nx] * 7) / 100;
			if (isPossible(nx + dx[ndir] * 2, ny + dy[ndir] * 2))
				map[ny + dy[ndir]*2][nx + dx[ndir]*2] += map[ny][nx]/50;
			size-=map[ny][nx]/50;
			if (isPossible(nx - dx[ndir] * 2, ny - dy[ndir] * 2))
				map[ny - dy[ndir]*2][nx - dx[ndir]*2] += map[ny][nx]/50;
			size-=map[ny][nx]/50;
			if (isPossible(ax + dx[ndir], ay + dy[ndir]))
				map[ay + dy[ndir]][ax + dx[ndir]] += map[ny][nx] / 10;
			size-=map[ny][nx] / 10;
			if (isPossible(ax - dx[ndir], ay - dy[ndir]))
				map[ay - dy[ndir]][ax - dx[ndir]] += map[ny][nx] / 10;
			size-=map[ny][nx] / 10;

			if (isPossible(ax + dx[dir], ay + dy[dir]))
				map[ay + dy[dir]][ax + dx[dir]] += map[ny][nx]/20;
			size-=map[ny][nx]/20;
			if (isPossible(ax, ay))
				map[ay][ax] += size;
			map[ny][nx]=0;
		}

	}

	static boolean isPossible(int x,int y)
	{
		if(x>=1 && x<=N && y>=1 && y<=N)
			return true;
		return false;

	}
	}

	//0 왼 1 아래 2 오 3 위
