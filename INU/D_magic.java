package INU;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D_magic {
	static int maxX,minX,maxY,minY,resultx,resulty;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		resultx = -1;
		resulty = -1;
		maxX = -1;
		minX = N;
		maxY = -1;
		minY = N;
		int [][]map = new int[N+1][N+1];
		for(int i=0;i<M;i++)
		{	st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			map[x][y] = k;
			compos(x,y,k);
		}
		if(resultx==-1)
		{
			if(maxX==-1)
			{
				resultx = minX;
			}
			else {
				resultx = maxX;
			}
		}

		if(resulty==-1)
		{
			if(maxY==-1)
			{
				resulty = minY;
			}
			else {
				resulty = maxY;
			}
		}

		System.out.println(resultx+" "+resulty);




	}
	static void xUp(int x)
	{
		if(minX<=x)
		{
			minX = x+1;
		}
	}
	static void xDown(int x)
	{
		if(maxX>=x)
		{
			maxX = x-1;
		}
	}
	static void yUp(int y)
	{
		if(minY<=y)
		{
			minY = y+1;
		}
	}
	static void yDown(int y) {
		if (maxY >= y) {
			maxY = y - 1;
		}
	}

	static void compos(int x,int y,int k) {
		if (k == 1) {
			xDown(x);
			resulty = y;
			maxY=y;
			minY=y;
		} else if (k == 2) {
			xDown(x);
			yUp(y);
		} else if (k == 3) {
			minX=x;
			maxX=x;
			resultx = x;
			yUp(y);
		} else if (k == 4) {
			xUp(x);
			yUp(y);
		} else if (k == 5) {
			resulty = y;
			minY=y;
			maxY=y;
			xUp(x);

		} else if (k == 6) {

			xUp(x);
			yDown(y);
		} else if (k == 7) {
			resultx = x;
			minX=x;
			maxX=x;
			yDown(y);
		} else if (k == 8) {
			xDown(x);
			yDown(y);
		}
	}

}
