package dp;

import java.util.*;
import java.io.*;
public class back_11053 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []arr = new int[N];
		int []length = new int[N];
		for (int i= 0; i< N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int result=1;
		for (int i= 0; i < N; i++){
			length[i] = 1;
			for (int j = 0; j < i; j++){
				if(arr[j] < arr[i]){
					length[i] = Math.max(length[i], length[j] + 1);
				}
			}
			result = Math.max(result, length[i]);
		}
		System.out.print(length[N-1]);

	}
}