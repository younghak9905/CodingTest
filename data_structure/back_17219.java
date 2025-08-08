package data_structure;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class back_17219 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // Number of passwords
		int M = Integer.parseInt(st.nextToken()); // Number of queries

		HashMap<String,String> passwordMap = new HashMap<>();
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String password = st.nextToken();
			passwordMap.put(site, password);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++)
		{
			String site = br.readLine();
			sb.append(passwordMap.get(site)).append("\n");
		}
		System.out.print(sb.toString());
	}
}
