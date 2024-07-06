package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_18185 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		long sum = 0;
		long m=0;
		for (int start = 0; start < N - 2; start++) {
			if(A[start+1]>A[start+2])
			{
				m=Math.min(A[start],A[start+1]-A[start+2]);
				sum+= 5*m;
				A[start]-=m;
				A[start+1]-=m;

			}

			if (A[start]>0 && A[start + 1] > 0 && A[start + 2] > 0) {
				m=Math.min(A[start],A[start+1]);
				sum += m*7;
				A[start]-=m;
				A[start + 1]-=m;
				A[start + 2]-=m;
			}
			if(A[start]>0){
				sum += A[start]*3;
				A[start]=0;

			}
		}

		if(A[N-2]>0 && A[N-1]>0)
		{
			m=Math.min(A[N-2],A[N-1]);
			sum += 5*m;
			A[N-1]-=m;
			A[N-2]-=m;
		}
		if(A[N-1]>0)
		{
			sum += A[N-1]*3;
		}
		else if(A[N-2]>0){
			sum += A[N-2]*3;
		}
		System.out.println(sum);
	}


}
