package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1138 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[] result = new int[N+1];
		result[arr[0]]=1;
		for(int i=1;i<N;i++)
		{
			int index = arr[i]; //1  2

			int temp=0;
				for(int j=0;j<N ;j++)
				{
					if(result[j]==0)
					{
						if(index==0)
						{
							break;
						}else{
							index--;

						}
					}

					temp++;
				}
				result[temp]=i+1;

		}


		for(int i=0;i<N;i++)
		{
			System.out.print(result[i]+" ");
		}




	}
}
