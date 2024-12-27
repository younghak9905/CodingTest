package weak1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2987 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		double [][]triangle = new double[3][2];
		for(int i=0;i<3;i++)
		{	 st = new StringTokenizer(br.readLine());
			triangle[i][0] = Double.parseDouble(st.nextToken());
			triangle[i][1] = Double.parseDouble(st.nextToken());
		}
		int N = Integer.parseInt(br.readLine());
		double [][]tree = new double[N][2];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			tree[i][0] = Double.parseDouble(st.nextToken());
			tree[i][1] = Double.parseDouble(st.nextToken());
		}
		System.out.println(
			calculate(
				triangle[0][0],triangle[0][1],
				triangle[1][0],triangle[1][1],
				triangle[2][0],triangle[2][1])
				+"\n"
				+countPoint(triangle,tree)
		);
	}
	static double calculate(double x1, double y1, double x2, double y2, double x3, double y3)
	{
		return Math.abs((x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))/2);
	}

	static int countPoint(double[][] triangle, double[][] tree)
	{
		int count =0;
		for(int i=0;i<tree.length;i++)
		{
			double x = tree[i][0];
			double y = tree[i][1];
			double sum = calculate(triangle[0][0],triangle[0][1],triangle[1][0],triangle[1][1],x,y)+
					calculate(triangle[1][0],triangle[1][1],triangle[2][0],triangle[2][1],x,y)+
					calculate(triangle[2][0],triangle[2][1],triangle[0][0],triangle[0][1],x,y);
			if(sum == calculate(triangle[0][0],triangle[0][1],triangle[1][0],triangle[1][1],triangle[2][0],triangle[2][1]))
			{
				count++;
			}
		}
		return count;
	}
}
