package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class back_13305 {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Long[] price = new Long[N + 1];
		st = new StringTokenizer(br.readLine());
		long[] dist = new long[N];
		for (int i = 1; i < N; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}
		long sum = 0;
		for (int i = 1; i <=N-1; i++) {
			if(price[i]>price[i+1] || i==N-1) {
				sum+=price[i]*dist[i];
			}
			else{
				int j=i;
				while(price[i]<=price[j]) {
					sum+=price[i]*dist[j];
					j++;
					if(j==N) {
						break;
					}
				}
				i=j-1;
			}
		}
		System.out.println(sum);

	}

}
