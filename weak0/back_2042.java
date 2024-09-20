package weak0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2042 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long []A = new long[N+1];
		for(int i=0;i<N;i++)
		{
			A[i]= Long.parseLong(br.readLine());
		}
		for(int i=0;i<M+K;i++)
		{
			st = new StringTokenizer(br.readLine());
			long a =  Long.parseLong(st.nextToken());
			long b =  Long.parseLong(st.nextToken());
			long c =  Long.parseLong(st.nextToken());
			if(a==1)
			{
				A[(int)b-1]=c;
			}else if(a==2)
			{
				long sum=0;
				for(int j=(int)b-1;j<c;j++)
				{
					sum+=A[j];
				}
				sb.append(sum).append("\n");
			}
		}
		System.out.println(sb);

	}
}
