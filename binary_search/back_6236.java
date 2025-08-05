package binary_search;
import java.io.*;
import java.util.*;
public class back_6236 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int sum=0;
		int max=0;
		int []money = new int[N];
		for(int i=0;i<N;i++)
		{
			money[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, money[i]);
			sum += money[i];
		}
		int start = max;
		int end = sum;
		int result = 0;
		while(start <=end)
		{
			int mid = start + (end - start) / 2;
			if(check(money, mid, M)) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(result);

	}
	static boolean check(int []money, int mid, int M)
	{
		int cnt = 1;
		int sum = 0;
		int num=mid;
		for(int i=0;i<money.length;i++)
		{
			if(sum+money[i] > num)
			{
				cnt++;
				num = mid;
			}
			num -= money[i];
		}
		return cnt <= M;
	}


}
