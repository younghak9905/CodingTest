package weak0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//5. 소수의 연속합
public class back_1644 {
	static int A[];
	static int B[];
	static int target;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		target = Integer.parseInt(st.nextToken());

		A = new int[target+1];
		B= new int[target];
		int c=0;
		for(int i =1; i <=target; i++) {
			A[i] = i;
		}
		A[1] = 0;
		for(int i=2;i<=target;i++)
		{
			if(A[i]==0)
				continue;
			for(int j=i,k=1;j<=target;j=i*++k)
			{
				if(j==i) {
					B[c++] = j;
					continue;
				}
				A[j]=0;
			}
		}
		result = 0;
		search(c);
		System.out.println(result);

	}
	static void search(int c)
	{
		int temp = 0;
		int start =0;
		int end = 0;
		temp+=B[start];
		while(start<=end && end<c)
		{

			if(temp==target)
			{
				 result++;
				temp+=B[++end];
			}
			else if(temp>target)
			{
				temp-=B[start++];
			}
			else
			{
				temp+=B[++end];
			}
		}


	}


}
