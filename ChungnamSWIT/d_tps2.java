package ChungnamSWIT;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class d_tps2 {
	static Point p;
	static Point c;
	static int []dx = {0,1,0,-1};
	static int []dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int angle = 0;
		c = new Point(0,0);
		p = new Point(0,0);
		int dir;
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			if(s.equals("MR"))
			{
				angle+=1;
				angle=angle%4;

			}
			else if(s.equals("ML"))
			{
				angle+=3;
				angle=angle%4;

			}
			else{
				move(angle,s);
			}


			c.x=p.x+dx[(angle+2)%4];
			c.y=p.y+dy[(angle+2)%4];



			sb.append(p.x+" "+p.y+" "+c.x+" "+c.y).append("\n");

		}
		System.out.println(sb);

	}
	static void move(int angle,String keyword)
	{	int dir=angle;


			if(keyword.equals("D"))
			{
				dir=dir+1;
			} else if (keyword.equals("A")) {
				dir=dir+3;
			} else if(keyword.equals("S")){
				dir=dir+2;
			}
			dir = dir%4;

			p.x+=dx[dir];
			p.y+=dy[dir];


	}

	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}


}
