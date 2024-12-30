package weak1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2166_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i][0] = Integer.parseInt(st.nextToken());
			A[i][1] = Integer.parseInt(st.nextToken());
		}
		double result = calculate(A);
		System.out.printf("%.1f\n",result);
	}

	static double calculate(int [][]points)
	{
		long sum=0;
		int n = points.length;
		for(int i=0;i<n;i++)
		{
			long x1 = points[i][0];
			long y1 = points[i][1];
			long x2 = points[(i+1)%n][0];
			long y2 = points[(i+1)%n][1];
			sum+=x1*y2-x2*y1;   //xn-1 * yn - xn * yn-1
		}
		return Math.abs(sum)/2.0;
	}
}
