package monthTravel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a_life {
	static int []A;
	static int []B;



	static int N,D,U;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		A = new int[N+1];
		B = new int[N+1];
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
		{
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
		{
			B[i] = Integer.parseInt(st.nextToken());
		}

		for(int j=1;j<=N;j++)
		{	int count=0;
			for(int i=1;i<=j;i++)
			{
				if(A[i]>B[i])
				{
					result+=B[i]+count;
					count-=D;
					System.out.println("roop: "+j+"B: "+i);
				}
				else {
					if((A[i]+(j-i)*U)<(B[i]-(j-i)*D))
					{

						result+=A[i]+count;
						count+=U;
						System.out.println("roop: "+j+"A: "+i);
					}
					else {
						result+=B[i]+count;
						count-=D;
						System.out.println("roop: "+j+"B: "+i);
					}
				}

			}
			sb.append(result).append("\n");
			result=0;
		}

		System.out.println(sb);
	}



}