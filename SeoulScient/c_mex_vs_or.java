package SeoulScient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c_mex_vs_or {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int arr[] = new int[r-l+1];
		list.add(0);
		for(int i = 0; i <= r-l;i++)
		{
			arr[i] = (i+l)|x;
		}
		Arrays.sort(arr);
		for(int i = 0; i <=r-l; i++)
		{
			if(arr[i] != i)
			{
				System.out.println(i);
				return;
			}
		}
		System.out.println(r-l+1);


	}
}
