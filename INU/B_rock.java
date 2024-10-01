package INU;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_rock {
	static int a,b,x,y,rx,ry,count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 a= Integer.parseInt(st.nextToken());
		 b= Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		 x = Integer.parseInt(st.nextToken());
		 y = Integer.parseInt(st.nextToken());
		 rx=0;
		 ry=0;
		 count = 0;


		 if(a!=0 && b!=0)
		 {
			 System.out.println("2");
			 return;
		 } else if (a == 0)
		 {
			 if(x==0 && y<b)
			 { System.out.println("3");
			     return;
			 }
			 System.out.println("1");
		 }else if(b==0)
		 {
			 if(y==0 && x<a)
			 {
				 System.out.println("3");
				 return;
			 }
			 System.out.println("1");
		 }



	}
	static void move(int a,int b)
	{
			count++;
			check();
	}
	static void check()
	{
		if(rx==x && ry==y)
		{
			System.out.println(count);
			System.exit(0);
		}
	}
}
