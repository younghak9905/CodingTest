package ChungnamSWIT;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class d_tps {
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
				angle+=90;
				angle=angle%360;

			}
			else if(s.equals("ML"))
			{
				angle-=90;
				angle=angle%360;

			}
			else{
				move(angle,s);
			}

			dir=angle;
			if(dir<0)
			{

				if(dir==-180)
				{
					c.x=p.x;
					c.y=p.y+1;
				}
				else {
					c.x=p.x-dx[(-dir+180)%360/90];
					c.y=p.y-dy[(-dir+180)%360/90];
				}
			}else{
				if(dir==180)
				{
					c.x=p.x;
					c.y=p.y+1;
				}else {
					c.x=p.x+dx[(dir+180)%360/90];
					c.y=p.y+dy[(dir+180)%360/90];
				}


			}

			sb.append(p.x+" "+p.y+" "+c.x+" "+c.y).append("\n");

		}
		System.out.println(sb);

	}
	static void move(int angle,String keyword)
	{	int dir;
		if(angle<0)
		{
			if(keyword.equals("D"))
			{
			   dir=(-angle+270);
			} else if (keyword.equals("A")) {
				dir = (-angle + 90);
			} else if(keyword.equals("S")){
				dir = (-angle + 180);
			}
			else {
				dir = -angle;
			}
			dir = dir%360;

			if(dir==-180)
			{
				p.x+=dx[dir/90];
				p.y+=dy[dir/90];
				return;
			}
			else {
				p.x-=dx[dir/90];
				p.y-=dy[dir/90];
			}



		}
		else{

			if(keyword.equals("D"))
			{
				dir=(angle+90);
			} else if (keyword.equals("A")) {
				dir = (angle + 270);
			} else if(keyword.equals("S")){
				dir = (angle + 180);
			}
			else {
				dir = angle;
			}
			dir = dir%360;
			if(dir==180)
			{
				p.x-=dx[dir/90];
				p.y-=dy[dir/90];

			}
			else {
				p.x+=dx[dir/90];
				p.y+=dy[dir/90];
			}

		}
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
