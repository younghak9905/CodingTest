package weak1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_17386 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long x3 = Long.parseLong(st.nextToken());
		long y3 = Long.parseLong(st.nextToken());
		long x4 = Long.parseLong(st.nextToken());
		long y4 = Long.parseLong(st.nextToken());

		int result1 = ccw(x1,y1,x2,y2,x3,y3)*ccw(x1,y1,x2,y2,x4,y4);
		int result2 = ccw(x3,y3,x4,y4,x1,y1)*ccw(x3,y3,x4,y4,x2,y2);

		if(result1<0 && result2<0)
		{
			System.out.println(1);
		}
		else
		{
			System.out.println(0);
		}

	}
	public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3)
	{
		return (x2-x1)*(y3-y2)-(y2-y1)*(x3-x2)>0?1:-1;
	}
}
