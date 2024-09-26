package KaistHajeOpenContest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_32351 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		double S = Double.parseDouble(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		double time = 0;
		double []M = new double[N+2];
		M[1]=S;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			double B = Double.parseDouble(st.nextToken());
			M[A]=B;
		}
		int count=1;
		double temp=S;

		for(int i=2;i<=N+1;i++)
		{
			if(M[i]!=0 || i>N)
			{
				time+=getAverage(temp, count);
				temp=M[i];
				count=1;
			}
			else if(M[i]==0)
			{
				count++;
			}
		}
		System.out.printf("%.12f\n",time);
	}

	static double getAverage(double S, int N) {
		double bpm = S / 60.00;
		System.out.println(bpm);
		return (double)N*4/bpm;

	}
}

