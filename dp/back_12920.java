package dp;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_12920 {
	static int[][] item;
	static int[] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		D = new int[M + 1];
		item = new int[N + 1][3];
		ArrayList<item> items = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			for (int j = 1; j<=K; j *= 2) {
				items.add(new item(item[i][0]*j, item[i][1] * j));
			}

		}
		for (int i = 0; i < items.size(); i++) {

			for (int j = M; j >= items.get(i).w; j--) {
				D[j] = Math.max(D[j], D[j - items.get(i).w] + items.get(i).v);
			}

		}
		System.out.println(D[M]);
	}

	static class item{
		int w;
		int v;
		public item(int w, int v)
		{
			this.w=w;
			this.v=v;
		}
	}


}
