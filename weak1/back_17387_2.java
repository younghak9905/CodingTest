package weak1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_17387_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long x3 = Long.parseLong(st.nextToken());
		long y3 = Long.parseLong(st.nextToken());
		long x4 = Long.parseLong(st.nextToken());
		long y4 = Long.parseLong(st.nextToken());

		int ccw1=ccw(x1,y1,x2,y2,x3,y3);
		int ccw2=ccw(x1,y1,x2,y2,x4,y4);
		int ccw3=ccw(x3,y3,x4,y4,x1,y1);
		int ccw4=ccw(x3,y3,x4,y4,x2,y2);

		if(ccw1*ccw2<0 && ccw3*ccw4<0)
		{
			System.out.println(1);
			return;
		}

		if(ccw1*ccw2!=0 && ccw3*ccw4!=0)
		{
			System.out.println(0);
		}
		else
		{
			if(isInline(x1,y1,x2,y2,x3,y3)||
				isInline(x1,y1,x2,y2,x4,y4) ||
				isInline(x3,y3,x4,y4,x1,y1) ||
				isInline(x3,y3,x4,y4,x2,y2))
			{
				System.out.println(1);
			}else
				System.out.println(0);
		}


	}

	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3)
	{
		if((x2-x1)*(y3-y2)-(y2-y1)*(x3-x2)>0)
			return 1;
		else if((x2-x1)*(y3-y2)-(y2-y1)*(x3-x2)<0)
			return -1;
		else
			return 0;
	}
	static boolean isInline(long x1, long y1, long x2, long y2, long x3, long y3)
	{
		if(ccw(x1,y1,x2,y2,x3,y3)!=0)
		{
			return false;
		}
		return Math.min(x1, x2) <= x3 && x3 <= Math.max(x1, x2) &&
				Math.min(y1, y2) <= y3 && y3 <= Math.max(y1, y2);
	}
}
