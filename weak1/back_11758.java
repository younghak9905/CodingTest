package weak1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11758 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] A = new int[3][2];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			A[i][0] = Integer.parseInt(st.nextToken());
			A[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(ccw(A));
	}

	public static int ccw(int [][]A)
	{
		int x1 = A[0][0];
		int y1 = A[0][1];
		int x2 = A[1][0];
		int y2 = A[1][1];
		int x3 = A[2][0];
		int y3 = A[2][1];
		int result = (x2-x1)*(y3-y2)-(y2-y1)*(x3-x2);
		if(result>0)
		{
			return 1; // 반시계
		}
		else if(result<0)
		{
			return -1; // 시계
		}
		else
		{
			return 0;// 일직선
		}
	}
}
