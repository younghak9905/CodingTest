package kakaowinterIntership2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mountain {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D[] = new int[N+1];
		D[1]=4;
		D[0]=1;
		for (int i = 2; i <= N; i++) {
			D[i]=(D[1]*D[i-1]-D[i-2])%10007;
		}
		System.out.println(D[N]);
	}
}
