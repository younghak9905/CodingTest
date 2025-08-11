package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1244 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []arr = new int[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]= Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(sex==1)
			{
				man(arr,num);
			}else{
				woman(arr,num);
			}
		}
		for(int i=1;i<=N;i++)
		{
			System.out.print(arr[i] + " ");
			if(i % 20 == 0) {
				System.out.println(); // Print a new line every 20 switches
			}
		}
	}
	static void man(int []arr,int num)
	{
		for(int i=1;i<arr.length;i++)
		{
			if(i%num==0)
			{
				arr[i] = arr[i]==0 ? 1 : 0; // Toggle the switch
			}
		}
	}

	static void woman(int []arr,int num)
	{
		arr[num] = arr[num] == 0 ? 1 : 0; // Toggle the switch at the given index
		int left = num-1;
		int right = num+1;
		while(left>=1 && right<arr.length)
		{
			if(arr[left]==arr[right]) {
				arr[left] = arr[left] == 0 ? 1 : 0; // Toggle the switch
				arr[right] = arr[right] == 0 ? 1 : 0; // Toggle the switch
				left--;
				right++;
			} else {
				break; // Stop if the switches are not the same
			}
		}
	}
}
