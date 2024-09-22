package GoriconOpenContest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_32298 {
	static int MAX =2000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		long A[] = new long[MAX+1];
		for(int i =1; i <=MAX; i++) {
			A[i] = i;
		}
		A[1] = 0;
		for(int i=2;i<=MAX;i++)
		{
			if(A[i]==0)
				continue;
			for(int j=i,k=1;j<=MAX;j=i*++k)
			{
				if(j==i)
					continue;
				A[j]=0;
			}
		}
		if(M%2==0)
		{
			for (int i = 0; i < N; i++) {
				sb.append(4 + M * i).append(" ");
			}
			System.out.println(sb);
			return;
		}
		int start = 1;
		while (start+M*(N-1)<=MAX) //등차수열의 최대 값
		{	if(A[start]== 0) //소수가 아닌지 확인
			{
				for (int i = 0; i < N; i++) {
					if(A[start + M * i] == 0)
						sb.append(start + M * i).append(" ");
					else {
						sb=new StringBuilder();
						break;
					}
					if(i==(N-1))
					{
						System.out.println(sb);
						return;
					}
				}

			}
			start++; //등차수열의 시작값
		}

			System.out.println(-1);

	}


}
