package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class back_2631_2
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []A = new int[N];
		for(int i=0;i<N;i++)
		{
			A[i]= Integer.parseInt(br.readLine());
		}
		ArrayList<Integer> D = new ArrayList<>();
		D.add(A[0]);
		int size = D.size()-1;

		for(int i=1;i<N;i++)
		{
			if(D.get(size)<A[i])
			{
				D.add(A[i]);
				size++;
			}else {
				int pos = binary_search(D,0,size,A[i]);
				D.set(pos,A[i]);
			}
		}
		System.out.println(N-D.size());


	}

	static int binary_search(ArrayList<Integer> D,int start,int end,int element)
	{
		while(start<end)
		{
			int mid = (start+end)/2;
			if(element>D.get(mid)) start = mid+1;
			else end = mid;
		}
		return end;
	}

}
