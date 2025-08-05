package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_4781
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = (int)(Double.parseDouble(st.nextToken())*100+0.5);
			while (N!=0 || K!=0)
			{

				int [][]item = new int[N+1][2];
				int []D= new int[K+1];
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				item[i][0] = Integer.parseInt(st.nextToken());
				item[i][1] = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);

				for(int j = item[i][1]; j<=K; j++)
				{
					D[j]=Math.max(D[j],D[j-item[i][1]]+item[i][0]);
				}
			}

			System.out.println(D[K]);
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = (int)(Double.parseDouble(st.nextToken())*100+0.5);

		}

	}
}
